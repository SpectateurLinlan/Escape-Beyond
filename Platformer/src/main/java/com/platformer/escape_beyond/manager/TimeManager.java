package com.platformer.escape_beyond.manager;

import com.platformer.escape_beyond.controller.PlayerController;
import com.platformer.escape_beyond.model.entity.node.movable.MovableNode;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

/**
 * Manages game time-related operations, including animation timers for the game loop and countdown timers for the UI.
 * <p>
 * This class implements the Singleton design pattern to ensure a single instance of the time management system.
 * It handles player updates, movable entity updates, and provides utility methods to manage timers and labels.
 */
public class TimeManager {
    // This is the singleton-instance
    private static TimeManager instance;

    private AnimationTimer timer; // Timer responsible for the game loop
    public AnimationTimer timerLabelTimer; // Timer responsible for countdown or timer label updates

    // Label for the timer display
    private final Label timerLabel = new Label();

    // List of movable nodes in the game
    private final List<MovableNode> movableNodes = DataManager.getInstance().getMovableNodes();

    /**
     * Returns the singleton instance of the {@code TimeManager}.
     * <p>
     * Ensures that only one instance of {@code TimeManager} exists throughout the application.
     * If no instance exists, it creates a new one.
     *
     * @return The singleton instance of {@code TimeManager}.
     */
    public static TimeManager getInstance() {
        if (instance == null) {
            instance = new TimeManager();
        }
        return instance;
    }

    /**
     * Initializes the game loop timer.
     * <p>
     * The timer periodically calls the update logic for the player and all movable nodes in the game.
     * If an {@code IOException} occurs during updates, a {@code RuntimeException} is thrown.
     */
    public void init() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                PlayerController playerController = DataManager.getInstance().getPlayerController();
                if (playerController == null) {
                    System.err.println("PlayerController is null in AnimationTimer!");
                    stop();
                    return;
                }try {
                    DataManager.getInstance().getPlayerController().update();
                    for (MovableNode movableNode : movableNodes) {
                        movableNode.step_move();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    /**
     * Retrieves the game loop timer.
     *
     * @return The {@code AnimationTimer} responsible for managing the game loop.
     */
    public AnimationTimer getTimer() {
        return timer;
    }

    /**
     * Sets a new game loop timer.
     *
     * @param timer The new {@code AnimationTimer} to be set.
     */
    public void setTimer(AnimationTimer timer) {
        this.timer = timer;
    }

    /**
     * Retrieves the timer responsible for updating the countdown or timer label.
     *
     * @return The {@code AnimationTimer} managing the timer label.
     */
    public AnimationTimer getTimerLabelTimer() {
        return timerLabelTimer;
    }

    /**
     * Sets the timer responsible for updating the countdown or timer label.
     * <p>
     * If a previous timer is active, it is stopped before the new timer is set.
     *
     * @param timerLabelTimer The new {@code AnimationTimer} to be set.
     */
    public void setTimerLabelTimer(AnimationTimer timerLabelTimer) {
        if (this.timerLabelTimer != null) {
            this.timerLabelTimer.stop(); // Stop the current timer
        }
        this.timerLabelTimer = timerLabelTimer;
    }

    /**
     * Retrieves the label used to display the countdown or timer.
     *
     * @return The {@code Label} used to display the countdown or timer.
     */
    public Label getTimerLabel() {
        return timerLabel;
    }

    /**
     * Stops the timer responsible for updating the countdown or timer label.
     * <p>
     * This method stops the current {@code AnimationTimer} and clears the reference to it.
     */
    public void stopLabelTimer() {
        if (timerLabelTimer != null) {
            timerLabelTimer.stop(); // Stop the timer
            timerLabelTimer = null; // Clear the reference
        }
    }
}
