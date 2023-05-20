package com.pokemon.pokemoncards.repository;

import com.pokemon.pokemoncards.model.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Repository of Users, necessary to access DB
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    /**
     * Find out if user with that email address already exist
     * @param email - user's email address
     * @return specific user with that address
     */
    Optional<AppUser> findByEmail(String email);
}
