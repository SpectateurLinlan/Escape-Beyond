package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;


/**
 * Controller class for the Start screen.
 * Handles interactions with the start screen's UI elements and transitions to the home screen.
 */
public class StartController {
    public Button Start_button_next;
    public ImageView Title_image;
    public ImageView Background_image;
    public Pane Pane_Start;

    /**
     * Handles the action when the Start button is clicked.
     * Transitions the user to the home screen of the game.
     *
     * @param actionEvent The event triggered by clicking the Start button.
     * @throws IOException If an error occurs while switching screens.
     */
    public void switchOnClicked(ActionEvent actionEvent) throws IOException {
        SceneManager.getInstance().setRoot("home");
    }

}
