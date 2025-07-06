package com.platformer.escape_beyond.model.game;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.model.entity.block.*;
import com.platformer.escape_beyond.model.entity.block.destination.DestinationBlock;
import com.platformer.escape_beyond.model.entity.block.enemy.FireDragonBlock;
import com.platformer.escape_beyond.model.entity.block.enemy.MummyBlock;
import com.platformer.escape_beyond.model.entity.block.feature.FeatureBlock;
import com.platformer.escape_beyond.model.entity.block.platform.FlyingCarpetBlock;
import com.platformer.escape_beyond.model.entity.block.supply.SupplyBlock;
import com.platformer.escape_beyond.model.entity.node.movable.enemy.EnemyNode;
import com.platformer.escape_beyond.model.entity.node.movable.enemy.FireDragonNode;
import com.platformer.escape_beyond.model.entity.node.movable.platform.FlyingCarpetNode;
import com.platformer.escape_beyond.model.entity.node.movable.platform.MovableObjectNode;
import com.platformer.escape_beyond.model.entity.node.movable.enemy.MummyNode;
import com.platformer.escape_beyond.model.entity.node.stationary.DestinationNode;
import com.platformer.escape_beyond.model.entity.node.stationary.FeatureNode;
import com.platformer.escape_beyond.model.entity.node.stationary.SupplyNode;
import javafx.scene.image.ImageView;

/**
 * A utility class for selecting and inserting entities into the game based on the current map level.
 * Implements the Strategy Pattern to handle different entity insertion rules for each level.
 * <p>
 * This class dynamically loads and positions game elements such as platforms, obstacles, supplies, enemies,
 * and destinations according to the game map's layout and level rules.
 */
public class EntitySelector {
    static final DataManager dataManager = DataManager.getInstance();
    static SceneManager sceneManager = SceneManager.getInstance();
    // Constants for common dimensions
    private static final int BLOCK_SIZE = 60;
    private static final int LARGE_BLOCK_SIZE = 120;
    private static final int SMALL_SUPPLY_SIZE = 20;
    private static final int DESTINATION_WIDTH = 250;
    private static final int DESTINATION_HEIGHT = 100;
    private static final int SUPPLY_OFFSET_X = 20;
    private static final int SUPPLY_OFFSET_Y = 40;

    /**
     * Inserts entities into the game based on the character symbol ('c'), column index ('j'),
     * and row index ('i'), following the rules for the current map level.
     *
     * @param c The character symbol representing the type of entity to be inserted.
     * @param j The column index in the game map matrix.
     * @param i The row index in the game map matrix.
     */
    public static void InsertEntity(char c, int j, int i) {
        switch (dataManager.getGameState().map.index) {
            case 1 -> InsertEntityRuleLevel1(c, j, i);
            case 2 -> InsertEntityRuleLevel2(c, j, i);
            default -> throw new IllegalStateException("Unexpected map index: " + dataManager.getGameState().map.index);
        }
    }

    /**
     * Inserts entities according to the rules for Level 1.
     *
     * @param c The character symbol representing the type of entity.
     * @param j The column index in the game map matrix.
     * @param i The row index in the game map matrix.
     */
    public static void InsertEntityRuleLevel1(char c, int j, int i) {
        switch (c) {
            case '0' -> {} // Empty space
            // platform block
            case '1' -> insertPlatform(EntityCreator.GLACIER_PLATFORM_BLOCK_, j, i);
            // obstacle: big ice block
            case '2' -> insertLargeObstacle(EntityCreator.GLACIER_LARGE_ICE_BLOCK_, j, i - 1);
            // obstacle: small ice block
            case '3' -> insertSmallObstacle(EntityCreator.GLACIER_SMALL_ICE_BLOCK_, j, i);
            // ice block for increasing speed
            case '4' -> insertFeatureBlock(EntityCreator.GLACIER_ICE_BLOCK_, FeatureBlock.ICE_BLOCK, j, i);
            // ice block for decreasing speed
            case '5' -> insertFeatureBlock(EntityCreator.GLACIER_SNOW_BLOCK_, FeatureBlock.SNOW_BLOCK, j, i);
            // supply: bottle water
            case '6' -> insertSupply(EntityCreator.BOTTLE_WATER_, SupplyBlock.BOTTLE_WATER_, j, i);
            // supply: can
            case '7' -> insertSupply(EntityCreator.CAN_, SupplyBlock.CAN_, j, i);
            // supply: cookie
            case '8' -> insertSupply(EntityCreator.COOKIE_, SupplyBlock.COOKIE_, j, i);
            // destination: igloo
            case '9' -> insertDestination(EntityCreator.IGLOO_, DestinationBlock.IGLOO_,j * BLOCK_SIZE,  (i - 1) * BLOCK_SIZE + 30);
            default -> throw new IllegalStateException("Unexpected character: " + c);
        }
    }

