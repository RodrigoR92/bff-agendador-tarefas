package com.wora.bffagendador.infrastructure.client.config;

import com.wora.bffagendador.infrastructure.exception.BusinessExeption;
import com.wora.bffagendador.infrastructure.exception.ConflictExcepition;
import com.wora.bffagendador.infrastructure.exception.ResourceNotFoundException;
import com.wora.bffagendador.infrastructure.exception.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 409:
                return new ConflictExcepition("Erro atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");
            default:
                return new BusinessExeption("Erro de servidor");
        }
    }
}
