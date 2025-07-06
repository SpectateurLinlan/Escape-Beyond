package com.platformer.escape_beyond.model.entity.node.stationary;

import javafx.scene.Node;

/**
 * Represents a supply node in the game.
 * <p>
 * The {@code SupplyNode} class encapsulates a supply entity's type and graphical representation (node).
 * It is used to manage supply-related interactions within the game.
 * </p>
 */
public class SupplyNode {

    /** The type of the supply (e.g., "bottle_water", "can", "cookie"). */
    public String SupplyType;

    /** The graphical representation of the supply node. */
    public Node node;

    /**
     * Constructs a new {@code SupplyNode} object.
     *
     * @param supplyType The type of the supply (e.g., "bottle_water", "can", "cookie").
     *                   This defines the characteristics or behavior of the supply.
     * @param node       The graphical representation of the supply node.
     */
    public SupplyNode(String supplyType, Node node) {
        this.SupplyType = supplyType;
        this.node = node;
    }
}
