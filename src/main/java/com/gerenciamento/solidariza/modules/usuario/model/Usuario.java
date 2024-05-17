package com.gerenciamento.solidariza.modules.usuario.model;

import com.gerenciamento.solidariza.modules.endereco.model.Endereco;
import com.gerenciamento.solidariza.modules.usuario.dto.UsuarioRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 100)
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 100)
    private String senha;
    @Column(name = "tipo_usuario")
    private String tipoUsuario; // Voluntário, Doador, Coordenador, Beneficiário
    @Size(max = 20)
    private String telefone;
    @Size(max = 200)
    @Embedded
    private Endereco endereco;

    public static Usuario build(UsuarioRequest usuarioRequest) {
        Endereco endereco = new Endereco(
                usuarioRequest.getRua(),
                usuarioRequest.getNumero(),
                usuarioRequest.getBairro()
        );

        return Usuario.builder()
                .nome(usuarioRequest.getNome())
                .email(usuarioRequest.getEmail())
                .senha(usuarioRequest.getSenha())
                .tipoUsuario(usuarioRequest.getTipoUsuario())
                .telefone(usuarioRequest.getTelefone())
                .endereco(endereco)
                .build();
    }
}
