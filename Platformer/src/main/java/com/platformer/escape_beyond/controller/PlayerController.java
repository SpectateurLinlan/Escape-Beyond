package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.manager.GameManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.model.game.PlayerModel;
import com.platformer.escape_beyond.model.entity.block.feature.FeatureBlock;
import com.platformer.escape_beyond.model.entity.node.movable.MovableNode;
import com.platformer.escape_beyond.model.entity.node.movable.enemy.EnemyNode;
import com.platformer.escape_beyond.model.entity.node.stationary.DestinationNode;
import com.platformer.escape_beyond.model.entity.node.stationary.FeatureNode;
import com.platformer.escape_beyond.model.entity.node.stationary.SupplyNode;
import com.platformer.escape_beyond.view.PlayerView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Controller class responsible for managing player movement, physics, collisions,
 * and interactions in the game.
 * <p>
 * The {@code PlayerController} bridges the {@link PlayerModel} (data layer) and
 * {@link PlayerView} (visual layer) to ensure the player's behavior aligns
 * with the game environment.
 */
public class PlayerController {
    private final PlayerModel playerModel; // The player's data model.
    private final PlayerView playerView;  // The player's visual representation.

    private static final DataManager dataManager = DataManager.getInstance();
    private final List<Node> platforms = dataManager.getPlatforms(); // List of platform nodes in the game.
    private final List<FeatureNode> featureNodes = dataManager.getFeatureNodes(); // List of special feature blocks.
    private final List<SupplyNode> supplyNodes = dataManager.getSupplyNodes(); // List of collectible supply nodes.
    private final DestinationNode destinationNode = dataManager.getDestinationNode(); // The goal node of the level.
    private final List<MovableNode> movableNodes = dataManager.getMovableNodes(); // List of movable objects in the game.
    private final List<EnemyNode> enemyNodes = dataManager.getEnemyNodes(); // List of enemies in the game.
    private final HashMap<KeyCode, Boolean> keys = new HashMap<>(); // Tracks key press states.

    private final int levelWidth; // The width of the current level.
    private boolean isMovingRight = true; // For determining direction and mirror
    private static final int MOVE_STEP = 5; // Movement step for horizontal motion
    private static final int SCREEN_HEIGHT_THRESHOLD = 780; // Player Y position threshold to trigger game over
    private static final int CENTER_RANGE_MIN = 635; // Minimum X coordinate for central range
    private static final int CENTER_RANGE_MAX = 645; // Maximum X coordinate for central range

    /**
     * Constructs a PlayerController to manage the player's movement and actions.
     *
     * @param scene      The game scene, used to capture key press events.
     * @param root       The root pane containing all game elements.
     * @param levelWidth The width of the level.
     * @param index      The index of the character selected by the player.
     */
    public PlayerController(Scene scene, Pane root, int levelWidth, int index) {
        playerModel = new PlayerModel();
        playerView = new PlayerView(root, playerModel, index);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
        this.levelWidth = levelWidth;
    }

