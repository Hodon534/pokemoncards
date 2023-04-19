package com.pokemon.pokemoncards.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonCardList
{
    @JsonProperty("data")
    private ArrayList<PokemonCard> pokemonCards;
    private long page;
    private long pageSize;
    private long count;
    private long totalCount;
}