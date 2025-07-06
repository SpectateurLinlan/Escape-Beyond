package com.platformer.escape_beyond.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for managing ranges of movable objects in the game.
 * <p>
 * This class provides an iterator for traversing a list of integer arrays that represent
 * the ranges of movable objects.
 */
public class IntArrayIterator implements Iterator<int[]> {

    private final ArrayList<int[]> data; // The list of integer arrays representing ranges.
    private int currentIndex; // The current index in the list.

    /**
     * Constructs an {@code IntArrayIterator} with the specified data.
     *
     * @param data The list of integer arrays to iterate over.
     */
    public IntArrayIterator(ArrayList<int[]> data) {
        this.data = data;
        this.currentIndex = 0;
    }

    /**
     * Checks if there are more elements in the iterator.
     *
     * @return {@code true} if there are more elements to iterate over, {@code false} otherwise.
     */
    @Override
    public boolean hasNext() {
        return currentIndex < data.size();
    }

    /**
     * Returns the next element in the iterator.
     * <p>
     * If there are no more elements, a {@link NoSuchElementException} is thrown.
     *
     * @return The next integer array in the list.
     * @throws NoSuchElementException If there are no more elements in the iterator.
     */
    @Override
    public int[] next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no more elements in the iterator.");
        }
        return data.get(currentIndex++);
    }
}
