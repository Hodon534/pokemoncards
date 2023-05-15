package com.pokemon.pokemoncards.repository;

import com.pokemon.pokemoncards.model.entity.CardEntity;
import com.pokemon.pokemoncards.model.pojo.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {

    void deleteCardById(String id);

    Optional<CardEntity> findCardById(String id);

    Optional<List<CardEntity>> findCardByNameContaining(String name);

}
