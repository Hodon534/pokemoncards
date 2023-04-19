package com.pokemon.pokemoncards.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.pokemoncards.model.pojo.PokemonCardList;

import java.io.IOException;

public class JsonToPojo {

    private static final ObjectMapper objectMapper = createMapper();
    private static ObjectMapper createMapper(){
        ObjectMapper initialObjectMapper = new ObjectMapper();
        initialObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return initialObjectMapper;
    }

    public static PokemonCardList parseJsonToObject(String input) throws IOException {
        return objectMapper.readValue(input, PokemonCardList.class);
    }
}