    /**
     * Inserts entities according to the rules for Level 2.
     *
     * @param c The character symbol representing the type of entity.
     * @param j The column index in the game map matrix.
     * @param i The row index in the game map matrix.
     */
    private static void InsertEntityRuleLevel2(char c, int j, int i) {
        switch (c) {
            case '0' -> {} // Empty space
            // platform block
            case '1' -> insertPlatform(EntityCreator.DESERT_PLATFORM_BLOCK_, j, i);
            // obstacle: stone
            case '2' -> insertSmallObstacle(EntityCreator.DESERT_STONE_BLOCK_, j, i);
            // obstacle: cactus
            case '3' -> insertSmallObstacle(EntityCreator.DESERT_CACTUS_BLOCK_, j, i);
            // enemy: fire dragon
            case '4' -> insertFireDragon(EntityCreator.FIRE_DRAGON_, EnemyNode.FIRE_DRAGON_, j, i);
            // enemy: mummy
            case '5' -> insertMummy(EntityCreator.MUMMY_, EnemyNode.MUMMY_, j, i);
            // supply: bottle water
            case '6' -> insertSupply(EntityCreator.BOTTLE_WATER_, SupplyBlock.BOTTLE_WATER_, j, i);
            // supply: can
            case '7' -> insertSupply(EntityCreator.CAN_, SupplyBlock.CAN_, j, i);
            // supply: cookie
            case '8' -> insertSupply(EntityCreator.COOKIE_, SupplyBlock.COOKIE_, j, i);
            // flying carpet
            case '9' -> insertFlyingCarpet(EntityCreator.FLYING_CARPET_, MovableObjectNode.FLYING_CARPET_, j, i);
            // destination: oasis
            case 'a' -> insertDestination(EntityCreator.OASIS_, DestinationBlock.OASIS_, j * BLOCK_SIZE,  (i - 1) * BLOCK_SIZE + 20);
            default -> throw new IllegalStateException("Unexpected character: " + c);
        }
    }

    /**
     * Inserts a platform block into the game at the specified location.
     *
     * @param type The type of platform block to create.
     * @param j    The column index in the game map matrix.
     * @param i    The row index in the game map matrix.
     */
    private static void insertPlatform(String type, int j, int i) {
        Entity platform = EntityCreator.createEntity(type, j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 1);
        ImageView platformImage = getImageView(platform);
        dataManager.getPlatforms().add(platformImage);
        sceneManager.getGameRoot().getChildren().add(platformImage);
    }

    /**
     * Inserts a large obstacle block into the game at the specified location.
     *
     * @param type The type of obstacle block to create.
     * @param j    The column index in the game map matrix.
     * @param i    The row index in the game map matrix.
     */
    private static void insertLargeObstacle(String type, int j, int i) {
        Entity obstacle = EntityCreator.createEntity(type, j * BLOCK_SIZE, i * BLOCK_SIZE, LARGE_BLOCK_SIZE, LARGE_BLOCK_SIZE, 1);
        ImageView obstacleImage = getImageView(obstacle);
        dataManager.getPlatforms().add(obstacleImage);
        sceneManager.getGameRoot().getChildren().add(obstacleImage);
    }

    /**
     * Inserts a small obstacle block into the game at the specified location.
     *
     * @param type The type of obstacle block to create.
     * @param j    The column index in the game map matrix.
     * @param i    The row index in the game map matrix.
     */
    private static void insertSmallObstacle(String type, int j, int i) {
        Entity obstacle = EntityCreator.createEntity(type, j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 1);
        ImageView obstacleImage = getImageView(obstacle);
        dataManager.getPlatforms().add(obstacleImage);
        sceneManager.getGameRoot().getChildren().add(obstacleImage);
    }

    /**
     * Inserts a feature block into the game at the specified location.
     * The feature block can have additional functionality, such as modifying player speed.
     *
     * @param type        The type of feature block to create.
     * @param featureType The specific feature type (e.g., ICE_BLOCK, SNOW_BLOCK).
     * @param j           The column index in the game map matrix.
     * @param i           The row index in the game map matrix.
     */
    private static void insertFeatureBlock(String type, String featureType, int j, int i) {
        Entity featureBlock = EntityCreator.createEntity(type, j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 1);
        ImageView featureImage = getImageView(featureBlock);
        dataManager.getPlatforms().add(featureImage);
        dataManager.getFeatureNodes().add(new FeatureNode(featureType, featureImage));
        sceneManager.getGameRoot().getChildren().add(featureImage);
    }

