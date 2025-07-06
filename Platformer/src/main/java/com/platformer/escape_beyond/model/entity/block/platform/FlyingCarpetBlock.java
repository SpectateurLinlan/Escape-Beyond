package com.platformer.escape_beyond.model.entity.block.platform;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents a flying carpet entity in the game.
 * <p>
 * The flying carpet is a movable entity that operates within a specified range.
 * It is used as a dynamic platform that players can interact with during gameplay.
 */
public class FlyingCarpetBlock extends Entity {

    /**
     * The movement range of the flying carpet.
     * The range is defined as an array of two integers:
     * - The first value specifies the starting position.
     * - The second value specifies the ending position.
     */
    private int[] range;

    /**
     * Constructs a new {@code FlyingCarpetBlock} with the specified position, dimensions, image, and movement range.
     *
     * @param x     The x-coordinate of the flying carpet's initial position in the game world.
     * @param y     The y-coordinate of the flying carpet's initial position in the game world.
     * @param w     The width of the flying carpet.
     * @param h     The height of the flying carpet.
     * @param image The image representing the flying carpet visually in the game.
     * @param range An array of two integers defining the movement range of the flying carpet.
     *              The first value is the minimum range, and the second value is the maximum range.
     */
    public FlyingCarpetBlock(int x, int y, int w, int h, Image image, int[] range) {
        super(x, y, w, h, image);
        this.range = range;
    }

    /**
     * Returns the movement range of the flying carpet.
     *
     * @return An array of two integers representing the minimum and maximum range of the flying carpet's movement.
     */
    public int[] getRange() {
        return range;
    }
}
