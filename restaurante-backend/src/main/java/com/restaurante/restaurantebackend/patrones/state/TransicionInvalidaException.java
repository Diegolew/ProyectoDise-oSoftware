package com.restaurante.restaurantebackend.patrones.state;

public class TransicionInvalidaException extends RuntimeException {
    public TransicionInvalidaException(String message) {
        super(message);
    }
}
