package com.pokemon.pokemoncards.controller;

import com.pokemon.pokemoncards.model.registration.RegistrationRequest;
import com.pokemon.pokemoncards.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@ModelAttribute("registrationRequest") RegistrationRequest request, Model model) {
        return registrationService.register(request);
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        RegistrationRequest request = new RegistrationRequest();
        model.addAttribute("registrationRequest", request);
        return "register";
    }



}
