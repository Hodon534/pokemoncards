package com.pokemon.pokemoncards.controller;


//todo L ResponseEntity

import com.pokemon.pokemoncards.model.pojo.PokemonCard;
import com.pokemon.pokemoncards.model.pojo.PokemonCardList;
import com.pokemon.pokemoncards.repository.JsonToPojo;
import com.pokemon.pokemoncards.repository.PokemonCardRepository;
import com.pokemon.pokemoncards.service.ApiService;
import com.pokemon.pokemoncards.service.PokemonCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemoncards")
public class PokemonCardController {

    private final PokemonCardService pokemonCardService;

    public PokemonCardController(PokemonCardService pokemonCardService) {
        this.pokemonCardService = pokemonCardService;
    }

    @GetMapping("/test")
    public String testResponse() {
        return "ok!";
    }

    @GetMapping("/all")
    public ResponseEntity<List<PokemonCard>> getAllPokemonCards() {
        List<PokemonCard> pokemonCardList = pokemonCardService.findAllPokemonCards();
        return new ResponseEntity<>(pokemonCardList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PokemonCard> getPokemonCardById(@PathVariable("id") String id) {
        PokemonCard pokemonCard = pokemonCardService.findPokemonCardById(id);
        return new ResponseEntity<>(pokemonCard, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PokemonCard> addPokemonCard(@RequestBody PokemonCard pokemonCard) {
        PokemonCard newPokemonCard = pokemonCardService.addPokemonCard(pokemonCard);
        return new ResponseEntity<>(newPokemonCard, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PokemonCard> updatePokemonCard(@RequestBody PokemonCard pokemonCard) {
        PokemonCard updatePokemonCard = pokemonCardService.updatePokemonCard(pokemonCard);
        return new ResponseEntity<>(updatePokemonCard, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id={id}")
    public ResponseEntity<String> deletePokemonCard(@PathVariable("id") String id) {
        pokemonCardService.deletePokemonCard(id);
        return new ResponseEntity<>("Card has been deleted.", HttpStatus.OK);
    }

    @GetMapping("/delete/all")
    public ResponseEntity<String> deleteAll() {
        pokemonCardService.deleteAll();
        return new ResponseEntity<>("All card has been deleted.", HttpStatus.OK);
    }

    @GetMapping("/add5cards")
    public ResponseEntity<String> addPokemonCardsToDB() throws IOException {
        PokemonCardList pokemonCardList = JsonToPojo.parseJsonToObject(ApiService.requestData());
        for (PokemonCard pokemonCard : pokemonCardList.getPokemonCards()) {
            pokemonCardService.addPokemonCard(pokemonCard);
        }
        return new ResponseEntity<>("Done, 5 new Pokemon Cards has been added to Database.", HttpStatus.OK);
    }


}
