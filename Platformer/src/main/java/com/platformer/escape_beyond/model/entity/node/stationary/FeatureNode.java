package com.platformer.escape_beyond.model.entity.node.stationary;

import javafx.scene.Node;

/**
 * A class representing a feature node in the game.
 * <p>
 * This class associates a specific feature type (e.g., "ice_block", "snow_block")
 * with its corresponding graphical or logical representation as a {@link Node}.
 * Feature nodes are used to define game mechanics or environmental effects
 * based on the feature type.
 */
public class FeatureNode {

    /**
     * The {@link Node} object representing the graphical or logical component of the feature.
     */
    public Node node;

    /**
     * The type of feature represented by this node (e.g., "ice_block", "snow_block").
     */
    public String featureType;

    /**
     * Constructor for the FeatureNode class.
     * <p>
     * Initializes a new feature node with the specified feature type and its associated {@link Node}.
     *
     * @param featureType The type of the feature (e.g., "ice_block", "snow_block").
     *                    This determines the behavior or effect of the feature in the game.
     * @param node        The {@link Node} representing the graphical or logical representation
     *                    of the feature in the game world.
     */
    public FeatureNode(String featureType, Node node) {
        this.featureType = featureType;
        this.node = node;
    }
}
