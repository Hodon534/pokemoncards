package com.pokemon.pokemoncards.model.entity;

import com.pokemon.pokemoncards.model.pojo.Images;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "pokemon_card")
public class CardEntity implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private String id;
    private String name;
    private String supertype;
    private int hp;
    private String number;
    private String evolvesFrom;
    @ElementCollection
    private List<String> types;
    private String bigImage;
    private String smallImage;

    public CardEntity(
            String id,
            String name,
            String supertype,
            int hp,
            String number,
            String evolvesFrom,
            List<String> types,
            String bigImage,
            String smallImage)
    {
        this.id = id;
        this.name = name;
        this.supertype = supertype;
        this.hp = hp;
        this.number = number;
        this.evolvesFrom = evolvesFrom;
        this.types = types;
        this.bigImage = bigImage;
        this.smallImage = smallImage;
    }
}
