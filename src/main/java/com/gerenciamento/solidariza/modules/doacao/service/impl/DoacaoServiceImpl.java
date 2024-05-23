package com.gerenciamento.solidariza.modules.doacao.service.impl;

import com.gerenciamento.solidariza.modules.doacao.model.Doacao;
import com.gerenciamento.solidariza.modules.doacao.repository.DoacaoRepository;
import com.gerenciamento.solidariza.modules.doacao.service.DoacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DoacaoServiceImpl implements DoacaoService {

    private final DoacaoRepository doacaoRepository;

    @Autowired
    public DoacaoServiceImpl(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    @Override
    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    @Override
    public Optional<Doacao> findById(Long id) {
        return doacaoRepository.findById(id);
    }

    @Override
    public Doacao save(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    @Override
    public void deleteById(Long id) {
        doacaoRepository.deleteById(id);
    }
}
