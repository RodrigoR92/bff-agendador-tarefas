package com.wora.bffagendador.infrastructure.client.config;

import com.wora.bffagendador.infrastructure.exception.BusinessExeption;
import com.wora.bffagendador.infrastructure.exception.ConflictExcepition;
import com.wora.bffagendador.infrastructure.exception.ForbiddenException;
import com.wora.bffagendador.infrastructure.exception.IllegalArgumentException;
import com.wora.bffagendador.infrastructure.exception.ResourceNotFoundException;
import com.wora.bffagendador.infrastructure.exception.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        String menssagem = menssagemErro(response);

        switch (response.status()) {
            case 409:
                return new ConflictExcepition("Erro: " + menssagem);
            case 403:
                return new ForbiddenException("Erro: " + menssagem);
            case 404:
                return new ResourceNotFoundException("Erro: " + menssagem);
            case 401:
                return new UnauthorizedException("Erro: " + menssagem);
            case 400:
                return new IllegalArgumentException("Erro: " + menssagem);
            default:
                return new BusinessExeption("Erro: " + menssagem);
        }
    }

    private String menssagemErro(Response response) {
        try {
            if (Objects.isNull(response.body())) {
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
