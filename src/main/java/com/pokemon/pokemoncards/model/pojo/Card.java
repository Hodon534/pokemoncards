package com.pokemon.pokemoncards.model.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card {

    private String id;
    private String name;
    private String supertype;
    private int hp;
    private String number;
    private String evolvesFrom;
    @ElementCollection
    private List<String> types;
    private Images images;

}