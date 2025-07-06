package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The controller class for the Information screen of the platformer game.
 * It handles user interactions with buttons and other UI elements to display various informational subpages.
 */
public class InformationController {

    @FXML
    public ImageView Information_closePage; // The close button to return to the Home screen.
    @FXML
    public Pane ContentArea; // The container pane to display different subpages dynamically.

    /**
     * Switches the user to the Home screen.
     *
     * @param mouseEvent The mouse event triggered by clicking the close button.
     * @throws IOException If an error occurs while switching the screen.
     */
    @FXML
    public void Switch_toHome(MouseEvent mouseEvent) throws IOException {
        SceneManager.getInstance().setRoot("home");
    }

    /**
     * Switches the content area to display the introduction subpage.
     *
     * @param actionEvent The mouse event triggered by clicking the introduction button.
     * @throws IOException If an error occurs while loading the introduction subpage.
     */
    @FXML
    public void switch_intro(MouseEvent actionEvent) throws IOException {
        ContentArea.getChildren().clear();
        ContentArea.getChildren().add(SceneManager.loadFXML("information_subpage1"));
    }

    /**
     * Switches the content area to display the Level 1 information subpage.
     *
     * @param actionEvent The mouse event triggered by clicking the Level 1 button.
     * @throws IOException If an error occurs while loading the Level 1 subpage.
     */
    @FXML
    public void switch_level1(MouseEvent actionEvent) throws IOException {
        ContentArea.getChildren().clear();
        ContentArea.getChildren().add(SceneManager.loadFXML("information_subpage2"));
    }

    /**
     * Switches the content area to display the Level 2 information subpage.
     *
     * @param actionEvent The mouse event triggered by clicking the Level 2 button.
     * @throws IOException If an error occurs while loading the Level 2 subpage.
     */
    @FXML
    public void switch_level2(MouseEvent actionEvent) throws IOException {
        ContentArea.getChildren().clear();
        ContentArea.getChildren().add(SceneManager.loadFXML("information_subpage3"));
    }
}
