package com.wora.bffagendador.business;


import com.wora.bffagendador.business.dto.request.TarefaDTORequest;
import com.wora.bffagendador.business.dto.response.TarefaDTOResponse;
import com.wora.bffagendador.business.enums.StatusNotificacaoEnum;
import com.wora.bffagendador.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasClient tarefasClient;

    public TarefaDTOResponse gravarTarefa(String token, TarefaDTORequest request) {
        return tarefasClient.gravarTarefa(request, token);
    }

    public List<TarefaDTOResponse> buscaTarefaAgendadaPorPeriodo(LocalDateTime dataInicial,
                                                                 LocalDateTime dataFinal,
                                                                 String token) {
        return tarefasClient.buscaListaTarefaPorPeriodo(dataInicial, dataFinal,  token);
    }

    public List<TarefaDTOResponse> buscaTarefaPorEmail(String token) {
        return tarefasClient.buscaListaTarefaPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefaDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefaDTOResponse updateTarefa(TarefaDTORequest request, String id, String token) {
        return tarefasClient.updateTarefa(request, id, token);
    }
}
