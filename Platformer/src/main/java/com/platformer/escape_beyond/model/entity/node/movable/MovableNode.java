package com.platformer.escape_beyond.model.entity.node.movable;

import com.platformer.escape_beyond.pattern.Movable;
import javafx.scene.Node;

/**
 * Represents a node in the game that can move dynamically.
 * <p>
 * This abstract class serves as the base for all movable objects in the game,
 * integrating the {@link Movable} interface for movement behavior.
 * Subclasses define specific types of movable nodes (e.g., enemies, objects).
 */
public abstract class MovableNode {

    /** The graphical representation of the movable node in the game. */
    public Node node;

    /** The movement behavior of the node, implemented using the {@link Movable} pattern. */
    protected Movable movable;

    /**
     * Updates the position of the node based on its movement behavior.
     * <p>
     * This method is typically called in the game loop to ensure the node's
     * position is updated at each frame, based on its movement strategy.
     */
    public void step_move() {
        movable.step_move();
    }
    public void setMoveBehavior(Movable mv) {movable = mv;}
}