    /**
     * Updates the player's position, velocity, and checks for collisions and interactions.
     *
     * @throws IOException If an error occurs during game state changes.
     */
    public void update() throws IOException {
        handlePlayerInput(); // Handle key input

        movePlayerY((int) playerModel.getPlayerVelocity().getY()); // Apply vertical velocity.
        if (playerModel.getPlayerVelocity().getY() < 10) {
            playerModel.setPlayerVelocity(playerModel.getPlayerVelocity().add(0, 1)); // Apply gravity.
        }
        playerModel.notifyObservers(); // Notify the view to update.

        // If playerY is smaller than 780, means player is out of screen (drop into the dark hole)
        // actually, it should be 720, but we add 60 to make sure that the player has opportunity to jump out of the dark hole
        // then game over
        if (playerModel.getY() > SCREEN_HEIGHT_THRESHOLD) {
            try {
                GameManager.getInstance().gameOver();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        checkSupplyCollection(); // Check for interactions with supply nodes.
        checkDestinationReached(); // Check whether the player is at the place of destination
        checkEnemyCollision(); // check if the player being attacked by enemy
    }

    /**
     * Handles player movement based on key inputs.
     */
    private void handlePlayerInput() {
        if (isPressed(KeyCode.W) && playerModel.getY() >= MOVE_STEP) {
            jumpPlayer();
        }
        if (isPressed(KeyCode.A) && playerModel.getX() >= MOVE_STEP) {
            movePlayerX(-MOVE_STEP);
        }
        if (isPressed(KeyCode.D) && playerModel.getX() + playerView.getPlayerNode().getBoundsInLocal().getWidth() <= levelWidth - MOVE_STEP) {
            movePlayerX(MOVE_STEP);
        }
    }

    /**
     * when player press a key, check if it is pressed or not
     * @param keyCode
     * @return
     */
    private boolean isPressed(KeyCode keyCode) {
        return keys.getOrDefault(keyCode, false);
    }

    /**
     * Checks and handles collisions with supply nodes.
     */
    private void checkSupplyCollection(){
        SupplyNode toBeDeleted = null;

        for (SupplyNode supplyNode: supplyNodes) {
            if (supplyNode.node.getBoundsInParent().intersects(playerView.getPlayerNode().getBoundsInParent())) {
                System.out.println("Collected supply!");
                // When get the supply, delete it from the array
                toBeDeleted = supplyNode;
                DataManager.getInstance().getGameState().collectedSupplies += 1;
                break;
            }
        }
        if (toBeDeleted != null) {
            SceneManager.getInstance().getGameRoot().getChildren().remove(toBeDeleted.node);
            supplyNodes.remove(toBeDeleted);
        }
    }

    /**
     * Checks if the player has reached the destination.
     *
     * @throws IOException If an error occurs while switching to the "win" scene.
     */
    private void checkDestinationReached() throws IOException {
        double midPlayerX = (playerView.getPlayerNode().getTranslateX() +
                playerView.getPlayerNode().getBoundsInLocal().getWidth() / 2);

        if (destinationNode != null && destinationNode.node.getBoundsInParent().contains(midPlayerX, playerModel.getY() + 70)) {
            GameManager.getInstance().gameWin();
        }
    }

    /**
     * Checks if the player is attacked by an enemy.
     *
     * @throws IOException If an error occurs while switching to the "game over" scene.
     */
    private void checkEnemyCollision() throws IOException {
        for (EnemyNode enemyNode : enemyNodes) {
            if (enemyNode.node.getBoundsInParent().intersects(playerView.getPlayerNode().getBoundsInParent())) {
                GameManager.getInstance().gameOver();
                return;
            }
        }
    }

    /**
     * Determines the speed factor based on the feature block the player is standing on.
     *
     * @param midPlayerX The middle X coordinate of the player.
     * @return The speed factor (default is 1, increased or decreased based on the block type).
     */
    private double calculateSpeedFactor(double midPlayerX){
        double speed_factor = 1;

        // judge if the player is on the feature blocks
        for (FeatureNode featureNode : featureNodes) {
            if (featureNode.node.getBoundsInParent().contains(midPlayerX, playerModel.getY() + 70)) {
                speed_factor = switch (featureNode.featureType) {
                    case FeatureBlock.ICE_BLOCK -> 2;
                    case FeatureBlock.SNOW_BLOCK -> 0.5;
                    default -> speed_factor;
                };
                break;
            }
        }
        return speed_factor;
    }

    /**
     * Moves the player horizontally by a specified value.
     * <p>
     * Handles collision detection, adjusts speed based on feature blocks,
     * and ensures platforms or the player move based on position.
     *
     * @param value The horizontal distance to move. Positive for right, negative for left.
     */
    private void movePlayerX(int value) {
        boolean movingRight = value > 0;

        if (isMovingRight != movingRight) {
            playerView.mirror(); // Mirror the player's view if direction changes.
        }
        isMovingRight = movingRight;

        // calculate the middle point of player
        double playerMinX = playerView.getPlayerNode().getTranslateX();
        double playerMaxX = playerMinX + playerView.getPlayerNode().getBoundsInLocal().getWidth();
        double midPlayerX = (playerMinX + playerMaxX) / 2;

        double speedFactor = calculateSpeedFactor(midPlayerX);

        // when the player is in the center range, move platforms instead of player
        boolean isInCenterRange = midPlayerX < CENTER_RANGE_MAX && midPlayerX > CENTER_RANGE_MIN;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : platforms) {
                // get platform boundaries
                double platformMinX = platform.getBoundsInParent().getMinX();
                double platformMaxX = platform.getBoundsInParent().getMaxX();

                // check the collision
                if (playerView.getPlayerNode().getBoundsInParent().intersects(platform.getBoundsInParent())
                        && (playerView.getPlayerNode().getTranslateY() + 50 != platform.getTranslateY())) {
                    // when colliding with platforms, check if the player is in the center range, if yes, move platforms, otherwise, update player position
                    if (movingRight) {
                        if (playerMaxX >= platformMinX && playerMinX < platformMinX) {
                            return;
                        }
                    } else {
                        if (playerMinX <= platformMaxX && playerMaxX > platformMaxX) {
                            return;
                        }
                    }
                }
            }

            // if the player is in the center range, move platforms instead of player
            //  && platformMinX <= 5 && platformMaxX >= 1275
            double displacement = speedFactor * (movingRight ? -1 : 1);
            if (isInCenterRange) {
                // move platforms
                for (Node platform : platforms) {
                    platform.setTranslateX(platform.getTranslateX() + displacement);
                }

                // move supplies and destination
                for (SupplyNode supplyNode: supplyNodes) {
                    supplyNode.node.setTranslateX(supplyNode.node.getTranslateX() + displacement);
                }
                destinationNode.node.setTranslateX(destinationNode.node.getTranslateX() + displacement);

                // move movable objects
                for (MovableNode movableNode: movableNodes) {
                    if (!platforms.contains(movableNode.node)) movableNode.node.setTranslateX(movableNode.node.getTranslateX() + displacement);
                }
            } else {
                // otherwise, update player position
                playerModel.setX((int) (playerModel.getX() - displacement));
                playerView.getPlayerNode().setTranslateX(playerModel.getX());
            }
        }
    }

