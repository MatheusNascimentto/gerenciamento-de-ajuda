package com.gerenciamento.solidariza.modules.endereco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    @NotBlank
    @Size(max = 100)
    private String rua;

    @NotBlank
    @Size(max = 10)
    private String numero;

    @NotBlank
    @Size(max = 100)
    private String bairro;
}
