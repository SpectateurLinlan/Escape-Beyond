package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.model.game.Score;
import com.platformer.escape_beyond.manager.ScoreManager;
import com.platformer.escape_beyond.utils.ScoreCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controller class for managing the score display and logic.
 * Handles showing the current score, high score, and updating the high score when necessary.
 */
public class ScoreController {

    @FXML
    private Text currentScoreText; // Displays the current score.
    @FXML
    private Text highScoreText; // Displays the high score.
    @FXML
    private Button returnToMenuButton; // Button to navigate back to the home menu.

    private List<Score> loadedScores; // List of scores loaded from file.

    private static final int TOTAL_MAPS = 3; // Total number of maps (configurable for future).

    // Singleton instances
    SceneManager sceneManager = SceneManager.getInstance();
    DataManager dataManager = DataManager.getInstance();
    /**
     * Initializes the ScoreController when the score.file.fxml is loaded.
     * Sets up button styles, loads scores, and updates the UI accordingly.
     */
    public void initialize() {
        System.out.println("score.file.fxml initialized");

        configureButtonHoverEffects();

        int currentScore = calculateAndDisplayCurrentScore(); // Step 1: Calculate and display current score.
        int highScore = loadAndDisplayHighScore(); // Step 2: Load and display high score.

        if (currentScore > highScore) { // Step 3: Check and update high score if needed.
            updateHighScore(currentScore);
        }
    }

    /**
     * Calculate the current score and display it on the UI.
     *
     * @return The current score.
     */
    private int calculateAndDisplayCurrentScore() {
        int currentScore = ScoreCalculator.calculateScore(dataManager.getGameState());
        currentScoreText.setText(String.valueOf(currentScore));
        return currentScore;
    }

    /**
     * Load the high score for the current map and display it on the UI.
     *
     * @return The high score for the current map.
     */
    private int loadAndDisplayHighScore() {
        loadedScores = ScoreManager.deserializeScores(); // Load scores from file.
        ensureAllMapsExist(); // Ensure each map has a score entry.

        int mapIndex = dataManager.getGameState().map.index;
        int highScore = loadedScores.get(mapIndex - 1).getScore(); // Get high score for current map.
        highScoreText.setText(String.valueOf(highScore)); // Display high score.
        return highScore;
    }

    /**
     * Updates the high score for the current map if the current score is higher.
     *
     * @param currentScore The player's current score.
     */
    private void updateHighScore(int currentScore) {
        int mapIndex = dataManager.getGameState().map.index;

        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        loadedScores.set(mapIndex - 1, new Score(currentScore, mapIndex, dataManager.getGameState().map.map_name, formattedDate));
        ScoreManager.serializeScores(loadedScores); // Save updated scores to file.
    }

    /**
     * Ensures that all maps have a score entry in the loaded scores list.
     * If a map does not have an entry, it adds a default one.
     */
    private void ensureAllMapsExist() {
        while (loadedScores.size() < TOTAL_MAPS) { // Ensure list size matches the total maps.
            int missingIndex = loadedScores.size() + 1;
            loadedScores.add(new Score(0, missingIndex, "", "0000-00-00 00:00:00"));
        }
    }

    /**
     * Configures the hover effects for the "Return to Menu" button.
     */
    private void configureButtonHoverEffects() {
        returnToMenuButton.setOnMouseEntered(e -> returnToMenuButton.setStyle("-fx-background-color: #E0FFFF; -fx-text-fill: black;"));
        returnToMenuButton.setOnMouseExited(e -> returnToMenuButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white;"));

        returnToMenuButton.setCursor(javafx.scene.Cursor.HAND);
    }

    /**
     * Handles the action of returning to the home screen when the "Return to Menu" button is clicked.
     *
     * @param actionEvent The event triggered by clicking the button.
     * @throws IOException If an error occurs while switching screens.
     */
    @FXML
    public void Switch_toHome(ActionEvent actionEvent) throws IOException {
        sceneManager.setRoot("home");
    }

    /**
     * Switches the current view to the home screen of the game.
     * This method is triggered by a mouse event, typically a button click,
     * and updates the root node of the application to display the home screen.
     *
     * @param event The mouse event that triggered the switch to the home screen.
     *              This parameter can be used to obtain information about the
     *              event, such as the source of the event or the specific mouse
     *              button that was clicked.
     * @throws IOException if an I/O error occurs while setting the root.
     *                     This exception is thrown when the application is unable
     *                     to load the necessary resources for the home screen.
     */
    @FXML
    public void switch_toHome(MouseEvent event) throws IOException {
        sceneManager.setRoot("home");
    }
}