    /**
     * Inserts a supply block (e.g., water, can, cookie) into the game at the specified location.
     *
     * @param type       The type of supply block to create.
     * @param supplyType The specific supply type (e.g., BOTTLE_WATER, CAN, COOKIE).
     * @param j          The column index in the game map matrix.
     * @param i          The row index in the game map matrix.
     */
    private static void insertSupply(String type, String supplyType, int j, int i) {
        Entity supply = EntityCreator.createEntity(type, j * BLOCK_SIZE + SUPPLY_OFFSET_X, i * BLOCK_SIZE + SUPPLY_OFFSET_Y, SMALL_SUPPLY_SIZE, SMALL_SUPPLY_SIZE, 1);
        ImageView supplyImage = getImageView(supply);
        dataManager.getSupplyNodes().add(new SupplyNode(supplyType, supplyImage));
        sceneManager.getGameRoot().getChildren().add(supplyImage);
    }

    /**
     * Inserts a fire dragon enemy into the game at the specified location.
     *
     * @param type      The type of enemy block to create.
     * @param enemyType The specific enemy type (e.g., FIRE_DRAGON).
     * @param j         The column index in the game map matrix.
     * @param i         The row index in the game map matrix.
     */
    private static void insertFireDragon(String type, String enemyType, int j, int i) {
        FireDragonBlock fire_dragon_block = (FireDragonBlock) EntityCreator.createEntity(type, j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 1);
        ImageView fire_dragon_image = getImageView(fire_dragon_block);
        FireDragonNode fire_dragon = new FireDragonNode(enemyType, fire_dragon_image, fire_dragon_block.getRange());
        dataManager.getEnemyNodes().add(fire_dragon);
        dataManager.getMovableNodes().add(fire_dragon);
        sceneManager.getGameRoot().getChildren().add(fire_dragon_image);
    }

    /**
     * Inserts a mummy enemy into the game at the specified location.
     *
     * @param type      The type of enemy block to create.
     * @param enemyType The specific enemy type (e.g., MUMMY).
     * @param j         The column index in the game map matrix.
     * @param i         The row index in the game map matrix.
     */
    private static void insertMummy(String type, String enemyType, int j, int i) {
        MummyBlock mummy_block = (MummyBlock) EntityCreator.createEntity(type, j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, 1);
        ImageView mummy_image = getImageView(mummy_block);
        MummyNode mummy = new MummyNode(enemyType, mummy_image, mummy_block.getRange());
        dataManager.getEnemyNodes().add(mummy);
        dataManager.getMovableNodes().add(mummy);
        sceneManager.getGameRoot().getChildren().add(mummy_image);
    }

    /**
     * Inserts a flying carpet into the game at the specified location.
     * Flying carpets are movable platforms with unique behavior.
     *
     * @param type      The type of flying carpet block to create.
     * @param enemyType The specific type for the flying carpet (e.g., FLYING_CARPET).
     * @param j         The column index in the game map matrix.
     * @param i         The row index in the game map matrix.
     */
    private static void insertFlyingCarpet(String type, String enemyType, int j, int i) {
        FlyingCarpetBlock flying_carpet_block = (FlyingCarpetBlock) EntityCreator.createEntity(type, j * BLOCK_SIZE, i * BLOCK_SIZE, 200, 60, 1);
        ImageView flying_carpet_image = getImageView(flying_carpet_block);
        dataManager.getPlatforms().add(flying_carpet_image);
        dataManager.getMovableNodes().add(new FlyingCarpetNode(enemyType, flying_carpet_image, flying_carpet_block.getRange()));
        sceneManager.getGameRoot().getChildren().add(flying_carpet_image);
    }

    /**
     * Inserts a destination node into the game at the specified location.
     * Destination nodes mark the goal of a level (e.g., IGLOO, OASIS).
     *
     * @param type            The type of destination block to create.
     * @param destinationType The specific destination type (e.g., IGLOO, OASIS).
     * @param j               The x-coordinate for the destination.
     * @param i               The y-coordinate for the destination.
     */
    private static void insertDestination(String type, String destinationType, int j, int i) {
        Entity destination = EntityCreator.createEntity(type, j, i, DESTINATION_WIDTH, DESTINATION_HEIGHT, 1);
        ImageView destinationImage = getImageView(destination);
        dataManager.setDestinationNode(new DestinationNode(destinationType, destinationImage));
        sceneManager.getGameRoot().getChildren().add(destinationImage);
    }

    /**
     * Generates an {@link ImageView} for a given {@link Entity}.
     * <p>
     * Configures the position, size, and image of the {@link ImageView} based on the entity's properties.
     *
     * @param entity The entity for which the ImageView is generated.
     * @return The configured ImageView.
     */
    public static ImageView getImageView(Entity entity) {
        ImageView imageView = new ImageView();

        imageView.setTranslateX(entity.getX());
        imageView.setTranslateY(entity.getY());
        imageView.setImage(entity.getImage());
        imageView.setFitWidth(entity.getWidth());
        imageView.setFitHeight(entity.getHeight());
        imageView.setPreserveRatio(false);

        return imageView;
    }
}
