package com.pokemon.pokemoncards.controller;


//todo L ResponseEntity

import com.pokemon.pokemoncards.model.entity.CardEntity;
import com.pokemon.pokemoncards.model.pojo.Card;
import com.pokemon.pokemoncards.model.pojo.CardList;
import com.pokemon.pokemoncards.util.JsonToPojo;
import com.pokemon.pokemoncards.service.ApiService;
import com.pokemon.pokemoncards.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemoncards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/test")
    public String testResponse() {
        return "ok!";
    }

    @GetMapping("/all")
    public ResponseEntity<List<CardEntity>> getAllCards() {
        List<CardEntity> cardList = cardService.findAllCards();
        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<CardEntity> getCardById(@PathVariable("id") String id) {
        CardEntity cardEntity = cardService.findCardById(id);
        return new ResponseEntity<>(cardEntity, HttpStatus.OK);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<CardEntity>> getCardsByName(@PathVariable("name") String name) {
        List<CardEntity> cardList = cardService.findCardByName(name);
        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CardEntity> addCard(@RequestBody Card card) {
        CardEntity newCard = cardService.addCard(card);
        return new ResponseEntity<>(newCard, HttpStatus.OK);
    }

    @GetMapping("/delete/")
    public ResponseEntity<String> deleteCard(@RequestParam("id") String id) {
        cardService.deleteCard(id);
        return new ResponseEntity<>("Card has been deleted.", HttpStatus.OK);
    }

    @GetMapping("/delete/all")
    public ResponseEntity<String> deleteAll() {
        cardService.deleteAll();
        return new ResponseEntity<>("All card has been deleted.", HttpStatus.OK);
    }

    @GetMapping("/add5cards")
    public ResponseEntity<String> addCardsToDB() throws IOException {
        CardList cardList = JsonToPojo.parseJsonToObject(ApiService.requestData());
        for (Card card : cardList.getCards()) {
            cardService.addCard(card);

        }
        return new ResponseEntity<>("Done, 5 new Pokemon Cards has been added to Database.", HttpStatus.OK);
    }


 /*   @GetMapping("/find/")
    public ResponseEntity<CardEntity> getCardById(@RequestParam("id") String id) {
        CardEntity cardEntity = cardService.findCardById(id);
        return new ResponseEntity<>(cardEntity, HttpStatus.OK);
    }*/
}
