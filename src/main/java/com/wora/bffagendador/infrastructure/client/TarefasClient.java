package com.wora.bffagendador.infrastructure.client;

import com.wora.bffagendador.business.dto.request.TarefaDTORequest;
import com.wora.bffagendador.business.dto.response.TarefaDTOResponse;
import com.wora.bffagendador.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${tarefa_url}")
public interface TarefasClient {

    @PostMapping
    TarefaDTOResponse gravarTarefa(@RequestBody TarefaDTORequest request,
                                   @RequestHeader("Authorization") String token);


    @GetMapping("/eventos")
    List<TarefaDTOResponse> buscaListaTarefaPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
             @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefaDTOResponse> buscaListaTarefaPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id,
                            @RequestHeader("Authorization") String token);


    @PatchMapping
    TarefaDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                              @RequestParam("id") String id,
                                              @RequestHeader("Authorization") String token);


    @PutMapping
    TarefaDTOResponse updateTarefa(@RequestBody TarefaDTORequest request,
                                   @RequestParam("id") String id,
                                   @RequestHeader("Authorization") String token);
}
