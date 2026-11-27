package com.wora.bffagendador.infrastructure.exception;

public class BusinessExeption extends RuntimeException{

    public BusinessExeption(String menssagem) {
        super(menssagem);
    }

    public BusinessExeption(String menssagem, Throwable throwable) {
        super(menssagem, throwable);
    }
}
