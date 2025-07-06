package com.platformer.escape_beyond.model.entity.node.movable.platform;

import com.platformer.escape_beyond.model.entity.node.movable.MovableNode;
import javafx.scene.Node;

/**
 * Represents a specific type of movable object node in the game.
 * <p>
 * This class extends the {@link MovableNode} to add additional characteristics
 * specific to movable objects, such as their type. Examples include objects like
 * flying carpets that have distinct behaviors or attributes.
 */
public abstract class MovableObjectNode extends MovableNode {

    /** Constant representing the type of a flying carpet. */
    public static final String FLYING_CARPET_ = "flying_carpet";

    /** The type of the movable object (e.g., "flying_carpet"). */
    public String movableObjectType;

    /**
     * Constructor for MovableObjectNode.
     * <p>
     * Initializes the movable object node with its type and graphical representation.
     *
     * @param movableObjectType The type of the movable object (e.g., "flying_carpet").
     * @param node The graphical representation of the movable object.
     */
    public MovableObjectNode(String movableObjectType, Node node) {
        this.node = node;
        this.movableObjectType = movableObjectType;
    }
}
