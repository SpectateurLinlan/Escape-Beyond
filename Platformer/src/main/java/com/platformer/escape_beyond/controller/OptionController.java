package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.io.IOException;

/**
 * Controller class for the Options page in the game.
 * This allows the player to select a character, change the background color,
 * and return to the home screen.
 */
public class OptionController {

    @FXML
    public ImageView Option_closePage;

    @FXML
    public ImageView image_character4;
    @FXML
    public ImageView image_character3;
    @FXML
    public ImageView image_character2;
    @FXML
    public ImageView image_character1;
    @FXML
    public Button character4_button;
    @FXML
    public Button character3_button;
    @FXML
    public Button character2_button;
    @FXML
    public Button character1_button;

    @FXML
    public ColorPicker Option_colorPicker; // Color picker to change the background color.
    @FXML
    public AnchorPane Option_pane; // AnchorPane to hold the background.

    /**
     * Handles the action when the user clicks on the close button.
     * Navigates back to the Home screen.
     *
     * @param actionEvent The mouse event triggered by clicking the close button.
     * @throws IOException If an error occurs while switching the screen.
     */
    @FXML
    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        SceneManager.getInstance().setRoot("home");
    }

    /**
     * Selects the first character as the player's avatar.
     *
     * @param actionEvent The action event triggered by clicking the character 1 button.
     */
    @FXML
    public void Switch_to_player1(ActionEvent actionEvent) {
        Switch_player(1);
    }

    /**
     * Selects the second character as the player's avatar.
     *
     * @param actionEvent The action event triggered by clicking the character 2 button.
     */
    @FXML
    public void Switch_to_player2(ActionEvent actionEvent) {
        Switch_player(2);
    }

    /**
     * Selects the third character as the player's avatar.
     *
     * @param actionEvent The action event triggered by clicking the character 3 button.
     */
    @FXML
    public void Switch_to_player3(ActionEvent actionEvent) {
        Switch_player(3);
    }

    /**
     * Selects the fourth character as the player's avatar.
     *
     * @param actionEvent The action event triggered by clicking the character 4 button.
     */
    @FXML
    public void Switch_to_player4(ActionEvent actionEvent) {
        Switch_player(4);
    }

    /**
     * Utility function to switch the selected character.
     *
     * @param index The index of the character to switch to.
     */
    @FXML
    private void Switch_player(int index) {
        System.out.println("Switch to player " + index);
        DataManager.getInstance().getGameState().setCharacter(index);
    }

    /**
     * Enlarges the character 1 image and adds a shadow effect when the mouse enters the image area.
     *
     * @param event The mouse event triggered by hovering over the character 1 image.
     */
    @FXML
    public void MouseEntered_character1(MouseEvent event) {
        applyMouseEnterEffect(image_character1, 220.0, 350.0);
    }

    /**
     * Enlarges the character 2 image and adds a shadow effect when the mouse enters the image area.
     *
     * @param event The mouse event triggered by hovering over the character 2 image.
     */
    @FXML
    public void MouseEntered_character2(MouseEvent event) {
        applyMouseEnterEffect(image_character2, 220.0, 350.0);
    }

    /**
     * Enlarges the character 3 image and adds a shadow effect when the mouse enters the image area.
     *
     * @param event The mouse event triggered by hovering over the character 3 image.
     */
    @FXML
    public void MouseEntered_character3(MouseEvent event) {
        applyMouseEnterEffect(image_character3, 220.0, 350.0);
    }

    /**
     * Enlarges the character 4 image and adds a shadow effect when the mouse enters the image area.
     *
     * @param event The mouse event triggered by hovering over the character 4 image.
     */
    @FXML
    public void MouseEntered_character4(MouseEvent event) {
        applyMouseEnterEffect(image_character4, 220.0, 350.0);
    }

    /**
     * Restores the original size and removes the shadow effect for character 1 image
     * when the mouse exits the image area.
     *
     * @param event The mouse event triggered by leaving the character 1 image area.
     */
    @FXML
    public void MouseExited_character1(MouseEvent event) {
        applyMouseExitEffect(image_character1, 201.0, 325.0);
    }

    /**
     * Restores the original size and removes the shadow effect for character 2 image
     * when the mouse exits the image area.
     *
     * @param event The mouse event triggered by leaving the character 2 image area.
     */
    @FXML
    public void MouseExited_character2(MouseEvent event) {
        applyMouseExitEffect(image_character2, 174.0, 325.0);
    }

    /**
     * Restores the original size and removes the shadow effect for character 3 image
     * when the mouse exits the image area.
     *
     * @param event The mouse event triggered by leaving the character 3 image area.
     */
    @FXML
    public void MouseExited_character3(MouseEvent event) {
        applyMouseExitEffect(image_character3, 216.0, 324.0);
    }

    /**
     * Restores the original size and removes the shadow effect for character 4 image
     * when the mouse exits the image area.
     *
     * @param event The mouse event triggered by leaving the character 4 image area.
     */
    @FXML
    public void MouseExited_character4(MouseEvent event) {
        applyMouseExitEffect(image_character4, 202.0, 316.0);
    }

    /**
     * Changes the background color of the options page based on the color selected in the color picker.
     *
     * @param actionEvent The action event triggered by selecting a color in the color picker.
     */
    public void Change_backgroundColor(ActionEvent actionEvent) {
        Color Option_backgroundColor = Option_colorPicker.getValue();
        Option_pane.setBackground(new Background(new BackgroundFill(Option_backgroundColor, null, null)));
    }

    /**
     * Applies an enlargement and shadow effect to a character image.
     *
     * @param imageView The image view to apply the effect to.
     * @param width     The new width for the image view.
     * @param height    The new height for the image view.
     */
    private void applyMouseEnterEffect(ImageView imageView, double width, double height) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(15);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        imageView.setEffect(dropShadow);
    }

    /**
     * Restores the original size and removes the shadow effect from a character image.
     *
     * @param imageView The image view to restore.
     * @param width     The original width for the image view.
     * @param height    The original height for the image view.
     */
    private void applyMouseExitEffect(ImageView imageView, double width, double height) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(0);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(0);
        imageView.setEffect(dropShadow);
    }
}
