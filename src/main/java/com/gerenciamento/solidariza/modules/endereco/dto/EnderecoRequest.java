package com.gerenciamento.solidariza.modules.endereco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    private String rua;
    private String numero;
    private String bairro;
}