    /**
     * Moves the player vertically based on the specified value.
     * <p>
     * Handles gravity and collision detection with platforms.
     *
     * @param value The vertical distance to move. Positive for down, negative for up.
     */
    private void movePlayerY(int value) {
        boolean movingDown = value > 0;
        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : platforms) {
                // get platform boundaries
                double platformMinY = platform.getBoundsInParent().getMinY();
                double platformMaxY = platform.getBoundsInParent().getMaxY();
                double playerMinY = playerView.getPlayerNode().getTranslateY();
                double playerMaxY = playerMinY + playerView.getPlayerNode().getBoundsInLocal().getHeight(); // use actual height

                if (playerView.getPlayerNode().getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        if (playerMaxY >= platformMinY && playerMinY < platformMinY) {
                            playerModel.setY((int) (platformMinY - playerView.getPlayerNode().getBoundsInLocal().getHeight()));
                            playerModel.setCanJump(true); // can jump again
                            return; // update player position and return
                        }
                    } else {
                        if (playerMinY <= platformMaxY && playerMaxY > platformMaxY) {
                            playerModel.setY((int) platformMaxY);
                            return; // update player position and return
                        }
                    }
                }
            }

            // update position
            playerModel.setY(playerModel.getY() + (movingDown ? 1 : -1));
            playerView.getPlayerNode().setTranslateY(playerModel.getY());
        }
    }

    /**
     * when player press W, jump
     */
    private void jumpPlayer() {
        if (playerModel.isCanJump()) {
            playerModel.setPlayerVelocity(playerModel.getPlayerVelocity().add(0, -30));
            playerModel.setCanJump(false);
        }
    }
}