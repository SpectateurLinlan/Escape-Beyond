package com.platformer.escape_beyond.model.game;

import com.platformer.escape_beyond.model.entity.Character;
import com.platformer.escape_beyond.model.entity.Map;

/**
 * Represents the state of the game, including character selection, map details,
 * and in-game variables such as time and collected supplies.
 * <p>
 * This class follows the Factory Design Pattern to manage the creation of
 * characters and maps dynamically.
 */
public class GameState {

    // Game state variables
    /** The current character selected by the player. */
    public Character character;

    /** The current map being played. */
    public Map map;

    // In-game variables
    /** The total number of supplies available in the map. */
    public int totalSupplies;

    /** The number of supplies collected by the player. */
    public int collectedSupplies;

    /** The total time available for the game (in seconds). */
    public static final int TOTAL_TIME = 300;

    /** The time spent by the player in the game (in seconds). */
    public int spentTime;

    /**
     * Constructs a new {@code GameState} with default values.
     * <p>
     * The default character and map are initialized, and all in-game variables
     * are set to their starting states.
     */
    public GameState() {
        character = new Character();
        map = new Map();

        totalSupplies = 0;
        collectedSupplies = 0;
        spentTime = 0;
    }

    /**
     * Sets the character for the game state.
     *
     * @param character The {@link Character} object to be set as the current character.
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * Sets the character for the game state by index.
     * <p>
     * Updates the character's index and name based on the provided index.
     *
     * @param index The index of the character to be set (1-4).
     */
    public void setCharacter(int index) {
        this.character.index = index;
        this.character.name = Character.getNameByIndex(index);
    }

    /**
     * Sets the map for the game state.
     *
     * @param map The {@link Map} object to be set as the current map.
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * Sets the map for the game state by index.
     * <p>
     * Updates the map's index and name based on the provided index.
     *
     * @param index The index of the map to be set (1-2 now).
     */
    public void setMap(int index) {
        this.map.index = index;
        this.map.map_name = Map.getNameByIndex(index);
    }

    /**
     * Clears the game state by resetting all variables to their default values.
     * <p>
     * This method initializes a new {@link Character} and {@link Map}, and resets
     * all game-related variables such as collected supplies and time.
     */
    public void clear() {
        this.character = new Character();
        this.map = new Map();
        this.totalSupplies = 0;
        this.collectedSupplies = 0;
        this.spentTime = 0;
    }

    /**
     * Resets in-game variables like time spent and collected supplies without
     * altering the character or map selection.
     */
    public void reset() {
        this.spentTime = 0;
        this.collectedSupplies = 0;
    }


}
