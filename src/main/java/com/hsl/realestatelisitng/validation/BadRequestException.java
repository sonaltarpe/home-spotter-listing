package com.hsl.realestatelisitng.validation;

public class BadRequestException extends RuntimeException{

    public BadRequestException(final String message) {
        super(message);
    }
}
