package com.platformer.escape_beyond.model.entity.node.movable.enemy;


import com.platformer.escape_beyond.pattern.LineMove;
import javafx.scene.Node;

/**
 * Represents a fire dragon enemy in the game.
 * <p>
 * The fire dragon is a type of enemy that moves within a specified range in a straight line.
 * This class extends the {@link EnemyNode} class and uses the {@link LineMove} strategy
 * to define its movement behavior.
 */
public class FireDragonNode extends EnemyNode {
    /**
     * The moving velocity of the Fire Dragon enemy.
     */
    private static final int FIRE_DRAGON_MOVING_VELOCITY = 1;

    /**
     * Constructs a new {@code FireDragonNode} with the specified parameters.
     *
     * @param enemyType The type of the enemy, typically used to identify the fire dragon.
     * @param node      The {@link Node} object representing the graphical or logical representation
     *                  of this fire dragon in the game world.
     * @param range     An array of two integers specifying the movement range of the fire dragon.
     *                  The first value represents the minimum range, and the second value represents
     *                  the maximum range.
     */
    public FireDragonNode(String enemyType, Node node, int[] range) {
        super(enemyType, node);
        movable = new LineMove(range, node, FIRE_DRAGON_MOVING_VELOCITY, true);
    }
}
