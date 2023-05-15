package com.pokemon.pokemoncards.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.pokemoncards.model.dto.CardDto;
import com.pokemon.pokemoncards.model.entity.CardEntity;
import com.pokemon.pokemoncards.model.pojo.CardList;

import java.io.DataInput;
import java.io.IOException;



public class JsonToPojo {

    private static final ObjectMapper objectMapper = createMapper();
    private static ObjectMapper createMapper(){
        ObjectMapper initialObjectMapper = new ObjectMapper();
        initialObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return initialObjectMapper;
    }

    public static CardList parseJsonToObject(String input) throws IOException {
        return objectMapper.readValue(input, CardList.class);
    }


}
