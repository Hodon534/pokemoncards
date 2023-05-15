package com.pokemon.pokemoncards.service;

import com.pokemon.pokemoncards.model.appuser.AppUser;
import com.pokemon.pokemoncards.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MESSAGE = "User with email %s had not been found";
    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                          new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExist = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("Email already taken");
        }
        appUserRepository.save(appUser);
        String token = UUID.randomUUID().toString();

        return token;
    }

}
