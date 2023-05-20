package com.pokemon.pokemoncards.model.entity;

import com.pokemon.pokemoncards.model.pojo.Images;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Pokemon Card Entity - data stored in DB
 */
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
    private List<String> types;
    private String bigImage;
    public CardEntity(
            String id,
            String name,
            List<String> types,
            String bigImage)
    {
        this.id = id;
        this.name = name;
        this.types = types;
        this.bigImage = bigImage;
    }
}
