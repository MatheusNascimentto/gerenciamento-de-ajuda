package com.gerenciamento.solidariza.modules.doacao.repository;

import com.gerenciamento.solidariza.modules.doacao.model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
}
