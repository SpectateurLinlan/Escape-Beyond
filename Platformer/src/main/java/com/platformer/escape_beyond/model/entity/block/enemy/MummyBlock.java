package com.platformer.escape_beyond.model.entity.block.enemy;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents a block associated with a Mummy enemy in the game.
 * <p>
 * This class extends the {@link Entity} class to include additional behavior and properties
 * specific to Mummy enemies, such as their movement range.
 */
public class MummyBlock extends Entity {
    /**
     * The moving velocity of the Mummy enemy.
     */
    public static final int MOVING_VELOCITY = 1;

    /** The range within which the Mummy can move, represented as an array of integers. */
    private final int[] range;

    /**
     * Constructor for the MummyBlock class.
     * <p>
     * Initializes the MummyBlock with its position, dimensions, associated image,
     * and movement range.
     *
     * @param x The x-coordinate of the MummyBlock's position.
     * @param y The y-coordinate of the MummyBlock's position.
     * @param w The width of the MummyBlock.
     * @param h The height of the MummyBlock.
     * @param image The image representing the MummyBlock visually.
     * @param range The range within which the Mummy can move.
     */
    public MummyBlock(int x, int y, int w, int h, Image image, int[] range) {
        super(x, y, w, h, image);
        this.range = range;
    }

    /**
     * Retrieves the movement range of the MummyBlock.
     *
     * @return An array of integers representing the range of movement.
     */
    public int[] getRange() {
        return range;
    }
}
