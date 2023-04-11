package com.deg.productservice.exception;

public class ClientAlreadyExistsException extends Exception {
    public ClientAlreadyExistsException(String msj) {
        super(msj);
    }
}
