package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.manager.GameManager;
import com.platformer.escape_beyond.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Controller class for the Maps page in the platformer game.
 * This handles user interactions with buttons and image elements, allowing players to select levels
 * or navigate back to the home screen.
 */
public class MapsController {

    @FXML
    public ImageView Maps_backgroundImage; // Background image of the Maps page.

    @FXML
    public ImageView level1_image; // Image representing level 1.

    @FXML
    public ImageView level2_image; // Image representing level 2.
    @FXML
    public Button Maps_glacier_button;
    @FXML
    public Button Maps_desert_button;
    @FXML
    public ImageView Maps_closePage; // Image to navigate back to the home screen.

    DataManager dataManager = DataManager.getInstance();
    GameManager gameManager = GameManager.getInstance();
    /**
     * Switches to the Home screen when the close button is clicked.
     *
     * @param actionEvent The mouse event triggered by clicking the close button.
     * @throws IOException If an error occurs while switching to the home screen.
     */
    @FXML
    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        SceneManager.getInstance().setRoot("home");
    }

    /**
     * Adds visual effects (glow and shadow) to the level 1 image when the mouse hovers over it.
     *
     * @param event The mouse event triggered by hovering over the level 1 image.
     */
    @FXML
    public void Change_glacierImageEffect(MouseEvent event) {
        applyImageEffect(level1_image, 220, 500);
    }

    /**
     * Adds visual effects (glow and shadow) to the level 2 image when the mouse hovers over it.
     *
     * @param event The mouse event triggered by hovering over the level 2 image.
     */
    @FXML
    public void Change_desertImageEffect(MouseEvent event) {
        applyImageEffect(level2_image, 220, 500);
    }


    /**
     * Removes visual effects from the level 1 image when the mouse exits the image area.
     *
     * @param event The mouse event triggered by exiting the level 1 image area.
     */
    @FXML
    public void glacier_mouseExited(MouseEvent event) {
        removeImageEffect(level1_image, 200, 488);
    }

    /**
     * Removes visual effects from the level 2 image when the mouse exits the image area.
     *
     * @param event The mouse event triggered by exiting the level 2 image area.
     */
    @FXML
    public void desert_mouseExited(MouseEvent event) {
        removeImageEffect(level2_image, 200, 488);
    }

    /**
     * Switches to game level 1 when the corresponding button is clicked.
     *
     * @param actionEvent The action event triggered by clicking the level 1 button.
     */
    @FXML
    public void Switch_GameLevel1(ActionEvent actionEvent) {
        System.out.println("Switch to Game Level 1");
        dataManager.getGameState().setMap(1);
    }

    /**
     * Switches to game level 2 when the corresponding button is clicked.
     *
     * @param actionEvent The action event triggered by clicking the level 2 button.
     */
    @FXML
    public void Switch_GameLevel2(ActionEvent actionEvent) {
        System.out.println("Switch to Game Level 2");
        dataManager.getGameState().setMap(2);
    }

    /**
     * Applies visual effects (glow and shadow) to an image and adjusts its size.
     *
     * @param imageView The image view to apply the effects to.
     * @param height    The height to set for the image view.
     * @param width     The width to set for the image view.
     */
    private void applyImageEffect(ImageView imageView, double height, double width) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(15.0);
        shadowEffect.setOffsetY(15.0);
        imageView.setEffect(glowEffect);
        imageView.setEffect(shadowEffect);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
    }

    /**
     * Removes visual effects (glow and shadow) from an image and resets its size.
     *
     * @param imageView The image view to remove the effects from.
     * @param height    The height to reset for the image view.
     * @param width     The width to reset for the image view.
     */
    private void removeImageEffect(ImageView imageView, double height, double width) {
        Glow glowEffect = new Glow(0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        imageView.setEffect(glowEffect);
        imageView.setEffect(shadowEffect);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
    }


    /**
     * Initiates the start of a level 1 game within the Escape Beyond game framework.
     * This method is triggered by a mouse event, typically a button click, and
     * delegates the actual game start process to the main game instance.
     *
     * @param event The mouse event that triggered the start of the game.
     *              This parameter can be used to obtain information about the
     *              event, such as the source of the event or the specific mouse
     *              button that was clicked.
     * @throws IOException if an I/O error occurs while starting the game.
     *                    This exception is thrown when the game is unable to
     *                    load necessary resources or write to the file system.
     */
    @FXML
    public void start_level1Game(MouseEvent event) throws IOException {
        System.out.println("Welcome to Escape beyond! Start level1 game!");
        gameManager.startGame();
    }

    /**
     * Initiates the start of a level 2 game within the Escape Beyond game framework.
     * This method is triggered by a mouse event, typically a button click, and
     * delegates the actual game start process to the main game instance.
     *
     * @param event The mouse event that triggered the start of the game.
     *              This parameter can be used to obtain information about the
     *              event, such as the source of the event or the specific mouse
     *              button that was clicked.
     * @throws IOException if an I/O error occurs while starting the game.
     *                    This exception is thrown when the game is unable to
     *                    load necessary resources or write to the file system.
     */
    @FXML
    public void start_level2Game(MouseEvent event) throws IOException {
        System.out.println("Welcome to Escape beyond! Start level1 game!");
        gameManager.startGame();
    }
}
