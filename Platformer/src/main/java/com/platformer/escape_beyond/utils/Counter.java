package com.platformer.escape_beyond.utils;

import com.platformer.escape_beyond.manager.GameManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.manager.TimeManager;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

/**
 * Utility class for managing and displaying a countdown timer in the game.
 * <p>
 * This class provides a static method to start a countdown timer that updates
 * a label in real-time and triggers an action when the countdown ends.
 * </p>
 */
public class Counter {

    /**
     * Starts a countdown timer and updates the specified label with the remaining time.
     * <p>
     * The countdown begins at 5 minutes (300 seconds) and decrements every second.
     * The remaining time is displayed in the format "Time left: MM:SS". When the countdown
     * reaches zero, the label displays "Time's up!", the timer stops, and the
     * {@code onCountdownEnd} method is invoked.
     * </p>
     *
     * @param timerLabel The {@code Label} to display the countdown time.
     */
    public static void startCountdown(Label timerLabel) {
        // Countdown from 5 minutes (300 seconds)
        final int totalTime = 300; // 5 minutes in seconds
        final int[] countdownTime = {totalTime}; // Using an array to modify inside the timer

        // Create an AnimationTimer for the countdown
        TimeManager.getInstance().timerLabelTimer = new AnimationTimer() {
            private long lastUpdate = System.nanoTime(); // Track the last update time

            @Override
            public void handle(long now) {
                // Calculate the elapsed time in seconds
                if (now - lastUpdate >= 1_000_000_000) { // 1 second in nanoseconds
                    if (countdownTime[0] > 0) {
                        int minutes = countdownTime[0] / 60;
                        int seconds = countdownTime[0] % 60;
                        timerLabel.setText(String.format("Time left: %d:%02d", minutes, seconds));
                        countdownTime[0]--; // Decrement the remaining time
                    } else {
                        // Timer has finished
                        timerLabel.setText("Time's up!");
                        this.stop(); // Stop the timer
                        GameManager.getInstance().onCountdownEnd(totalTime - countdownTime[0]); // Pass the elapsed time
                    }
                    lastUpdate = now; // Update the last update time
                }
            }
        };

        TimeManager.getInstance().getTimerLabelTimer().start(); // Start the countdown timer
    }
}
