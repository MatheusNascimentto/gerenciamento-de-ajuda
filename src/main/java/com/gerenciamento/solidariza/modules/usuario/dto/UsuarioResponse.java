package com.gerenciamento.solidariza.modules.usuario.dto;

import com.gerenciamento.solidariza.modules.usuario.model.Usuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String tipoUsuario;
    private String telefone;
    private String rua;
    private String numero;
    private String bairro;

    public static UsuarioResponse build(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .tipoUsuario(usuario.getTipoUsuario())
                .telefone(usuario.getTelefone())
                .rua(usuario.getEndereco() != null ? usuario.getEndereco().getRua() : null)
                .numero(usuario.getEndereco() != null ? usuario.getEndereco().getNumero() : null)
                .bairro(usuario.getEndereco() != null ? usuario.getEndereco().getBairro() : null)
                .build();
    }
}
