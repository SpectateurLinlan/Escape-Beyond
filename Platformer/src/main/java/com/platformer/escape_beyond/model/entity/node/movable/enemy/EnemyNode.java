package com.platformer.escape_beyond.model.entity.node.movable.enemy;

import com.platformer.escape_beyond.model.entity.node.movable.MovableNode;
import javafx.scene.Node;

/**
 * Represents an enemy node in the game.
 * An enemy node extends the {@link MovableNode} class and includes a type to specify the enemy's characteristics
 * (e.g., "fire_dragon", "mummy"). It also contains a {@link Node} object for graphical or logical representation.
 */
public class EnemyNode extends MovableNode {

    public static final String FIRE_DRAGON_ = "fire_dragon"; // Constant for the "fire_dragon" enemy type.
    public static final String MUMMY_ = "mummy";            // Constant for the "mummy" enemy type.

    public String enemyType; // The type of the enemy (e.g., "fire_dragon", "mummy").

    /**
     * Constructs an {@code EnemyNode} with the specified enemy type and graphical representation.
     *
     * @param enemyType The type of the enemy (e.g., "fire_dragon", "mummy", or other enemy types).
     *                  This specifies the characteristics or behavior associated with the enemy.
     * @param node      The {@link Node} object representing the graphical or logical representation of the enemy.
     */
    public EnemyNode(String enemyType, Node node) {
        this.node = node;
        this.enemyType = enemyType;
    }
}
