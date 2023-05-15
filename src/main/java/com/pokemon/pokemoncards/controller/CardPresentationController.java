package com.pokemon.pokemoncards.controller;

import com.pokemon.pokemoncards.model.dto.CardDto;
import com.pokemon.pokemoncards.model.entity.CardEntity;
import com.pokemon.pokemoncards.service.CardPresentationService;
import com.pokemon.pokemoncards.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CardPresentationController {

    private final CardPresentationService cardPresentationService;

    public CardPresentationController(CardPresentationService cardPresentationService) {
        this.cardPresentationService = cardPresentationService;
    }

    @GetMapping("/showCards")
    public String getShowCardsPage(Model model) {
        List<CardDto> cards = cardPresentationService.otherCallForCards();
        //List<CardDto> cards = cardPresentationService.testingCards();
        model.addAttribute("cards", cards);
        return "show-cards";
    }

    @GetMapping("/showSpecificCardById")
    public String getSpecificCardPageById(Model model, @RequestParam("id") String id) {
        CardDto card = cardPresentationService.callForSingleCardById(id);
        model.addAttribute("card", card);
        return "show-card-by-id";
    }

    @GetMapping("/showSpecificCardsByName")
    public String getSpecificCardPageByName(Model model, @RequestParam("name") String name) {
        List<CardDto> cards = cardPresentationService.callForCardsByName(name);
        model.addAttribute("cards", cards);
        return "show-cards-by-name";
    }

}
