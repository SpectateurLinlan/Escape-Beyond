package com.platformer.escape_beyond.model.entity.node.stationary;

import javafx.scene.Node;

/**
 * Represents a destination node in the game.
 * A destination node is a logical or graphical representation of the endpoint for a level.
 * It is associated with a specific destination type (e.g., "IGLOO", "OASIS") and a {@link Node} object for rendering.
 */
public class DestinationNode {

    public Node node; // The graphical or logical representation of the destination.
    public String destinationType; // The type of the destination (e.g., "IGLOO", "OASIS").

    /**
     * Constructs a {@code DestinationNode} with the specified type and graphical representation.
     *
     * @param destinationType The type of the destination (e.g., "IGLOO", "OASIS", or other types).
     *                        This determines the specific kind of destination represented by this node.
     * @param node            The {@link Node} object representing the graphical or logical representation of this destination.
     */
    public DestinationNode(String destinationType, Node node) {
        this.node = node;
        this.destinationType = destinationType;
    }
}
