package com.pokemon.pokemoncards.config;

import com.pokemon.pokemoncards.model.appuser.AppUserRole;
import com.pokemon.pokemoncards.security.CustomAuthenticationFailureHandler;
import com.pokemon.pokemoncards.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*
          authorizeHttpRequests() - That's why we are not able to access website without login page.
          anyRequest().authenticated() - Any request has to be authenticated.
          With that line Spring is automatically securing all the endpoints
         */
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(
                        auth -> {
                            auth.requestMatchers("/css/**").permitAll();
                            auth.requestMatchers("/register").permitAll();
                            auth.requestMatchers("/").permitAll();
                            auth.requestMatchers("/api/v1/**").permitAll();
                            auth.requestMatchers("/cards", "/showCards", "show-cards-by-name", "show-card-by-id")
                                    .hasAnyAuthority(
                                            AppUserRole.USER.name(),
                                            AppUserRole.ADMIN.name());
                            auth.requestMatchers("/error").permitAll();
                        })
                .formLogin(
                        (form) ->
                                form
                                        .loginPage("/login")
                                        .loginProcessingUrl("/login")
                                        .defaultSuccessUrl("/")
                                        .permitAll())
/*                .formLogin()
                .failureHandler(authenticationFailureHandler())
                .and()*/
                .httpBasic();

        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}

