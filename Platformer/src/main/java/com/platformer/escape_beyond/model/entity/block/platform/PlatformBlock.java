package com.platformer.escape_beyond.model.entity.block.platform;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents a platform block in the game.
 * <p>
 * This class is part of the implementation of the Factory Design Pattern,
 * providing a way to create and manage platform blocks. Platform blocks are
 * static or semi-static entities that players can walk or jump on, serving as
 * key elements in the game environment.
 * </p>
 * <p>
 * The class extends {@link Entity}, inheriting properties such as position,
 * dimensions, and image representation, making it a versatile component for
 * building game levels.
 * </p>
 */
public class PlatformBlock extends Entity {

    /**
     * Constructs a new {@code PlatformBlock} instance.
     * <p>
     * This constructor initializes the platform block with specific position,
     * dimensions, and visual representation. Platform blocks are essential
     * components for creating game environments, allowing players to interact
     * with the world by jumping or walking on them.
     * </p>
     *
     * @param x     The x-coordinate of the platform block's position in the game world.
     * @param y     The y-coordinate of the platform block's position in the game world.
     * @param w     The width of the platform block, defining its size in the horizontal direction.
     * @param h     The height of the platform block, defining its size in the vertical direction.
     * @param image The {@link Image} used to visually represent the platform block in the game.
     */
    public PlatformBlock(int x, int y, int w, int h, Image image) {
        super(x, y, w, h, image);
    }
}
