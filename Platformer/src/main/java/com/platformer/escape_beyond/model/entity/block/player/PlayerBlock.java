package com.platformer.escape_beyond.model.entity.block.player;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents the player entity in the game.
 * <p>
 * This class is part of the implementation of the Factory Design Pattern,
 * providing a structured way to create player objects. Player objects are
 * interactive entities controlled by the user, capable of moving, jumping,
 * and interacting with other game elements such as platforms, obstacles,
 * and supplies.
 * </p>
 * <p>
 * The {@code Player} class extends {@link Entity}, inheriting properties
 * such as position, dimensions, and image representation. It serves as a
 * foundation for adding further player-specific attributes or behaviors
 * in the game.
 * </p>
 */
public class PlayerBlock extends Entity {

    /**
     * Constructs a new {@code Player} instance.
     * <p>
     * This constructor initializes the player with specific position,
     * dimensions, and visual representation. The player object is
     * central to the gameplay, representing the entity that the user
     * controls to navigate the game world and interact with its elements.
     * </p>
     *
     * @param x      The x-coordinate of the player's position in the game world.
     * @param y      The y-coordinate of the player's position in the game world.
     * @param width  The width of the player, defining its size in the horizontal direction.
     * @param height The height of the player, defining its size in the vertical direction.
     * @param image  The {@link Image} used to visually represent the player in the game.
     */
    public PlayerBlock(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }
}
