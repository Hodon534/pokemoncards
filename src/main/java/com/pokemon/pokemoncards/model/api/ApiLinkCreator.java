package com.pokemon.pokemoncards.model.api;

import com.pokemon.pokemoncards.util.RandomPageSizeGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiLinkCreator {
    private final String BASE_LINK = "https://api.pokemontcg.io/v2/cards";
    @Autowired
    RandomPageSizeGenerator randomPageSizeGenerator;

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
        return "?" + ApiSettings.PAGE.getKey() + "=" + randomPageSizeGenerator.getRandomPageSize(ApiSettings.PAGE.getValue());
    }
}