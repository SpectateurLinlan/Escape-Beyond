package com.platformer.escape_beyond.model.entity.block;

import javafx.scene.image.Image;

/**
 * Represents a generic entity in the game world.
 * This abstract class serves as the base for all game entities, defining common properties
 * such as position, size, and visual representation.
 */
public abstract class Entity {
    public int x; // The x-coordinate of the entity's position in the game world.
    public int y; // The y-coordinate of the entity's position in the game world.
    public int w; // The width of the entity.
    public int h; // The height of the entity.
    public Image image; // The image representing the entity visually.

    /**
     * Constructor for abstract class Entity.
     *
     * @param x     The x-coordinate of the entity's position in the game world.
     * @param y     The y-coordinate of the entity's position in the game world.
     * @param w     The width of the entity, defining its size in the horizontal direction.
     * @param h     The height of the entity, defining its size in the vertical direction.
     * @param image The image used to visually represent the entity in the game.
     */
    public Entity(int x, int y, int w, int h, Image image) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.image = image;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    public Image getImage() {
        return image;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int w) {
        this.w = w;
    }

    public void setHeight(int h) {
        this.h = h;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
