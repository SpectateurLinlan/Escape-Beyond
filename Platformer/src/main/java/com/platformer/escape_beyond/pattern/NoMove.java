package com.platformer.escape_beyond.pattern;

/**
 * Represents a movement strategy where no movement occurs.
 * <p>
 * This class implements the {@link Movable} interface but overrides the
 * {@code step_move()} method to perform no action, creating a
 * "no movement" behavior for objects that use this strategy.
 * <p>
 * This is a common use of the Strategy Pattern, where different movement
 * strategies can be assigned to entities dynamically.
 */
public class NoMove implements Movable {

    /**
     * Overrides the {@code step_move()} method to perform no action.
     * <p>
     * This method is intentionally left empty to represent an entity that
     * does not move.
     */
    @Override
    public void step_move() {
        // No movement behavior
    }
}
