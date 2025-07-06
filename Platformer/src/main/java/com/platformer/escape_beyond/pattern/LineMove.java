package com.platformer.escape_beyond.pattern;

import javafx.scene.Node;

/**
 * A concrete implementation of the {@link Movable} interface for linear movement.
 * <p>
 * This class moves a {@link Node} object within a specified range along the X-axis.
 * It supports reversing direction at the boundaries and optionally flipping the node visually.
 */
public class LineMove implements Movable {

    private final int startRange;      // Start of the range
    private final int endRange;        // End of the range
    private final Node node;           // The node to be moved
    private final int velocity;        // Movement velocity (positive value)
    private final boolean shouldFlip;  // Whether to visually flip the node on direction change

    private int currentX;              // Current position within the range
    private boolean isMovingRight;     // Direction of movement

    /**
     * Constructs a {@code LineMove} object with the given parameters.
     *
     * @param range       An array of two integers representing the start and end of the range (inclusive).
     * @param node        The {@link Node} object to be moved.
     * @param velocity    The speed of movement (must be positive).
     * @param shouldFlip  Whether the node should visually flip its orientation on direction change.
     * @throws IllegalArgumentException if the range array is invalid or the velocity is non-positive.
     */
    public LineMove(int[] range, Node node, int velocity, boolean shouldFlip) {
        if (range == null || range.length != 2 || range[0] >= range[1]) {
            throw new IllegalArgumentException("Range must be a valid array with two values: [start, end].");
        }
        if (velocity <= 0) {
            throw new IllegalArgumentException("Velocity must be a positive value.");
        }
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null.");
        }

        this.startRange = range[0];
        this.endRange = range[1];
        this.node = node;
        this.velocity = velocity;
        this.shouldFlip = shouldFlip;
        this.currentX = 0;
        this.isMovingRight = true;
    }

    /**
     * Moves the node along the X-axis within the defined range.
     * <p>
     * If the node reaches the end of the range, it reverses direction
     * and optionally flips its visual orientation.
     */
    @Override
    public void step_move() {
        if (isMovingRight) {
            if (currentX < endRange) {
                moveNode(velocity);
                currentX += velocity;
            } else {
                reverseDirection();
            }
        } else {
            if (currentX > startRange) {
                moveNode(-velocity);
                currentX -= velocity;
            } else {
                reverseDirection();
            }
        }
    }

    /**
     * Moves the node by the specified delta on the X-axis.
     *
     * @param deltaX The amount to move the node along the X-axis.
     */
    private void moveNode(int deltaX) {
        node.setTranslateX(node.getTranslateX() + deltaX);
    }

    /**
     * Reverses the direction of movement and optionally flips the node's visual orientation.
     */
    private void reverseDirection() {
        isMovingRight = !isMovingRight;
        if (shouldFlip) {
            flipNode();
        }
    }

    /**
     * Flips the node's visual orientation by scaling it horizontally.
     */
    private void flipNode() {
        node.setScaleX(node.getScaleX() * -1);
    }

    // Getters for immutability and encapsulation

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public int getVelocity() {
        return velocity;
    }

    public boolean isShouldFlip() {
        return shouldFlip;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public Node getNode() {
        return node;
    }
}
