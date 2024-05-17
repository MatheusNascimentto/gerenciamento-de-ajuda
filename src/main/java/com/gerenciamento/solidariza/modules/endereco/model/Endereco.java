package com.gerenciamento.solidariza.modules.endereco.model;

import com.gerenciamento.solidariza.modules.endereco.dto.EnderecoRequest;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @NotBlank
    @Size(max = 100)
    private String rua;
    @NotBlank
    @Size(max = 10)
    private String numero;
    @NotBlank
    @Size(max = 100)
    private String bairro;

    public static Endereco build(EnderecoRequest enderecoRequest) {
        return Endereco.builder()
                .rua(enderecoRequest.getRua())
                .numero(enderecoRequest.getNumero())
                .bairro(enderecoRequest.getBairro())
                .build();
    }
}
