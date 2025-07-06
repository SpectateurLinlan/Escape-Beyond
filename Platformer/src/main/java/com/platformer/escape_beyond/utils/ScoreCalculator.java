package com.platformer.escape_beyond.utils;

import com.platformer.escape_beyond.model.game.GameState;

/**
 * Utility class for calculating the game score based on the player's performance.
 * <p>
 * The score is derived from the remaining time and the proportion of supplies collected.
 */
public class ScoreCalculator {

    /**
     * Calculates the player's score based on the game state.
     * <p>
     * The score formula is:
     * <pre>
     * Score = (Remaining Time) + (1000 * Fraction of Supplies Collected)
     * </pre>
     *
     * @param gameState The current game state containing time spent and supply details.
     * @return The calculated score as an integer.
     * @throws IllegalArgumentException if {@code gameState.totalSupplies <= 0}.
     */
    public static int calculateScore(GameState gameState) {
        if (gameState.totalSupplies <= 0) {
            throw new IllegalArgumentException("Total supplies must be greater than 0 to calculate the score.");
        }

        double remainingTime = GameState.TOTAL_TIME - gameState.spentTime;
        double supplyFraction = gameState.collectedSupplies / (double) gameState.totalSupplies;
        return (int) (remainingTime + 1000 * supplyFraction);
    }
}
