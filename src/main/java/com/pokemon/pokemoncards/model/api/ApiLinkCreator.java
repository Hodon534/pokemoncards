package com.pokemon.pokemoncards.model.api;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


public class ApiLinkCreator {
    private final String BASE_LINK = "https://api.pokemontcg.io/v2/cards";

    private final Random random = new Random();

    @Autowired
    public ApiLinkCreator() {
    }

    public String createLink(){
        return BASE_LINK +
                getPage() +
                getPageSize();
    }

    private String getPageSize(){
        return "&" + ApiSettings.PAGESIZE.getKey() + "=" + ApiSettings.PAGESIZE.getValue();
    }

    private String getPage(){
        return "?" + ApiSettings.PAGE.getKey() + "=" + getRandomPageSize(ApiSettings.PAGE.getValue());
    }

    public int getRandomPageSize(int pages){
        return random.nextInt(1, pages);
    }
}