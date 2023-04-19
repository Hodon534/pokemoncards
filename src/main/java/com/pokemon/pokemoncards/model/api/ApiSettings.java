package com.pokemon.pokemoncards.model.api;

public enum ApiSettings implements ApiConstructor{
    PAGE("page", 3221),
    PAGESIZE("pageSize", 5);

    private final String key;
    private final int value;

    ApiSettings(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public int getValue() {
        return value;
    }
}