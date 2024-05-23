package com.gerenciamento.solidariza.modules.usuario.dto;

import com.gerenciamento.solidariza.modules.doacao.dto.DoacaoResponse;
import com.gerenciamento.solidariza.modules.usuario.enums.TipoUsuario;
import com.gerenciamento.solidariza.modules.usuario.model.Usuario;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;
    private String telefone;
    private String rua;
    private String numero;
    private String bairro;
    private List<DoacaoResponse> doacoes;

    public static UsuarioResponse build(Usuario usuario, List<DoacaoResponse> doacoes) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .tipoUsuario(usuario.getTipoUsuario())
                .telefone(usuario.getTelefone())
                .rua(usuario.getEndereco() != null ? usuario.getEndereco().getRua() : null)
                .numero(usuario.getEndereco() != null ? usuario.getEndereco().getNumero() : null)
                .bairro(usuario.getEndereco() != null ? usuario.getEndereco().getBairro() : null)
                .doacoes(doacoes)
                .build();
    }
}
