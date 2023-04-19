package com.pokemon.pokemoncards.service;

import com.pokemon.pokemoncards.exception.PokemonCardNotFoundException;
import com.pokemon.pokemoncards.model.pojo.PokemonCard;
import com.pokemon.pokemoncards.repository.PokemonCardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//todo L @Transactional
@Service
@Transactional
public class PokemonCardService {

    private final List<PokemonCard> pokemonCardList;
    private final PokemonCardRepository pokemonCardsRepo;

    @Autowired
    public PokemonCardService(PokemonCardRepository pokemonCardsRepo) {
        this.pokemonCardsRepo = pokemonCardsRepo;
        this.pokemonCardList = new ArrayList<>();
    }

    public PokemonCard addPokemonCard(PokemonCard pokemonCard) {
        return pokemonCardsRepo.save(pokemonCard);
    }

    public List<PokemonCard> findAllPokemonCards(){
        return pokemonCardsRepo.findAll();
    }

    public PokemonCard updatePokemonCard(PokemonCard pokemonCard){
        return pokemonCardsRepo.save(pokemonCard);
    }

    public PokemonCard findPokemonCardById(String id) {
        return pokemonCardsRepo.findPokemonCardById(id)
                .orElseThrow
                        (() -> new PokemonCardNotFoundException
                                ("Pokemon Card with id " + id + " not found."));
    }
    public void deletePokemonCard(String id) {
        pokemonCardsRepo.deletePokemonCardById(id);
    }

}