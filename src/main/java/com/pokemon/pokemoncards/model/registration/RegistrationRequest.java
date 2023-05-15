package com.pokemon.pokemoncards.model.registration;

import lombok.*;

@Getter
@Setter
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
}
