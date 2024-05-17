package com.gerenciamento.solidariza.modules.endereco.dto;

import com.gerenciamento.solidariza.modules.endereco.model.Endereco;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoResponse {

    private String rua;
    private String numero;
    private String bairro;

    public static EnderecoResponse build(Endereco endereco) {
        return EnderecoResponse.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .bairro(endereco.getBairro())
                .build();
    }
}
