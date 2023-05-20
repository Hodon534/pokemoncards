package com.pokemon.pokemoncards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CardsController {

    @GetMapping("/cards")
    public String getCardsPage() {
        return "cards";
    }

}
