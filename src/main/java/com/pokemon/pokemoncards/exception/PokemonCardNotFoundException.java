package com.pokemon.pokemoncards.exception;

public class PokemonCardNotFoundException extends RuntimeException {
    public PokemonCardNotFoundException(String message) {
        super(message);
    }
}
