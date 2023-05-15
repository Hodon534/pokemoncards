package com.pokemon.pokemoncards.exception;

public class EmailNotValidException extends RuntimeException {

    public EmailNotValidException(String message) {
        super(message);
    }
}
