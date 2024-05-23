package com.gerenciamento.solidariza.modules.doacao.controller.impl;

import com.gerenciamento.solidariza.modules.doacao.controller.DoacaoController;
import com.gerenciamento.solidariza.modules.doacao.dto.DoacaoRequest;
import com.gerenciamento.solidariza.modules.doacao.dto.DoacaoResponse;
import com.gerenciamento.solidariza.modules.doacao.model.Doacao;
import com.gerenciamento.solidariza.modules.doacao.service.DoacaoService;
import com.gerenciamento.solidariza.modules.usuario.model.Usuario;
import com.gerenciamento.solidariza.modules.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/solidariza")
public class DoacaoControllerImpl implements DoacaoController  {

    private final DoacaoService doacaoService;
    private final UsuarioService usuarioService;

    @Autowired
    public DoacaoControllerImpl(DoacaoService doacaoService, UsuarioService usuarioService) {
        this.doacaoService = doacaoService;
        this.usuarioService = usuarioService;
    }

    @Override
    public ResponseEntity<List<DoacaoResponse>> getAllDoacoes() {
        List<Doacao> doacoes = doacaoService.findAll();
        List<DoacaoResponse> doacaoResponses = doacoes.stream()
                .map(doacao -> DoacaoResponse.build(doacao, doacao.getId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(doacaoResponses);
    }

    @Override
    public ResponseEntity<DoacaoResponse> getDoacaoById(Long id) {
        return doacaoService.findById(id)
                .map(doacao -> ResponseEntity.ok(DoacaoResponse.build(doacao, doacao.getId())))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<DoacaoResponse> createDoacao(DoacaoRequest doacaoRequest) {
        Usuario usuario = usuarioService.findById(doacaoRequest.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Doacao doacao = Doacao.build(doacaoRequest, usuario);
        Doacao savedDoacao = doacaoService.save(doacao);
        return ResponseEntity.ok(DoacaoResponse.build(savedDoacao, usuario.getId()));
    }

    @Override
    public ResponseEntity<DoacaoResponse> updateDoacao(Long id, DoacaoRequest doacaoRequest) {
        return doacaoService.findById(id)
                .map(existingDoacao -> {
                    Usuario usuario = usuarioService.findById(doacaoRequest.getUsuarioId())
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

                    Doacao updatedDoacao = Doacao.build(doacaoRequest, usuario);
                    updatedDoacao.setId(existingDoacao.getId());
                    doacaoService.save(updatedDoacao);
                    return ResponseEntity.ok(DoacaoResponse.build(updatedDoacao, usuario.getId()));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Object> deleteDoacao(Long id) {
        return doacaoService.findById(id)
                .map(doacao -> {
                    doacaoService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
