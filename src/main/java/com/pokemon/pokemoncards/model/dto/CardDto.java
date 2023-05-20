package com.pokemon.pokemoncards.model.dto;

import lombok.*;

import java.util.List;

/**
 * Pokemon Card object
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDto {
    private String id;
    private String name;
    private List<String> types;
    private String bigImage;
}
