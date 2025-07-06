package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.manager.GameManager;
import com.platformer.escape_beyond.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * The controller class for the Home screen of the game.
 * It handles user interactions with buttons and other UI elements on the Home screen.
 */
public class HomeController {
    @FXML
    public ImageView Home_backgroundImage;
    @FXML
    public Button Home_Option_button;
    @FXML
    public Button Home_Information_button;
    @FXML
    public Button Home_Maps_button;
    @FXML
    public ImageView Home_closePage; // Image to exit the current page and return to the start screen.
    public Button Home_Start_button; // Button to start the game.

    SceneManager sceneManager = SceneManager.getInstance();
    /**
     * Handles the event when the user clicks on the close page image.
     * Navigates the user back to the start screen.
     *
     * @param actionEvent The mouse event triggered by clicking the close page image.
     * @throws IOException If an error occurs while switching the screen.
     */
    @FXML
    public void switchOnClicked_Exit(MouseEvent actionEvent) throws IOException {
        sceneManager.setRoot("start");
    }

    /**
     * This method is called when the user clicks on the maps button.
     * @param actionEvent The action event triggered by clicking the Maps button.
     * @throws IOException If an error occurs while switching the screen.
     */
    @FXML
    public void switchOnClicked_Maps(ActionEvent actionEvent) throws IOException {
        sceneManager.setRoot("maps");
    }

    /**
     * This method is called when the user clicks on the information button.
     * @param actionEvent The action event triggered by clicking the Maps button.
     * @throws IOException If an error occurs while switching the screen.
     */
    @FXML
    public void switchOnClicked_Information(ActionEvent actionEvent) throws IOException {
        sceneManager.setRoot("information");
    }

    /**
     * This method is called when the user clicks on the option button.
     * @param actionEvent The action event triggered by clicking the Maps button.
     * @throws IOException If an error occurs while switching the screen.
     */
    @FXML
    public void switchOnClicked_Option(ActionEvent actionEvent) throws IOException {
        sceneManager.setRoot("option");
    }

    /**
     * This method is called when the user clicks on the start button.
     * @param actionEvent The action event triggered by clicking the start button.
     * @throws IOException If an error occurs while switching the screen.
     */
    @FXML
    public void switchOnClicked_StartGame(ActionEvent actionEvent) throws IOException {
        System.out.println("Start game");
        GameManager.getInstance().startGame();
    }
}
