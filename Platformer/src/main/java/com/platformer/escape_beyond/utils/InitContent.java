package com.platformer.escape_beyond.utils;

import com.platformer.escape_beyond.model.entity.LevelData;

import java.io.IOException;

/**
 * Utility class for initializing game content based on the current map.
 * <p>
 * Implements the Adapter Design Pattern to delegate content initialization
 * to an adapter class, {@link InitContentAdapter}, for flexibility and scalability.
 */
public class InitContent {
    /** Adapter instance for handling content initialization. */
    private final InitContentAdapter adapter;

    /**
     * Constructs an {@code InitContent} object with the provided {@link LevelData}.
     * <p>
     * This constructor initializes the internal {@link InitContentAdapter}, which is
     * responsible for performing the actual content setup based on the current game level.
     * </p>
     *
     * @param levelData The {@link LevelData} object containing level-specific configurations.
     */
    public InitContent(LevelData levelData) {
        this.adapter = new InitContentAdapter(levelData);
    }
    /**
     * Initializes the game content dynamically based on the current map index.
     * <p>
     * This method modifies the content of the {@code appRoot} without returning any data.
     * Delegates the initialization logic to the {@link InitContentAdapter}.
     *
     * @throws IOException If an error occurs during content initialization.
     */
    public void initContent() throws IOException {
        adapter.initContent();
    }
}
