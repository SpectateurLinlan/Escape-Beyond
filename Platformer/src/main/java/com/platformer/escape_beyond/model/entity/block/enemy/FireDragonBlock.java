package com.platformer.escape_beyond.model.entity.block.enemy;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents a fire dragon entity in the game, which is a type of obstacle.
 * <p>
 * The fire dragon can move within a specified range and is represented visually
 * using an image. This class extends the {@link Entity} class and adds a range
 * attribute to define its movement boundaries.
 */
public class FireDragonBlock extends Entity {

    /**
     * The range of movement for the fire dragon, represented as an array of two integers.
     * The first value is the minimum range, and the second value is the maximum range.
     */
    private final int[] range;

    /**
     * Constructs a new {@code FireDragonBlock} with the specified parameters.
     *
     * @param x     The x-coordinate of the fire dragon's position in the game world.
     * @param y     The y-coordinate of the fire dragon's position in the game world.
     * @param w     The width of the fire dragon.
     * @param h     The height of the fire dragon.
     * @param image The image representing the fire dragon visually.
     * @param range An array of two integers specifying the movement range of the fire dragon.
     *              The first value represents the minimum range, and the second value represents
     *              the maximum range.
     */
    public FireDragonBlock(int x, int y, int w, int h, Image image, int[] range) {
        super(x, y, w, h, image);
        this.range = range;
    }

    /**
     * Retrieves the movement range of the fire dragon.
     *
     * @return An array of two integers representing the range of movement for the fire dragon.
     *         The first value is the minimum range, and the second value is the maximum range.
     */
    public int[] getRange() {
        return range;
    }
}
