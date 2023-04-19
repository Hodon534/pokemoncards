package com.pokemon.pokemoncards.util;

import java.util.Random;

/**
 * Pokemon Cards in database - over 16k
 */
public class RandomPageSizeGenerator {
    private static final Random random = new Random();

    public RandomPageSizeGenerator() {
    }

    public int getRandomPageSize(int pages){
        return random.nextInt(1, pages);
    }
}
