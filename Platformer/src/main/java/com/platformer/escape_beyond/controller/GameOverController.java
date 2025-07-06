package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.Main;
import com.platformer.escape_beyond.manager.GameManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.model.entity.Map;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;

/**
 * The controller class for the Game Over screen of the game.
 * It handles user interactions after the game fails, allowing the player to restart the game
 * or return to the main menu.
 */
public class GameOverController {

    @FXML
    public ImageView backgroundImage;
    @FXML
    public ImageView restart;
    @FXML
    public ImageView exit2Menu;

    /**
     * Initializes the Game Over screen.
     * Sets the background image, adjusts its size, and applies visual effects such as opacity.
     */
    @FXML
    public void initialize() {
        backgroundImage.setImage(new Image(Objects.requireNonNull(
                Main.class.getResourceAsStream(Map.getRandomMapBackground(DataManager.getInstance().getGameState().map.index))
        )));

        backgroundImage.setFitWidth(1280); // Set the width to 1280
        backgroundImage.setFitHeight(720); // Set the height to 720
        backgroundImage.setPreserveRatio(false); // Disable preserving the aspect ratio to stretch the image
        backgroundImage.setOpacity(0.5); // Set the opacity to 0.5
    }

    /**
     * Handles the action when the user clicks the Restart button.
     * Resets the game state and restarts the game.
     *
     * @param event The action event triggered by clicking the Restart button.
     * @throws IOException If an error occurs while restarting the game.
     */
    @FXML
    public void MouseClicked_Restart(MouseEvent event) throws IOException {
        System.out.println("Restart game");
        GameManager.getInstance().startGame();
    }

    /**
     * Handles the action when the user clicks the Exit button.
     * Returns the user to the main menu.
     *
     * @param event The action event triggered by clicking the Exit button.
     * @throws IOException If an error occurs while navigating to the main menu.
     */
    @FXML
    public void ExitButtonAction(MouseEvent event) throws IOException {
        SceneManager.getInstance().setRoot("home");
    }
}