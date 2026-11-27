package com.wora.bffagendador.infrastructure.exception;

public class IllegalArgumentException extends RuntimeException {

    public IllegalArgumentException(String menssagem) {
        super(menssagem);
    }

    public IllegalArgumentException(String menssagem, Throwable throwable) {
        super(menssagem, throwable);
    }
}
