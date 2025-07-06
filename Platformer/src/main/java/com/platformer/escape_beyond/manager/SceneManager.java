package com.platformer.escape_beyond.manager;

import com.platformer.escape_beyond.Main;
import com.platformer.escape_beyond.model.entity.LevelData;
import com.platformer.escape_beyond.model.game.GameState;
import com.platformer.escape_beyond.utils.InitContent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneManager {
    private static SceneManager instance;
    private static final int APP_WIDTH = 1280; // Width of the application window
    private static final int APP_HEIGHT = 720; // Height of the application window

    private final Pane appRoot = new Pane();
    private final Pane gameRoot = new Pane();
    private final Pane uiRoot = new Pane();
    private Scene currentScene;

    /**
     * Returns the singleton instance of {@code SceneManager}.
     *
     * @return The singleton instance of SceneManager.
     */
    public static synchronized SceneManager getInstance() {
        if (instance == null) {
            synchronized (SceneManager.class) {
                if (instance == null) {
                    instance = new SceneManager();
                }
            }
        }
        return instance;
    }

    /**
     * Sets up the primary stage with the initial scene.
     *
     * @param stage The primary stage.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public void setupPrimaryStage(Stage stage) throws IOException {
        currentScene = new Scene(loadFXML("start"));
        stage.setScene(currentScene);
        stage.setTitle("ESCAPE BEYOND!");

        stage.setResizable(false);
        stage.setWidth(APP_WIDTH);
        stage.setHeight(APP_HEIGHT);
        stage.show();
    }

    // Getter
    public Pane getAppRoot() {
        return appRoot;
    }
    public Pane getGameRoot() {
        return gameRoot;
    }
    public Pane getUiRoot() {
        return uiRoot;
    }

    public Scene getCurrentScene(){
        return currentScene;
    }

    /**
     * Sets the root of the current scene to a new FXML file.
     *
     * @param fxml the name of the FXML file to load
     * @throws IOException if the FXML file cannot be loaded
     */
    public void setRoot(String fxml) throws IOException {
        currentScene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads the specified FXML file and returns its root node.
     *
     * @param fxml the name of the FXML file to load
     * @return the root node of the FXML file
     * @throws IOException if the FXML file cannot be loaded
     */
    public static Parent loadFXML(String fxml) throws IOException {
        URL resource = Main.class.getResource("/com/platformer/escape_beyond/view/fxml/" + fxml + ".fxml");
        if (resource == null) {
            throw new IOException("Cannot find FXML resource: " + fxml);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        return fxmlLoader.load();
    }
}
