package com.pokemon.pokemoncards.service;

import com.pokemon.pokemoncards.exception.EmailNotValidException;
import com.pokemon.pokemoncards.model.appuser.AppUser;
import com.pokemon.pokemoncards.model.appuser.AppUserRole;
import com.pokemon.pokemoncards.model.registration.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String register(RegistrationRequest request) {
        appUserService.signUpUser(
                new AppUser(
                        request.getUsername(),
                        request.getEmail(),
                        bCryptPasswordEncoder.encode(request.getPassword()),
                        AppUserRole.USER
                ));

        return "register";
    }

}

