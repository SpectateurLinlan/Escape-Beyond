package com.platformer.escape_beyond.model.entity.block.feature;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents a feature block entity in the game, utilizing the Factory Design Pattern.
 * <p>
 * Feature blocks can have various types, such as ice blocks, snow blocks, or flying carpets,
 * each influencing the player's interaction and gameplay mechanics.
 * </p>
 */
public class FeatureBlock extends Entity {

    // Constants for feature block types
    public static final String ICE_BLOCK = "ice_block"; // Represents a block that increases player speed
    public static final String SNOW_BLOCK = "snow_block"; // Represents a block that decreases player speed

    /**
     * The specific feature type of this block (e.g., ICE_BLOCK, SNOW_BLOCK).
     */
    public String featureType;

    /**
     * Constructor for creating a feature block.
     *
     * @param x           The x-coordinate of the feature block's position in the game world.
     * @param y           The y-coordinate of the feature block's position in the game world.
     * @param w           The width of the feature block.
     * @param h           The height of the feature block.
     * @param featureType The specific type of the feature block (e.g., ICE_BLOCK, SNOW_BLOCK).
     * @param image       The image used to visually represent the feature block in the game.
     */
    public FeatureBlock(int x, int y, int w, int h, String featureType, Image image) {
        super(x, y, w, h, image);
        this.featureType = featureType;
    }
}
