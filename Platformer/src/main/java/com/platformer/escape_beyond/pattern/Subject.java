package com.platformer.escape_beyond.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class representing the "subject" in the Observer Pattern.
 * <p>
 * It maintains a list of {@link Observer} objects that observe changes in the subject's state.
 * Subclasses of {@code Subject} can call the {@code notifyObservers()} method to
 * inform all attached observers of changes.
 * <p>
 * This class is part of the Observer Pattern, which facilitates communication
 * between objects in a loosely coupled manner.
 */
public abstract class Subject {
    /**
     * A list to store all observers attached to the subject.
     * <p>
     * Observers in this list will be notified whenever {@code notifyObservers()} is invoked.
     */
    protected List<Observer> observers = new ArrayList<>();

    /**
     * Attaches an observer to this subject.
     * <p>
     * The observer will receive notifications whenever the subject's state changes.
     *
     * @param observer The {@link Observer} instance to be attached.
     *                 It must implement the {@code Observer} interface.
     * @throws NullPointerException if the observer is {@code null}.
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifies all attached observers about a change in the subject's state.
     * <p>
     * This method iterates through the list of attached observers and calls their
     * {@link Observer#update()} method to inform them of the change.
     * Subclasses should invoke this method whenever the subject's state is updated.
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
