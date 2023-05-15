package com.pokemon.pokemoncards.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDto {
    private String id;
    private String name;
    private String supertype;
    private int hp;
    private String number;
    private String evolvesFrom;
    private List<String> types;
    private String bigImage;
    private String smallImage;
}
