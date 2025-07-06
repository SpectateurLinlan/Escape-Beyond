package com.platformer.escape_beyond.view;

import com.platformer.escape_beyond.manager.GameManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.manager.TimeManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;

import static com.platformer.escape_beyond.utils.Counter.startCountdown;

/**
 * Utility class to initialize and manage the in-game UI.
 * <p>
 * This class sets up the UI elements such as the timer label and the exit button,
 * arranges them in a container, and adds them to the root UI node.
 */
public class InitGameUi {
    private static final Label timeLabel = TimeManager.getInstance().getTimerLabel();

    /**
     * Initializes the game UI elements.
     * <p>
     * Modifies the {@code uiRoot} to include the timer label and an exit button, styled and positioned appropriately.
     * Starts the countdown timer to display the remaining game time.
     * <p>
     * No input parameters or return values as it modifies the UI directly.
     */
    public static void initGameUi() {
        VBox uiContainer = new VBox();
        uiContainer.setSpacing(10);
        uiContainer.setAlignment(Pos.CENTER); // Center the content vertically
        uiContainer.setLayoutX(10); // Positioning
        uiContainer.setLayoutY(10);
        uiContainer.setPrefWidth(1280);
        uiContainer.setPrefHeight(80);

        // Create and style the timer label
        timeLabel.setText("Time left: 5:00");
        timeLabel.setTextFill(Color.BLACK); // Set text color for visibility
        timeLabel.setStyle("-fx-font-size: 24px;");

        // Create and style the exit button
        Button exitButton = new Button("Exit Game");
        exitButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white; -fx-font-size: 16px;"); // Set button color
        exitButton.setCursor(javafx.scene.Cursor.HAND); // Set cursor to hand

        // Set callback for the exit button
        exitButton.setOnAction(event -> {
            System.out.println("Exiting game...");
            try {
                GameManager.getInstance().quitGame();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Add hover effects for the exit button
        exitButton.setOnMouseEntered(event -> {
            exitButton.setStyle("-fx-background-color: #40E0D0; -fx-text-fill: white; -fx-font-size: 16px;"); // Change color on hover
        });

        exitButton.setOnMouseExited(event -> {
            exitButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white; -fx-font-size: 16px;"); // Revert color
        });

        // Create an HBox to hold the timer label and exit button
        HBox hbox = new HBox();
        hbox.setSpacing(20); // Set spacing between elements
        hbox.setAlignment(Pos.CENTER); // Center the HBox content
        hbox.getChildren().addAll(timeLabel, exitButton); // Add the timer label and button to the HBox

        // Add the HBox to the UI container
        uiContainer.getChildren().add(hbox);

        // Add the UI container to the root UI node
        SceneManager.getInstance().getUiRoot().getChildren().add(uiContainer);

        // Start the countdown timer
        startCountdown(timeLabel);
    }
}
