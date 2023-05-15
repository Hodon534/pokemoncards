package com.pokemon.pokemoncards.service;

import com.pokemon.pokemoncards.exception.CardNotFoundException;
import com.pokemon.pokemoncards.model.entity.CardEntity;
import com.pokemon.pokemoncards.model.pojo.Card;
import com.pokemon.pokemoncards.repository.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CardService {
    private final CardRepository cardsRepo;

    @Autowired
    public CardService(CardRepository cardsRepo) {
        this.cardsRepo = cardsRepo;
    }

    public CardEntity addCard(Card card) {
        CardEntity cardEntity = new CardEntity(
                card.getId(),
                card.getName(),
                card.getSupertype(),
                card.getHp(),
                card.getNumber(),
                card.getEvolvesFrom(),
                card.getTypes(),
                card.getImages().getLarge(),
                card.getImages().getSmall());
        return cardsRepo.save(cardEntity);
    }

    public List<CardEntity> findAllCards(){
        return cardsRepo.findAll();
    }

    public CardEntity findCardById(String id) {
        return cardsRepo.findCardById(id)
                .orElseThrow
                        (() -> new CardNotFoundException
                                ("Pokemon Card with id " + id + " not found."));
    }
    public List<CardEntity> findCardByName(String name){
        return cardsRepo.findCardByNameContaining(name)
                .orElseThrow
                        (() -> new CardNotFoundException
                                ("Pokemon Cards with name " + name + " not found."));
    }

    public void deleteCard(String id) {
        cardsRepo.deleteCardById(id);
    }

    public void deleteAll() {
        cardsRepo.deleteAll();
    }

}