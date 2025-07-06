package com.platformer.escape_beyond.utils;

import java.util.Random;

/**
 * Utility class for generating random integers within a specified range.
 * <p>
 * This class provides methods for random number generation with inclusive boundaries.
 */
public class RandomNumberGenerator {

    private static final Random RANDOM = new Random(); // Shared Random instance for better performance.

    /**
     * Generates a random integer between the specified minimum and maximum values (inclusive).
     *
     * @param min The minimum value of the range (inclusive).
     * @param max The maximum value of the range (inclusive).
     * @return A random integer within the range [min, max].
     * @throws IllegalArgumentException if {@code min > max}.
     */
    public static int getRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum value cannot be greater than the maximum value.");
        }
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
