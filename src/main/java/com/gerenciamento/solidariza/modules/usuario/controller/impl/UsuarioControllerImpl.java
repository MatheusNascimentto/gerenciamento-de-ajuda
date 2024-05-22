package com.gerenciamento.solidariza.modules.usuario.controller.impl;

import com.gerenciamento.solidariza.modules.usuario.controller.UsuarioController;
import com.gerenciamento.solidariza.modules.usuario.dto.UsuarioRequest;
import com.gerenciamento.solidariza.modules.usuario.dto.UsuarioResponse;
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
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public ResponseEntity<List<UsuarioResponse>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioResponse> usuarioResponses = usuarios.stream()
                .map(UsuarioResponse::build)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarioResponses);
    }

    @Override
    public ResponseEntity<UsuarioResponse> getUsuarioById(Long id) {
        return usuarioService.findById(id)
                .map(usuario -> ResponseEntity.ok(UsuarioResponse.build(usuario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<UsuarioResponse> createUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = Usuario.build(usuarioRequest);
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(UsuarioResponse.build(savedUsuario));
    }

    @Override
    public ResponseEntity<UsuarioResponse> updateUsuario(Long id, UsuarioRequest usuarioRequest) {
        return usuarioService.findById(id)
                .map(existingUsuario -> {
                    Usuario updatedUsuario = Usuario.build(usuarioRequest);
                    updatedUsuario.setId(existingUsuario.getId());
                    usuarioService.save(updatedUsuario);
                    return ResponseEntity.ok(UsuarioResponse.build(updatedUsuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Object> deleteUsuario(Long id) {
        return usuarioService.findById(id)
                .map(usuario -> {
                    usuarioService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
