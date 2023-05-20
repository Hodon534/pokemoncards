package com.pokemon.pokemoncards.model.registration;

import lombok.*;

/**
 * Registration Request - data provided by user
 */
@Getter
@Setter
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
}
