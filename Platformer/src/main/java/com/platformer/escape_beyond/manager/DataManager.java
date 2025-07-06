package com.platformer.escape_beyond.manager;

import com.platformer.escape_beyond.controller.PlayerController;
import com.platformer.escape_beyond.model.entity.node.movable.MovableNode;
import com.platformer.escape_beyond.model.entity.node.movable.enemy.EnemyNode;
import com.platformer.escape_beyond.model.entity.node.stationary.DestinationNode;
import com.platformer.escape_beyond.model.entity.node.stationary.FeatureNode;
import com.platformer.escape_beyond.model.entity.node.stationary.SupplyNode;
import com.platformer.escape_beyond.model.game.GameState;
import com.platformer.escape_beyond.utils.IntArrayIterator;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages and centralizes game-related data for the game.
 * <p>
 * This class implements the Singleton design pattern, ensuring that only one instance
 * of {@code DataManager} exists throughout the application. It provides centralized
 * access to game state, player data, platform nodes, and other entities in the game.
 * </p>
 * <p>
 * The class also provides utility methods to initialize, retrieve, and clear game data.
 * </p>
 */
public class DataManager {

    // This is the singleton-instance
    private static DataManager instance;

    // Interface-oriented programming is the use of interfaces as data types which reduces the coupling of code
    private final List<Node> platforms; // List of platform nodes in the game
    private final List<FeatureNode> featureNodes; // List of feature nodes
    private final List<SupplyNode> supplyNodes ; // List of supply nodes
    private DestinationNode destinationNode; // The destination node in the game
    private final List<MovableNode> movableNodes ; // List of movable nodes
    private final List<EnemyNode> enemyNodes; // List of enemy nodes
    private PlayerController playerController; // Controller for player actions

    private IntArrayIterator rangeIterator; // Iterator for handling movable object ranges
    private GameState gameState; // Represents the current game state

    /**
     * Returns the singleton instance of {@code DataManager}.
     * <p>
     * If no instance exists, a new one is created. Ensures that only one instance
     * of {@code DataManager} exists throughout the application.
     * </p>
     *
     * @return The singleton instance of {@code DataManager}.
     */
    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    private DataManager(){
        this.platforms = new ArrayList<>(); // List of platform nodes in the game
        this.featureNodes = new ArrayList<>(); // List of feature nodes
        this.supplyNodes = new ArrayList<>(); // List of supply nodes
        this.movableNodes = new ArrayList<>(); // List of movable nodes
        this.enemyNodes = new ArrayList<>(); // List of enemy nodes
    }

    /**
     * Initializes the game state and other related components.
     * <p>
     * This method sets up the initial game state and resets the range iterator.
     */
    public void init() {
        gameState = new GameState();
        rangeIterator = null;
    }

    /**
     * Retrieves the current game state.
     *
     * @return The {@code GameState} object representing the current game state.
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * Sets the current game state.
     *
     * @param gameState The {@code GameState} object to set as the current game state.
     */
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Retrieves the range iterator for movable object ranges.
     *
     * @return The {@code IntArrayIterator} used for movable object ranges.
     */
    public IntArrayIterator getRangeIterator() {
        return rangeIterator;
    }

    /**
     * Sets the range iterator for movable object ranges.
     *
     * @param rangeIterator The {@code IntArrayIterator} to set.
     */
    public void setRangeIterator(IntArrayIterator rangeIterator) {
        this.rangeIterator = rangeIterator;
    }

    /**
     * Retrieves the list of platform nodes in the game.
     *
     * @return A {@code List} of {@code Node} objects representing platform nodes.
     */
    public List<Node> getPlatforms() {
        return platforms;
    }

    /**
     * Retrieves the list of feature nodes in the game.
     *
     * @return A {@code List} of {@code FeatureNode} objects.
     */
    public List<FeatureNode> getFeatureNodes() {
        return featureNodes;
    }

    /**
     * Retrieves the list of supply nodes in the game.
     *
     * @return A {@code List} of {@code SupplyNode} objects.
     */
    public List<SupplyNode> getSupplyNodes() {
        return supplyNodes;
    }

    /**
     * Retrieves the destination node in the game.
     *
     * @return The {@code DestinationNode} representing the game's goal.
     */
    public DestinationNode getDestinationNode() {
        return destinationNode;
    }

    /**
     * Sets the destination node in the game.
     *
     * @param destinationNode The {@code DestinationNode} to set.
     */
    public void setDestinationNode(DestinationNode destinationNode) {
        this.destinationNode = destinationNode;
    }

    /**
     * Retrieves the list of movable nodes in the game.
     *
     * @return A {@code List} of {@code MovableNode} objects.
     */
    public List<MovableNode> getMovableNodes() {
        return movableNodes;
    }

    /**
     * Retrieves the list of enemy nodes in the game.
     *
     * @return A {@code List} of {@code EnemyNode} objects.
     */
    public List<EnemyNode> getEnemyNodes() {
        return enemyNodes;
    }

    /**
     * Retrieves the player controller.
     *
     * @return The {@code PlayerController} managing player actions.
     */
    public PlayerController getPlayerController() {
        return playerController;
    }

    /**
     * Sets the player controller.
     *
     * @param playerController The {@code PlayerController} to set.
     */
    public void setPlayerController(PlayerController playerController) {
        if (playerController == null) {
            System.err.println("Attempting to set a null PlayerController!");
        } else {
            System.out.println("PlayerController has been successfully initialized.");
        }
        this.playerController = playerController;
    }


    /**
     * Clears all game-related data, resetting the game to its initial state.
     * <p>
     * This method clears all nodes, resets the destination node and player controller,
     * and prepares the game data for a new session.
     */
    public void clearGameState() {
        platforms.clear();
        featureNodes.clear();
        supplyNodes.clear();
        movableNodes.clear();
        enemyNodes.clear();
        destinationNode = null;
        playerController = null;
    }
}
