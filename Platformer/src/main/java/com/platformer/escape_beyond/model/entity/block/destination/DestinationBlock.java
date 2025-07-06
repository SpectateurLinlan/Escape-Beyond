package com.platformer.escape_beyond.model.entity.block.destination;

import com.platformer.escape_beyond.model.entity.block.Entity;
import javafx.scene.image.Image;

/**
 * Represents a destination block in the game, which serves as the endpoint for a level.
 * Each destination block is associated with a specific map and has a type, such as an igloo or an oasis.
 * This class extends the {@link Entity} class.
 */
public class DestinationBlock extends Entity {
    public static final String IGLOO_ = "igloo";
    public static final String OASIS_ = "oasis";

    public String destinationType;

    /**
     * Constructs a {@code DestinationBlock} with the specified position, size, map index, and image.
     * The type of the destination is determined based on the provided map index.
     *
     * @param x         The x-coordinate of the destination block's position on the map.
     * @param y         The y-coordinate of the destination block's position on the map.
     * @param w         The width of the destination block.
     * @param h         The height of the destination block.
     * @param map_index The index of the map where this destination block is located.
     *                  Determines the type of the destination (e.g., igloo or oasis).
     *                  - Map index 1: Igloo.
     *                  - Map index 2: Oasis.
     *                  - Map index 3: Igloo.
     * @param image     The {@link Image} representing the destination block visually.
     * @throws IllegalStateException If the map index is not recognized.
     */
    public DestinationBlock(int x, int y, int w, int h, int map_index, Image image) {
        super(x, y, w, h, image);
        this.destinationType = switch (map_index) {
            case 1 -> IGLOO_;
            case 2 -> OASIS_;
            case 3 -> IGLOO_;
            default -> throw new IllegalStateException("Unexpected value: " + map_index);
        };
    }
}
