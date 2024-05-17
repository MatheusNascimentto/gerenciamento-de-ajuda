package com.gerenciamento.solidariza.modules.endereco.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}
