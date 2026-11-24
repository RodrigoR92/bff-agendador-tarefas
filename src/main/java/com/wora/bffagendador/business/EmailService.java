package com.wora.bffagendador.business;

import com.wora.bffagendador.business.dto.response.TarefaDTOResponse;
import com.wora.bffagendador.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviarEmail(TarefaDTOResponse response) {
        emailClient.enviarEmail(response);
    }
}
