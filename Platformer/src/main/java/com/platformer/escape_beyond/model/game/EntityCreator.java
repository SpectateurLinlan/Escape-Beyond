package com.platformer.escape_beyond.model.game;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.Main;
import com.platformer.escape_beyond.model.entity.block.*;
import com.platformer.escape_beyond.model.entity.block.destination.DestinationBlock;
import com.platformer.escape_beyond.model.entity.block.enemy.FireDragonBlock;
import com.platformer.escape_beyond.model.entity.block.enemy.MummyBlock;
import com.platformer.escape_beyond.model.entity.block.feature.FeatureBlock;
import com.platformer.escape_beyond.model.entity.block.obstacle.ObstacleBlock;
import com.platformer.escape_beyond.model.entity.block.platform.FlyingCarpetBlock;
import com.platformer.escape_beyond.model.entity.block.platform.PlatformBlock;
import com.platformer.escape_beyond.model.entity.block.player.PlayerBlock;
import com.platformer.escape_beyond.model.entity.block.supply.SupplyBlock;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Utility class for creating game entities dynamically.
 * <p>
 * Implements the Factory Design Pattern to centralize the creation of various entities
 * (e.g., players, platforms, obstacles, supplies, and enemies) with their associated images.
 */
public class EntityCreator {
    // character
    public static final String PLAYER_ = "player";

    // supply blocks
    public static final String BOTTLE_WATER_ = "bottle_water";
    public static final String CAN_ = "can";
    public static final String COOKIE_ = "cookie";

    // platform blocks
    public static final String GLACIER_PLATFORM_BLOCK_ = "glacier_platform_block";
    public static final String DESERT_PLATFORM_BLOCK_ = "desert_platform_block";

    // obstacle blocks
    public static final String GLACIER_SMALL_ICE_BLOCK_ = "glacier_small_ice_block";
    public static final String GLACIER_LARGE_ICE_BLOCK_ = "glacier_large_ice_block";
    public static final String DESERT_STONE_BLOCK_ = "desert_stone_block";
    public static final String DESERT_CACTUS_BLOCK_ = "desert_cactus_block";

    // feature blocks
    public static final String GLACIER_ICE_BLOCK_ = "glacier_ice_block";
    public static final String GLACIER_SNOW_BLOCK_ = "glacier_snow_block";

    // enemy blocks
    public static final String FIRE_DRAGON_ = "fire_dragon";
    public static final String MUMMY_ = "mummy";

    // destination
    public static final String IGLOO_ = "igloo";
    public static final String OASIS_ = "oasis";

    // movable object blocks
    public static final String FLYING_CARPET_ = "flying_carpet";

