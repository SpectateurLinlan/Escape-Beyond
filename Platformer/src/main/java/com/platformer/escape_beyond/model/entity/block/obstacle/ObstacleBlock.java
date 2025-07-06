package com.platformer.escape_beyond.model.entity.block.obstacle;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents an obstacle block in the game.
 * <p>
 * This class is part of the implementation of the Factory Design Pattern,
 * providing a way to create and manage obstacle blocks. Obstacle blocks are
 * static entities in the game world that act as barriers or interactive elements
 * the player must navigate around or deal with.
 * </p>
 * <p>
 * The class extends {@link Entity}, inheriting properties like position,
 * dimensions, and image representation, making it versatile for various game scenarios.
 * </p>
 */
public class ObstacleBlock extends Entity {

    /**
     * Constructs a new {@code ObstacleBlock} instance.
     * <p>
     * This constructor initializes the obstacle block with specific position,
     * dimensions, and visual representation. Obstacle blocks are typically
     * used to enhance the challenge or aesthetic of a game level.
     * </p>
     *
     * @param x     The x-coordinate of the obstacle block's position in the game world.
     * @param y     The y-coordinate of the obstacle block's position in the game world.
     * @param w     The width of the obstacle block, defining its size in the horizontal direction.
     * @param h     The height of the obstacle block, defining its size in the vertical direction.
     * @param image The {@link Image} used to visually represent the obstacle block in the game.
     */
    public ObstacleBlock(int x, int y, int w, int h, Image image) {
        super(x, y, w, h, image);
    }
}
