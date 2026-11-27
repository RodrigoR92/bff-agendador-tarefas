package com.wora.bffagendador.controller;


import com.wora.bffagendador.business.TarefaService;
import com.wora.bffagendador.business.dto.request.TarefaDTORequest;
import com.wora.bffagendador.business.dto.response.TarefaDTOResponse;
import com.wora.bffagendador.business.enums.StatusNotificacaoEnum;
import com.wora.bffagendador.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "tarefas", description = "Cadastra tarefas de usuários")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    @Operation(summary = "Salva Tarefas de Usuarios", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TarefaDTOResponse> gravarTarefa(@RequestBody TarefaDTORequest request,
                                                          @RequestHeader(name = "Authorization",
                                                                  required = false) String token) {

        return ResponseEntity.ok(tarefaService.gravarTarefa(token, request));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca Tarefas por período", description = "Busca tarefa cadastrada por período")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<List<TarefaDTOResponse>> buscaListaTarefaPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token) {

        return ResponseEntity.ok(tarefaService.buscaTarefaAgendadaPorPeriodo(dataInicial, dataFinal,  token));
    }

    @GetMapping
    @Operation(summary = "Busca Lista de Tarefas por email de usuário",
            description = "Busca tarefas cadastradas por usuário")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Recurso nao encontrado")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<List<TarefaDTOResponse>> buscaListaTarefaPorEmail(
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.buscaTarefaPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta Tarefas por id", description = "Deleta tarefas cadastradas por id")
    @ApiResponse(responseCode = "200", description = "Tarefas deletadas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Recurso nao encontrado")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(name = "Authorization",
                                                          required = false) String token) {
        tarefaService.deletaTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera Status de tarefas", description = "Altera status da tarefa")
    @ApiResponse(responseCode = "200", description = "Status da tarefa alterada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Recurso nao encontrado")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TarefaDTOResponse> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                                     @RequestParam("id") String id,
                                                                     @RequestHeader(name = "Authorization",
                                                                             required = false) String token) {

        return ResponseEntity.ok(tarefaService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de Tarefas", description = "Altera dados da tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa alterada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Recurso nao encontrado")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TarefaDTOResponse> updateTarefa(@RequestBody TarefaDTORequest request,
                                                          @RequestParam("id") String id,
                                                          @RequestHeader(name = "Authorization",
                                                                  required = false) String token) {

        return ResponseEntity.ok(tarefaService.updateTarefa(request, id, token));
    }
}