    /**
     * Creates an entity object with a specified tag.
     * The tag differentiates variations of the same entity type.
     *
     * @param entityType The type of entity.
     * @param x          The x-coordinate of the entity.
     * @param y          The y-coordinate of the entity.
     * @param w          The width of the entity.
     * @param h          The height of the entity.
     * @param tag        The variation tag for the entity (default is 1).
     * @return The created {@code Entity}.
     */
    public static Entity createEntity(String entityType, int x, int y, int w, int h, int tag) {
        return switch (entityType) {
            case PLAYER_ -> new PlayerBlock(x, y, w, h, loadImageView(entityType, tag));
            // supply blocks
            case BOTTLE_WATER_ -> new SupplyBlock(x, y, w, h, SupplyBlock.BOTTLE_WATER_, loadImageView(entityType, tag));
            case CAN_ -> new SupplyBlock(x, y, w, h, SupplyBlock.CAN_, loadImageView(entityType, tag));
            case COOKIE_ -> new SupplyBlock(x, y, w, h, SupplyBlock.COOKIE_, loadImageView(entityType, tag));
            // platform blocks
            case GLACIER_PLATFORM_BLOCK_, DESERT_PLATFORM_BLOCK_ -> new PlatformBlock(x, y, w, h, loadImageView(entityType, tag));
            // obstacle blocks
            case GLACIER_SMALL_ICE_BLOCK_, GLACIER_LARGE_ICE_BLOCK_, DESERT_STONE_BLOCK_, DESERT_CACTUS_BLOCK_ -> new ObstacleBlock(x, y, w, h, loadImageView(entityType, tag));
            // feature blocks
            case GLACIER_ICE_BLOCK_ -> new FeatureBlock(x, y, w, h, FeatureBlock.ICE_BLOCK, loadImageView(entityType, tag));
            case GLACIER_SNOW_BLOCK_ -> new FeatureBlock(x, y, w, h, FeatureBlock.SNOW_BLOCK, loadImageView(entityType, tag));
            // destination
            case IGLOO_, OASIS_ -> new DestinationBlock(x, y, w, h, DataManager.getInstance().getGameState().map.index, loadImageView(entityType, tag));
            // enemy blocks
            case FIRE_DRAGON_ -> new FireDragonBlock(x, y, w, h, loadImageView(entityType, tag), DataManager.getInstance().getRangeIterator().next());
            case MUMMY_ -> new MummyBlock(x, y, w, h, loadImageView(entityType, tag), DataManager.getInstance().getRangeIterator().next());
            // moving object blocks
            case FLYING_CARPET_ -> new FlyingCarpetBlock(x, y, w, h, loadImageView(entityType, tag), DataManager.getInstance().getRangeIterator().next());

            default -> throw new IllegalStateException("Unexpected value: " + entityType);
        };
    }

    /**
     * Loads an image for the specified entity type and tag.
     *
     * @param entityType The type of entity.
     * @param tag        The variation tag for the entity.
     * @return The {@code Image} corresponding to the entity type and tag.
     */
    public static Image loadImageView(String entityType, int tag) {
        String url = switch (entityType) {
            // Player
            case PLAYER_ -> "/images/7_Option/character/Character" + tag + ".png";

            // Supplies
            case BOTTLE_WATER_ -> "/images/8_inGame/destination/supply/water.png";
            case CAN_ -> "/images/8_inGame/destination/supply/can.png";
            case COOKIE_ -> "/images/8_inGame/destination/supply/cookie.png";

            // Platforms
            case GLACIER_PLATFORM_BLOCK_ -> "/images/8_inGame/destination/platform/glacier_platform_block3.png";
            case DESERT_PLATFORM_BLOCK_ -> "/images/8_inGame/destination/platform/desert_platform_block2.png";

            // Obstacles
            case GLACIER_SMALL_ICE_BLOCK_, GLACIER_LARGE_ICE_BLOCK_ -> "/images/8_inGame/destination/obstacle/glacier_ice_block.png";
            case DESERT_STONE_BLOCK_ -> "/images/8_inGame/destination/obstacle/desert_stone.png";
            case DESERT_CACTUS_BLOCK_ -> "/images/8_inGame/destination/obstacle/desert_cactus.png";

            // Features
            case GLACIER_ICE_BLOCK_ -> "/images/8_inGame/destination/feature/glacier_ice_block.jpg";
            case GLACIER_SNOW_BLOCK_ -> "/images/8_inGame/destination/feature/glacier_snow_block.png";

            // Destinations
            case IGLOO_ -> "/images/8_inGame/destination/glacier_igloo2.png";
            case OASIS_ -> "/images/8_inGame/destination/desert_oasis.png";

            // Enemies
            case FIRE_DRAGON_ -> "/images/8_inGame/destination/enemy/desert_firedragon.png";
            case MUMMY_ -> "/images/8_inGame/destination/enemy/desert_mummy.png";

            // Moving Objects
            case FLYING_CARPET_ -> "/images/8_inGame/destination/moving_objects/desert_flying_carpet.png";

            default -> throw new IllegalStateException("Unexpected value: " + entityType);
        };

        return new Image(Objects.requireNonNull(Main.class.getResourceAsStream(url), "Image not found: " + url));
    }
}
