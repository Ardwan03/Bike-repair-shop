package se.kth.iv1350.bikeRepairShop.adaption;

import java.util.Random;

/**
 * Adapts java.util.Random using composition to provide a method
 * for generating random even integers.
 */
public class RandomCompositionAdapter {
    private Random random;

    /**
     * Creates a new adapter containing a Random instance.
     */
    public RandomCompositionAdapter() {
        this.random = new Random();
    }

    /**
     * Generates a random even integer between 0 (inclusive) and the specified bound (exclusive).
     * @param bound the upper bound (exclusive). 
     * @return a random even integer.
     */
    public int nextEvenInt(int bound) {
        int halfBound = bound / 2;
        return random.nextInt(halfBound) * 2;
    }
}