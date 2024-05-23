package com.gerenciamento.solidariza.modules.doacao.dto;

import com.gerenciamento.solidariza.modules.doacao.enums.StatusDoacao;
import com.gerenciamento.solidariza.modules.doacao.enums.TipoDoacao;
import lombok.Data;
import java.time.LocalDate;

@Data
public class DoacaoRequest {

    private TipoDoacao tipoDoacao;
    private String descricao;
    private LocalDate dataDoacao;
    private StatusDoacao status;
    private Long usuarioId;
}
