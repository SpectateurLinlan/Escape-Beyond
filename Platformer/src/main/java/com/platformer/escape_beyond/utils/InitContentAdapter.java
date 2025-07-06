package com.platformer.escape_beyond.utils;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.manager.TimeManager;
import com.platformer.escape_beyond.model.entity.LevelData;
import com.platformer.escape_beyond.Main;
import com.platformer.escape_beyond.controller.PlayerController;
import com.platformer.escape_beyond.model.game.EntitySelector;
import com.platformer.escape_beyond.model.entity.Map;
import com.platformer.escape_beyond.view.InitGameUi;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Adapter class for initializing game content.
 * <p>
 * This class adapts various components of the game, such as background, entities, player, and UI, to
 * initialize the game state and setup the necessary visuals and logic for gameplay.
 */
public class InitContentAdapter {
    private final LevelData levelData; // Instance of LevelData for dynamic level loading
    DataManager dataManager = DataManager.getInstance();
    SceneManager sceneManager = SceneManager.getInstance();
    /**
     * Constructor for InitContentAdapter.
     *
     * @param levelData    The LevelData instance for loading level-specific configurations.
     */
    public InitContentAdapter(LevelData levelData) {
        this.levelData = levelData;
    }

    /**
     * Initializes game content, including background, entities, player, and UI.
     * <p>
     * This method dynamically sets up the game state and visuals based on the current level data
     * from {@link LevelData}. It includes background setup, loading entities, initializing the
     * player controller, and adding UI elements to the game root.
     *
     * @throws IOException If there is an error during initialization.
     */
    public void initContent() throws IOException {
        // Load background picture
        ImageView bg = getBg();

        // Load data for the current map
        int idx = dataManager.getGameState().map.index - 1;
        dataManager.getGameState().totalSupplies = levelData.getLevelSupplies().get(idx);

        // Load level content
        String[] level = levelData.getLevels().get(idx);
        int levelWidth = level[0].length() * 60;  // Calculate level width

        // Initialize ranges for moving objects
        dataManager.setRangeIterator(new IntArrayIterator((ArrayList<int[]>) levelData.getLevelMovableObjectRanges().get(idx)));

        // Insert entities into the game based on level data
        for (int i = 0; i < level.length; i++) {
            String line = level[i];
            for (int j = 0; j < line.length(); j++) {
                EntitySelector.InsertEntity(line.charAt(j), j, i);
            }
        }
        // Initialize player controller with observer pattern
        dataManager.setPlayerController(new PlayerController(sceneManager.getCurrentScene(), sceneManager.getGameRoot(), levelWidth, dataManager.getGameState().character.index));
        // Start the game timer
        TimeManager.getInstance().getTimer().start();

        sceneManager.getAppRoot().getChildren().addAll(bg, sceneManager.getGameRoot());
        // Initialize and add the UI
        InitGameUi.initGameUi();
        sceneManager.getAppRoot().getChildren().add(sceneManager.getUiRoot());
    }

    /**
     * Generates an {@link ImageView} for the map's background.
     * <p>
     * The background image is determined by the current map index and stretched to fit the game window dimensions.
     *
     * @return The configured background ImageView.
     */
    private ImageView getBg() {
        ImageView bg = new ImageView(new Image(Objects.requireNonNull(
                Main.class.getResourceAsStream(Map.getRandomMapBackground(dataManager.getGameState().map.index))
        )));

        // Configure the background ImageView
        bg.setFitWidth(1280); // Game width
        bg.setFitHeight(720); // Game height
        bg.setPreserveRatio(false); // Stretch image to fill the screen
        bg.setOpacity(0.5); // Semi-transparent for visual effects
        return bg;
    }
}
