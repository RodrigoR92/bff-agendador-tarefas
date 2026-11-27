package com.wora.bffagendador.infrastructure.exception;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String menssagem) {
        super(menssagem);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}
