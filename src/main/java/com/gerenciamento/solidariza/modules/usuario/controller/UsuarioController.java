package com.gerenciamento.solidariza.modules.usuario.controller;

import com.gerenciamento.solidariza.modules.usuario.dto.UsuarioRequest;
import com.gerenciamento.solidariza.modules.usuario.dto.UsuarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Usuario")
public interface UsuarioController {

    @Operation(summary = "Buscar todos os usuários",
            description = "Serviço responsável por buscar todos os usuários do sistema")
    @GetMapping
    ResponseEntity<List<UsuarioResponse>> getAllUsuarios();

    @Operation(summary = "Buscar um usuário por ID",
            description = "Serviço responsável por buscar um usuário do sistema pelo ID",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "ID do usuário",
                            schema = @Schema(type = "integer"))
            })
    @GetMapping("/usuario/{id}")
    ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable("id") Long id);

    @Operation(summary = "Criar um novo usuário",
            description = "Serviço responsável por criar um novo usuário no sistema")
    @PostMapping
    ResponseEntity<UsuarioResponse> createUsuario(@RequestBody UsuarioRequest usuarioRequest);

    @Operation(summary = "Atualizar um usuário",
            description = "Serviço responsável por atualizar um usuário existente no sistema",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "ID do usuário",
                            schema = @Schema(type = "integer"))
            })
    @PutMapping("/usuario/{id}")
    ResponseEntity<UsuarioResponse> updateUsuario(@PathVariable("id") Long id, @RequestBody UsuarioRequest usuarioRequest);

    @Operation(summary = "Deletar um usuário",
            description = "Serviço responsável por deletar um usuário do sistema",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "ID do usuário",
                            schema = @Schema(type = "integer"))
            })
    @DeleteMapping("/usuario/{id}")
    ResponseEntity<Object> deleteUsuario(@PathVariable("id") Long id);
}
