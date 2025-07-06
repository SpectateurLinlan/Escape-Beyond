package com.platformer.escape_beyond.model.game;

import java.io.Serializable;

/**
 * Represents a player's score in the game.
 * <p>
 * The {@code Score} class encapsulates details about a player's performance on a specific map,
 * including the score achieved, the map's index and name, and the date when the score was recorded.
 * This class implements {@link Serializable} to allow scores to be saved and loaded for
 * persistence across game sessions.
 * </p>
 * Each {@code Score} object is tied to a specific map and contains:
 * <ul>
 *     <li>The numerical score achieved by the player.</li>
 *     <li>The index of the map where the score was achieved.</li>
 *     <li>The name of the map corresponding to the index.</li>
 *     <li>The date the score was recorded.</li>
 * </ul>
 */
public class Score implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility across serialized versions.

    private int score;          // The score achieved by the player.
    private int map_index;      // The index of the map where the score was achieved.
    private String map_name;    // The name of the map corresponding to the map index.
    private String date;        // The date when the score was recorded.

    /**
     * Constructs a new {@code Score} object.
     *
     * @param score     The player's score achieved on the map.
     * @param map_index The index of the map where the score was achieved.
     * @param map_name  The name of the map corresponding to the map index.
     * @param date      The date when the score was recorded, in {@code yyyy-MM-dd HH:mm:ss} format.
     */
    public Score(int score, int map_index, String map_name, String date) {
        this.score = score;
        this.map_index = map_index;
        this.map_name = map_name;
        this.date = date;
    }

    // Getters

    /**
     * Retrieves the player's score.
     *
     * @return The numerical score achieved by the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Retrieves the index of the map where the score was achieved.
     *
     * @return The map's index.
     */
    public int getMapIndex() {
        return map_index;
    }

    /**
     * Retrieves the name of the map where the score was achieved.
     *
     * @return The name of the map.
     */
    public String getMapName() {
        return map_name;
    }

    /**
     * Retrieves the date when the score was recorded.
     *
     * @return The date as a {@code String} in {@code yyyy-MM-dd HH:mm:ss} format.
     */
    public String getDate() {
        return date;
    }

    /**
     * Converts the {@code Score} object to a string representation.
     * <p>
     * This method provides a human-readable format of the score details, including the score,
     * map index, map name, and date. Useful for debugging or displaying score information in logs.
     * </p>
     *
     * @return A string representation of the {@code Score} object.
     */
    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                ", map_index=" + map_index +
                ", map_name='" + map_name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
