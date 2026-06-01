package se.kth.iv1350.bikeRepairShop.adaption;

import java.util.Random;

/**
 * Adapts java.util.Random using inheritance to provide a method
 * for generating random even integers.
 */
public class RandomInheritanceAdapter extends Random {

    /**
     * Generates a random even integer between 0 (inclusive) and the specified bound (exclusive).
     * @param bound the upper bound (exclusive).
     * @return a random even integer.
     */
    public int nextEvenInt(int bound) {
        int halfBound = bound / 2;
        return super.nextInt(halfBound) * 2;
    }
}