package com.gerenciamento.solidariza.modules.usuario.service;

import com.gerenciamento.solidariza.modules.usuario.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByEmail(String email);

    Usuario save(Usuario usuario);

    void deleteById(Long id);
}
