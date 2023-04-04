package com.getir.demo.exception;

public class GetirException extends RuntimeException {

    public GetirException(String message) {
        super(message);
    }

    public GetirException(String format, Object... args) {
        super(String.format(format, args));
    }
}
