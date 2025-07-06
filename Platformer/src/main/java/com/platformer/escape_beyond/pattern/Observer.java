package com.platformer.escape_beyond.pattern;

/**
 * An interface that represents the observer in the Observer Pattern.
 * <p>
 * The {@code Observer} interface defines the method that should be implemented
 * by classes that need to be notified of changes in the observed subject's state.
 * This interface is used to facilitate communication between the model and the view
 * in the Model-View-Controller (MVC) architecture.
 * </p>
 */
public interface Observer {
    /**
     * Updates the observer when the observed subject's state changes.
     * <p>
     * This method is called by the subject to notify the observer of state changes,
     * prompting the observer to synchronize or refresh its state.
     * </p>
     */
    void update();
}
