package com.platformer.escape_beyond;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.manager.GameManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.manager.TimeManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The {@code Main} class serves as the entry point and lifecycle manager for this platformer game.
 * <p>
 * This class initializes core game components such as {@link DataManager}, {@link TimeManager}, and {@link SceneManager}.
 * It sets up the primary stage, loads the initial game scene, and launches the game application.
 * </p>
 * <p>
 * The class extends {@link javafx.application.Application} to leverage the JavaFX framework for
 * managing the game's graphical user interface (GUI) and scene transitions.
 * </p>
 */
public class Main extends Application {

    /**
     * Initializes the game's core managers and prepares the game environment before the GUI starts.
     * <p>
     * This method is called once during the application's initialization phase, before the {@link #start(Stage)} method.
     * It initializes the {@link DataManager} and {@link TimeManager} to ensure that all game data
     * and timers are properly configured.
     * </p>
     *
     * @throws Exception If there is an error during initialization.
     */
    @Override
    public void init() throws Exception {
        super.init();

        // Explicitly initialize singletons
        SceneManager.getInstance();      // Prepare scene management
        DataManager.getInstance().init(); // Initialize game data and state
        TimeManager.getInstance().init(); // Initialize timers for game updates

    }

    /**
     * Sets up and starts the primary stage for the game.
     * <p>
     * This method is called once the JavaFX runtime is ready. It uses the {@link SceneManager}
     * to configure the primary stage, set the initial scene, and display the game window.
     * </p>
     *
     * @param primaryStage The primary stage of the application, provided by the JavaFX runtime.
     * @throws Exception If there is any error during the setup or scene initialization.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize the main game window via SceneManager
        SceneManager.getInstance().setupPrimaryStage(primaryStage);
    }

    /**
     * The main entry point of the game application.
     * <p>
     * This method launches the JavaFX application by calling the {@link javafx.application.Application#launch(String...)} method.
     * It initializes the JavaFX runtime and begins the application's lifecycle.
     * </p>
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
