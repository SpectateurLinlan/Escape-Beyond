package com.platformer.escape_beyond.manager;

import com.platformer.escape_beyond.model.game.GameState;
import com.platformer.escape_beyond.utils.InitContent;
import com.platformer.escape_beyond.model.entity.LevelData;

import java.io.IOException;

/**
 * Manages the flow of the game, including start, pause, resume, win, and game over states.
 * <p>
 * This class centralizes the control of the game's main flow, ensuring that different
 * game states are handled consistently and efficiently.
 * </p>
 */
public class GameManager {

    private static GameManager instance;

    private final DataManager dataManager;
    private final SceneManager sceneManager;
    private final TimeManager timeManager;
    private final MusicManager musicManager;

    private GameManager() {
        this.dataManager = DataManager.getInstance();
        this.sceneManager = SceneManager.getInstance();
        this.timeManager = TimeManager.getInstance();
        this.musicManager = MusicManager.getInstance();
    }

    /**
     * Returns the singleton instance of {@code GameFlowManager}.
     *
     * @return The singleton instance of GameFlowManager.
     */
    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    /**
     * Callback function executed when the countdown ends.
     * Switches to the "Game Over" scene.
     *
     * @param elapsedTime the elapsed time since the start of the game
     */
    public void onCountdownEnd(int elapsedTime) {
        System.out.println("Countdown finished!");
        try {
            sceneManager.setRoot("game_over");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Game Over scene", e);
        }
    }

    /**
     * Starts the game by initializing game content and setting up the game scene.
     *
     * @throws IOException if there is an error during initialization.
     */
    public void startGame() throws IOException {
        clearGameState();
        dataManager.getGameState().reset();
        sceneManager.getCurrentScene().setRoot(sceneManager.getAppRoot());

        // Initialize game content dynamically
        LevelData levelData = LevelData.createLevelData();
        InitContent initContent = new InitContent(levelData);
        initContent.initContent();

        // Make sure the PlayerController is initialized before the Timer starts
        if (DataManager.getInstance().getPlayerController() == null) {
            throw new IllegalStateException("PlayerController is not initialized!");
        }

        // Start background music and timer
        musicManager.playMusic(dataManager.getGameState().map.index);
        timeManager.getTimer().start();
    }

    /**
     * Ends the game with a "Game Over" state, resetting the game state and transitioning to the "Game Over" screen.
     *
     * @throws IOException if there is an error during the transition.
     */
    public void gameOver() throws IOException {
        dataManager.getGameState().reset();
        timeManager.getTimer().stop();
        clearGameState();
        sceneManager.setRoot("game_over");
    }

    /**
     * Handles the "Game Win" scenario by calculating the remaining time and transitioning to the score screen.
     *
     * @throws IOException if there is an error during the transition.
     */
    public void gameWin() throws IOException {
        String timeFormatted = timeManager.getTimerLabel().getText().split(" ")[2];
        String timePattern = "(\\d+):(\\d+)";
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(timePattern).matcher(timeFormatted);

        int totalSeconds = 0;
        if (matcher.find()) {
            int minutes = Integer.parseInt(matcher.group(1));
            int seconds = Integer.parseInt(matcher.group(2));
            totalSeconds = minutes * 60 + seconds;
        } else {
            throw new RuntimeException("Invalid time format: " + timeFormatted);
        }

        int spentTime = GameState.TOTAL_TIME - totalSeconds;
        dataManager.getGameState().spentTime = spentTime;
        timeManager.getTimer().stop();
        clearGameState();
        sceneManager.setRoot("score");
    }

    /**
     * Quits the game by returning to the home screen and clearing the current game state.
     *
     * @throws IOException if there is an error during the transition.
     */
    public void quitGame() throws IOException {
        clearGameState();
        dataManager.getGameState().clear();
        timeManager.getTimer().stop();
        sceneManager.setRoot("home");
    }

    /**
     * Pauses the game by stopping the timer and freezing updates.
     */
    public void pauseGame() {
        timeManager.getTimer().stop();
        musicManager.stopMusic();
    }

    /**
     * Resumes the game by restarting the timer and resuming updates.
     */
    public void resumeGame() {
        timeManager.getTimer().start();
        musicManager.playMusic(dataManager.getGameState().map.index);
    }

    /**
     * Clears the current game state, including resetting timers, clearing UI and game roots, and stopping music.
     */
    private void clearGameState() {
        musicManager.stopMusic();
        dataManager.clearGameState();
        timeManager.stopLabelTimer();
        sceneManager.getGameRoot().getChildren().clear();
        sceneManager.getAppRoot().getChildren().clear();
        sceneManager.getUiRoot().getChildren().clear();
    }

}
