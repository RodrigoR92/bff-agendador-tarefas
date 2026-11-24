package com.wora.bffagendador.infrastructure.exception;


public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String menssagem) {
        super(menssagem);
    }

    public UnauthorizedException(String menssagem, Throwable throwable) {
        super(menssagem, throwable);
    }
}
