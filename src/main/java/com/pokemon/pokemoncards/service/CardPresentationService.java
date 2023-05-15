package com.pokemon.pokemoncards.service;

import com.pokemon.pokemoncards.exception.CardNotFoundException;
import com.pokemon.pokemoncards.model.dto.CardDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class CardPresentationService {

    private final RestTemplate restTemplate;

    public CardPresentationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CardDto> callForCards() {
        CardDto[] cards = restTemplate.getForObject("http://localhost:8080/api/v1/pokemoncards/all", CardDto[].class);
        if (cards == null) {
            throw new CardNotFoundException("Database is empty.");
        }
        return Arrays.stream(cards)
                .toList();
    }

    public List<CardDto> otherCallForCards() {

        WebClient.Builder builder = WebClient.builder();

        CardDto[] cards = builder.build()
                .get()
                .uri("http://localhost:8080/api/v1/pokemoncards/all")
                .retrieve()
                .bodyToMono(CardDto[].class)
                .block();
        return Arrays.stream(cards)
                .toList();
    }

    public CardDto callForSingleCardById(String id) {
        CardDto card = restTemplate.getForObject("http://localhost:8080/api/v1/pokemoncards/find/id/" + id, CardDto.class);
        if (card == null) {
            throw new CardNotFoundException("Pokemon Cards with id " + id + " not found.");
        }
        return card;
    }

    public List<CardDto> callForCardsByName(String name) {
        CardDto[] cards = restTemplate.getForObject("http://localhost:8080/api/v1/pokemoncards/find/name/" + name, CardDto[].class);
        if (cards == null) {
            throw new CardNotFoundException("Pokemon Cards with name " + name + " not found.");
        }

        return Arrays.stream(cards)
                .toList();
    }


    /*public List<CardDto> callForCards() {
      //  "/api/v1/pokemoncards"
        CardDto[] cards = restTemplate.getForObject("http://localhost:8080/api/v1/pokemoncards/all", CardDto[].class);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String>responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/pokemoncards/all", String.class);

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(responseEntity.getBody());
            JsonNode name = root.path("name");

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        if (cards == null) {
            throw new IllegalStateException("no result from api");
        }

        return Arrays.stream(cards)
                .toList();
    }*/
}
