package com.wora.bffagendador.infrastructure.exception;

public class BusinessExeption extends RuntimeException{

    public BusinessExeption(String message) {
        super(message);
    }

    public BusinessExeption(String message, Throwable throwable) {
        super(message, throwable);
    }
}
