package com.gerenciamento.solidariza.modules.doacao.controller;

import com.gerenciamento.solidariza.modules.doacao.dto.DoacaoRequest;
import com.gerenciamento.solidariza.modules.doacao.dto.DoacaoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Doacao")
public interface DoacaoController {

    @Operation(summary = "Obter todas as doações",
            description = "Serviço responsável por listar todas as doações")
    @GetMapping("/doacao")
    ResponseEntity<List<DoacaoResponse>> getAllDoacoes();

    @Operation(summary = "Obter doação por ID",
            description = "Serviço responsável por obter uma doação pelo ID",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "ID da doação",
                            schema = @Schema(type = "integer"))
            })
    @GetMapping("/doacao/{id}")
    ResponseEntity<DoacaoResponse> getDoacaoById(@PathVariable("id") Long id);

    @Operation(summary = "Criar uma nova doação",
            description = "Serviço responsável por criar uma nova doação")
    @PostMapping("/doacao")
    ResponseEntity<DoacaoResponse> createDoacao(@RequestBody DoacaoRequest doacaoRequest);

    @Operation(summary = "Atualizar uma doação",
            description = "Serviço responsável por atualizar uma doação existente",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "ID da doação",
                            schema = @Schema(type = "integer"))
            })
    @PutMapping("/doacao/{id}")
    ResponseEntity<DoacaoResponse> updateDoacao(@PathVariable("id") Long id, @RequestBody DoacaoRequest doacaoRequest);

    @Operation(summary = "Excluir uma doação",
            description = "Serviço responsável por excluir uma doação existente",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "ID da doação",
                            schema = @Schema(type = "integer"))
            })
    @DeleteMapping("/doacao/{id}")
    ResponseEntity<Object> deleteDoacao(@PathVariable("id") Long id);
}
