package com.gerenciamento.solidariza.modules.usuario.dto;

import com.gerenciamento.solidariza.modules.usuario.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 100)
    private String senha;
    private TipoUsuario tipoUsuario;
    @Size(max = 20)
    private String telefone;
    @Size(max = 200)
    private String rua;
    @Size(max = 10)
    private String numero;
    @Size(max = 100)
    private String bairro;
}
