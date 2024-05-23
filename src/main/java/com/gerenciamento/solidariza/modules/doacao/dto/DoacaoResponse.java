package com.gerenciamento.solidariza.modules.doacao.dto;

import com.gerenciamento.solidariza.modules.doacao.enums.StatusDoacao;
import com.gerenciamento.solidariza.modules.doacao.enums.TipoDoacao;
import com.gerenciamento.solidariza.modules.doacao.model.Doacao;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class DoacaoResponse {

    private Long id;
    private TipoDoacao tipoDoacao;
    private String descricao;
    private LocalDate dataDoacao;
    private StatusDoacao status;
    private Long usuarioId;

    public static DoacaoResponse build(Doacao doacao, Long userId) {
        return DoacaoResponse.builder()
                .id(doacao.getId())
                .tipoDoacao(doacao.getTipoDoacao())
                .descricao(doacao.getDescricao())
                .dataDoacao(doacao.getDataDoacao())
                .status(doacao.getStatus())
                .usuarioId(userId)
                .build();
    }
}
