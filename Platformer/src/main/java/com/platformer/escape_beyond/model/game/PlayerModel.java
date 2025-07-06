package com.platformer.escape_beyond.model.game;

import com.platformer.escape_beyond.pattern.Subject;
import javafx.geometry.Point2D;

/**
 * Represents the data model for the player in the game.
 * This class acts as the Subject in the Observer Pattern. It maintains the player's state,
 * including position, velocity, and jump status, and notifies all attached observers whenever
 * its state changes. Observers can dynamically register to monitor the player's state updates.
 */
public class PlayerModel extends Subject {
    private double x; // The X-coordinate of the player's position.
    private double y; // The Y-coordinate of the player's position.
    private boolean canJump = true; // Indicates whether the player can perform a jump.
    private Point2D playerVelocity = new Point2D(0, 0); // The player's current velocity as a 2D vector.

    /**
     * Gets the player's X-coordinate.
     *
     * @return The X-coordinate of the player's position.
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the player's X-coordinate.
     *
     * @param x The new X-coordinate of the player's position.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the player's Y-coordinate.
     *
     * @return The Y-coordinate of the player's position.
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the player's Y-coordinate.
     *
     * @param y The new Y-coordinate of the player's position.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Checks whether the player can jump.
     *
     * @return True if the player can jump, false otherwise.
     */
    public boolean isCanJump() {
        return canJump;
    }

    /**
     * Sets whether the player can jump.
     *
     * @param canJump True to allow the player to jump, false otherwise.
     */
    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    /**
     * Gets the player's current velocity as a 2D vector.
     *
     * @return The player's velocity.
     */
    public Point2D getPlayerVelocity() {
        return playerVelocity;
    }

    /**
     * Sets the player's current velocity.
     *
     * @param playerVelocity The new velocity of the player.
     */
    public void setPlayerVelocity(Point2D playerVelocity) {
        this.playerVelocity = playerVelocity;
    }
}
