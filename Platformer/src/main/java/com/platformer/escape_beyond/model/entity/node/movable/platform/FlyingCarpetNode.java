package com.platformer.escape_beyond.model.entity.node.movable.platform;

import com.platformer.escape_beyond.pattern.LineMove;
import javafx.scene.Node;

/**
 * Represents a flying carpet node in the game.
 * <p>
 * The flying carpet node is a movable object that operates within a specified range.
 * It uses a {@link LineMove} movement strategy and interacts with the player as a dynamic platform.
 */
public class FlyingCarpetNode extends MovableObjectNode {

    /**
     * The moving velocity of the Flying Carpet object.
     */
    private static final int FLYING_CARPET_MOVING_VELOCITY = 1;

    /**
     * Constructs a new {@code FlyingCarpetNode} with the specified type, graphical node, and movement range.
     *
     * @param movableObjectType The type of the movable object, e.g., "FlyingCarpet".
     * @param node              The {@link Node} object representing the flying carpet's visual or logical element.
     * @param range             An array of two integers defining the movement range of the flying carpet.
     *                          The first value specifies the starting position, and the second value specifies the ending position.
     */
    public FlyingCarpetNode(String movableObjectType, Node node, int[] range) {
        super(movableObjectType, node);
        // Sets the movement behavior to a linear motion within the defined range.
        movable = new LineMove(range, node, FLYING_CARPET_MOVING_VELOCITY, false);
    }
}
