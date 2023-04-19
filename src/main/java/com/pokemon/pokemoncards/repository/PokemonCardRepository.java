package com.pokemon.pokemoncards.repository;

import com.pokemon.pokemoncards.model.pojo.PokemonCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonCardRepository extends JpaRepository<PokemonCard, String> {

    void deletePokemonCardById(String id);

    Optional<PokemonCard> findPokemonCardById(String id);
}
