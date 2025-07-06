package com.platformer.escape_beyond.model.entity.block.supply;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents a supply block entity in the game.
 * <p>
 * The {@code SupplyBlock} class extends the {@link Entity} class to include additional
 * attributes specific to supplies, such as their type (e.g., water bottle, can, or cookie).
 * Supply blocks are collectible game objects that players can interact with during gameplay.
 * </p>
 * <p>
 * This class provides constants for predefined supply types and encapsulates properties
 * such as position, dimensions, type, and associated image.
 * </p>
 */
public class SupplyBlock extends Entity {

    // Constants for predefined supply types
    public static final String BOTTLE_WATER_ = "bottle_water";
    public static final String CAN_ = "can";
    public static final String COOKIE_ = "cookie";

    /** The type of the supply (e.g., bottle_water, can, cookie). */
    public String supplyType;

    /**
     * Constructs a new {@code SupplyBlock} object.
     *
     * @param x          The x-coordinate of the supply block's position in the game world.
     * @param y          The y-coordinate of the supply block's position in the game world.
     * @param w          The width of the supply block, defining its size in the horizontal direction.
     * @param h          The height of the supply block, defining its size in the vertical direction.
     * @param supplyType The type of the supply (e.g., {@code BOTTLE_WATER_}, {@code CAN_}, {@code COOKIE_}).
     * @param image      The image representing the supply block visually.
     */
    public SupplyBlock(int x, int y, int w, int h, String supplyType, Image image) {
        super(x, y, w, h, image);
        this.supplyType = supplyType;
    }
}
