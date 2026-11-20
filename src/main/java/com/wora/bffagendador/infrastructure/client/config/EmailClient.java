package com.wora.bffagendador.infrastructure.client.config;

import com.wora.bffagendador.business.dto.response.TarefaDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao_url}")
public interface EmailClient {

    void enviarEmail(@RequestBody TarefaDTOResponse response);
}
