package com.platformer.escape_beyond.model.entity;

import com.platformer.escape_beyond.utils.RandomNumberGenerator;
/**
 * Represents the map in the game, including its index, name, and associated backgrounds.
 * <p>
 * Implements the Decorator Design Pattern to add features to the map functionality without
 * altering the original structure of the class.
 * <p>
 * This class provides methods to retrieve map names, construct maps with specific or random
 * attributes, and fetch random map backgrounds dynamically.
 */
public class Map {

    // Map constants
    private static final int MAP_1_INDEX = 1;
    private static final String MAP_1_NAME = "glacier";

    private static final int MAP_2_INDEX = 2;
    private static final String MAP_2_NAME = "desert";

    // Map dictionary constants
    private static final String MAP_DICTIONARY = "/images/2_Maps/Background/";

    /** The index of the current map (e.g., 1 for glacier, 2 for desert). */
    public int index;

    /** The name of the current map (e.g., "glacier", "desert"). */
    public String map_name;

    /**
     * Constructs a new {@code Map} object with default values.
     * <p>
     * The default map is initialized to the first map ("glacier").
     */
    public Map() {
        this.index = MAP_1_INDEX;
        this.map_name = MAP_1_NAME;
    }

    /**
     * Constructs a new {@code Map} object with a specific index.
     *
     * @param index The index of the map to initialize (1 for glacier, 2 for desert, 3 for forest).
     */
    public Map(int index) {
        this.index = index;
        this.map_name = getNameByIndex(index);
    }

    /**
     * Retrieves the name of a map based on its index.
     *
     * @param index The index of the map (1, 2, or 3).
     * @return The name of the map corresponding to the given index.
     *         Defaults to "glacier" if the index is invalid.
     */
    public static String getNameByIndex(int index) {
        return switch (index) {
            case MAP_1_INDEX -> MAP_1_NAME;
            case MAP_2_INDEX -> MAP_2_NAME;
            default -> MAP_1_NAME;
        };
    }

    /**
     * Retrieves the URL of a random background image for the specified map.
     * <p>
     * Background images are stored in the {@code /images/background/} directory.
     * The filenames follow the pattern: {@code map_name + number.jpg}.
     * If there are multiple images per map, this method dynamically selects one
     * using the {@link RandomNumberGenerator}.
     *
     * @param index The index of the map (1, 2, or 3).
     * @return The URL of the randomly selected background image for the specified map.
     *         Defaults to the glacier map's background if the index is invalid.
     */
    public static String getRandomMapBackground(int index) {
        return switch (index) {
            case MAP_1_INDEX -> MAP_DICTIONARY + MAP_1_NAME + RandomNumberGenerator.getRandomInt(1, 2) + ".jpg";
            case MAP_2_INDEX -> MAP_DICTIONARY + MAP_2_NAME + RandomNumberGenerator.getRandomInt(1, 3) + ".jpg";
            default -> MAP_DICTIONARY + MAP_1_NAME + RandomNumberGenerator.getRandomInt(1, 1) + ".jpg";
        };
    }
}
