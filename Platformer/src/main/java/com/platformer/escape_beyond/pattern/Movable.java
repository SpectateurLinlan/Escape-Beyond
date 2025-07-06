package com.platformer.escape_beyond.pattern;

/**
 * The {@code Movable} interface defines a contract for objects that can move
 * within the game environment.
 * <p>
 * Classes implementing this interface must provide their own implementation
 * of the {@link #step_move()} method to define specific movement behavior.
 * <p>
 * This interface supports the Strategy Design Pattern, enabling dynamic assignment
 * of movement behaviors to game objects.
 *
 * @version 1.0
 */
public interface Movable {

    /**
     * Executes the movement logic for an object.
     * <p>
     * Implementing classes should provide the specific movement behavior
     * (e.g., linear movement, no movement, or custom behavior).
     * This method is typically called during the game loop to update
     * the object's position.
     */
    void step_move();
}
