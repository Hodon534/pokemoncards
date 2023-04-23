package com.pokemon.pokemoncards.model.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Table(name = "pokemoncards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PokemonCard implements Serializable {
    @Id
    //@Column(nullable = false, updatable = false)
    private String id;
    private String name;
    private String supertype;
    private int hp;
    //private String[] subtypes;
    //private Type[] types;
    //private String[] evolvesTo;
    //private Attack[] attacks;
    //private Weakness[] weaknesses;
    //private Type[] retreatCost;
    private Long convertedRetreatCost;
    //private Set set;
    private String number;
    private String artist;
    private String rarity;
    private String flavorText;
    //private long[] nationalPokedexNumbers;
    //private Legalities legalities;
    //private DatumImages images;
    //private Tcgplayer tcgplayer;
    //private Cardmarket cardmarket;
    private String evolvesFrom;
    //private Weakness[] resistances;
    //private String[] rules;
    //private Ability[] abilities;


}