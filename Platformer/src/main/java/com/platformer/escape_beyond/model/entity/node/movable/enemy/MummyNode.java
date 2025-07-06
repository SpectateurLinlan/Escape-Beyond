package com.platformer.escape_beyond.model.entity.node.movable.enemy;

import com.platformer.escape_beyond.pattern.LineMove;
import javafx.scene.Node;

/**
 * Represents a Mummy enemy in the game, which moves within a specified range.
 * <p>
 * This class extends {@link EnemyNode} and uses the {@link LineMove} strategy
 * to define its movement behavior. The Mummy enemy moves back and forth in a straight line
 * between the boundaries defined by its range.
 * </p>
 * <p>
 * This class is part of the implementation of the Strategy Design Pattern,
 * where different types of enemies can have varied movement behaviors assigned dynamically.
 * </p>
 */
public class MummyNode extends EnemyNode {
    /**
     * The moving velocity of the Mummy enemy.
     */
    private static final int MUMMY_MOVING_VELOCITY = 1;

    /**
     * Constructs a new {@code MummyNode} object.
     * <p>
     * Initializes the mummy's movement behavior using the {@link LineMove} strategy,
     * which makes it move horizontally between the specified range at a constant velocity.
     * The velocity is defined by {@code MUMMY_MOVING_VELOCITY}.
     * </p>
     *
     * @param enemyType A {@code String} representing the type of the enemy (e.g., "mummy").
     * @param node      The {@link Node} object representing the graphical element of the mummy.
     *                  This is typically a JavaFX graphical component.
     * @param range     An integer array specifying the movement boundaries for the mummy.
     *                  The array should have two elements: the starting x-coordinate and the ending x-coordinate.
     *                  For example, {@code range = [100, 300]} makes the mummy move between x=100 and x=300.
     */
    public MummyNode(String enemyType, Node node, int[] range) {
        super(enemyType, node);
        movable = new LineMove(range, node, MUMMY_MOVING_VELOCITY, true);
    }
}
