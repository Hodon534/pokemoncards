package com.pokemon.pokemoncards.service;

import com.pokemon.pokemoncards.model.api.ApiLinkCreator;
import org.springframework.web.reactive.function.client.WebClient;

//todo Number of cards = 16109, 3221 pages - 5 pageSize
public class ApiService {
    /**
     * GET JSON from "pokemontcg.io" (Pokemon TCG API)
     * request is for 5 random cards
     * @return String
     */
    static ApiLinkCreator apiLinkCreator = new ApiLinkCreator();

    public static String requestData(){
        String url = apiLinkCreator.createLink();
        //System.out.println(url);
        WebClient.Builder builder = WebClient.builder();

        return builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
