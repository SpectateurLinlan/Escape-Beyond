package com.platformer.escape_beyond.model.entity;

/**
 * Represents a Character in the game, implementing the Decorator design pattern.
 * This design pattern allows adding new features to the Character class without modifying the original class.
 */
public class Character {

    // Constants for the four characters
    private static final int CHARACTER_1_INDEX = 1; // Index for Character 1
    private static final String CHARACTER_1_NAME = "Bouncy Amy"; // Name for Character 1

    private static final int CHARACTER_2_INDEX = 2; // Index for Character 2
    private static final String CHARACTER_2_NAME = "Brave Carl"; // Name for Character 2

    private static final int CHARACTER_3_INDEX = 3; // Index for Character 3
    private static final String CHARACTER_3_NAME = "Smart Jack"; // Name for Character 3

    private static final int CHARACTER_4_INDEX = 4; // Index for Character 4
    private static final String CHARACTER_4_NAME = "Explorer Lily"; // Name for Character 4

    public int index; // The index of the character
    public String name; // The name of the character

    /**
     * Default constructor for the Character class.
     * Initializes the character with default values: index 1 and name "Bouncy Amy".
     */
    public Character() {
        this.index = CHARACTER_1_INDEX;
        this.name = CHARACTER_1_NAME;
    }

    /**
     * Constructor for the Character class with specified index and name.
     *
     * @param index The index of the character.
     * @param name  The name of the character.
     */
    public Character(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * Gets the character name based on the provided index.
     * If the index does not match any character, the default name "Bouncy Amy" is returned.
     *
     * @param index The index of the character.
     * @return The name of the character corresponding to the index.
     */
    public static String getNameByIndex(int index) {
        return switch (index) {
            case CHARACTER_1_INDEX -> CHARACTER_1_NAME;
            case CHARACTER_2_INDEX -> CHARACTER_2_NAME;
            case CHARACTER_3_INDEX -> CHARACTER_3_NAME;
            case CHARACTER_4_INDEX -> CHARACTER_4_NAME;
            default -> CHARACTER_1_NAME;
        };
    }
}
