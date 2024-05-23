package com.gerenciamento.solidariza.modules.doacao.service;

import com.gerenciamento.solidariza.modules.doacao.model.Doacao;
import java.util.List;
import java.util.Optional;

public interface DoacaoService {

    List<Doacao> findAll();

    Optional<Doacao> findById(Long id);

    Doacao save(Doacao doacao);

    void deleteById(Long id);
}
