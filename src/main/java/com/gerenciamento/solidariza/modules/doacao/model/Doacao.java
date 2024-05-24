package com.gerenciamento.solidariza.modules.doacao.model;

import com.gerenciamento.solidariza.modules.doacao.dto.DoacaoRequest;
import com.gerenciamento.solidariza.modules.doacao.enums.StatusDoacao;
import com.gerenciamento.solidariza.modules.doacao.enums.TipoDoacao;
import com.gerenciamento.solidariza.modules.usuario.model.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doacao")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_doacao")
    private TipoDoacao tipoDoacao;
    @Size(max = 200)
    private String descricao;
    private LocalDate dataDoacao;
    @Column(name = "status_doacao")
    @Enumerated(EnumType.STRING)
    private StatusDoacao status;

    public static Doacao build(DoacaoRequest doacaoRequest, Usuario usuario) {
        return Doacao.builder()
                .tipoDoacao(doacaoRequest.getTipoDoacao())
                .descricao(doacaoRequest.getDescricao())
                .dataDoacao(doacaoRequest.getDataDoacao())
                .status(doacaoRequest.getStatus())
                .usuario(usuario)
                .build();
    }
}
