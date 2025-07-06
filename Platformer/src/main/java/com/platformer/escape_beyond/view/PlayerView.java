package com.platformer.escape_beyond.view;

import com.platformer.escape_beyond.model.game.PlayerModel;
import com.platformer.escape_beyond.pattern.Observer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

/**
 * The {@code PlayerView} class represents the visual representation of the player character in the game.
 * <p>
 * It observes the {@code PlayerModel} to dynamically update the player's position in the view whenever the model changes.
 * This class also handles the initialization and mirroring of the player character.
 * <p>
 * Implements the Observer Pattern for syncing with the {@code PlayerModel}.
 */
public class PlayerView implements Observer {
    private final ImageView playerImageView; // Displays the player's image.
    private final Pane paneRoot; // The root pane where the player is rendered.
    private final PlayerModel playerModel;
    private static final double SCALED_WIDTH = 25; // Scaled width of the player character.
    private static final double SCALED_HEIGHT = 50; // Scaled height of the player character.

    /**
     * Constructs a {@code PlayerView} object that observes the {@code PlayerModel} and renders the player in the given pane.
     *
     * @param root        The pane in which the player view will be rendered.
     * @param playerModel The player's model containing the player's state and coordinates.
     * @param index       The index of the character image to load.
     */
    public PlayerView(Pane root, PlayerModel playerModel, int index) {
        this.playerModel = playerModel;
        this.playerModel.attach(this); // Attach the PlayerView as an observer to the PlayerModel.
        this.paneRoot = root;
        this.playerImageView = initPlayer(0, 600, index); // Initialize the player view at position (0, 600).
    }

    /**
     * Updates the player's view to match the current state of the {@code PlayerModel}.
     * <p>
     * This method is triggered whenever the model notifies its observers of a change.
     */
    public void update() {
        drawCharacter((int) playerModel.getX(), (int) playerModel.getY());
    }

    /**
     * Draws the player character at the specified coordinates.
     *
     * @param x The x-coordinate where the player will be rendered.
     * @param y The y-coordinate where the player will be rendered.
     */
    private void drawCharacter(int x, int y) {
        playerImageView.setTranslateX(x);
        playerImageView.setTranslateY(y);
    }

    /**
     * Returns the graphical representation of the player as a {@code Node}.
     * <p>
     * This method allows the player node to be added to a scene graph.
     *
     * @return The {@code Node} representing the player.
     */
    public Node getPlayerNode() {
        return playerImageView;
    }

    /**
     * Initializes the player's view by loading the corresponding character image and setting its properties.
     *
     * @param x     The initial x-coordinate of the player.
     * @param y     The initial y-coordinate of the player.
     * @param index The index of the character image to load.
     * @return The initialized {@code ImageView} representing the player.
     */
    public ImageView initPlayer(int x, int y, int index) {
        // Load the character image based on the index.
        String url = "/images/7_Option/character/Character" + index + ".png";
        Image characterImage = new Image(Objects.requireNonNull(
                getClass().getResourceAsStream(url))
        );

        ImageView imageView = new ImageView(characterImage);
        imageView.setFitWidth(SCALED_WIDTH);
        imageView.setFitHeight(SCALED_HEIGHT);
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
        paneRoot.getChildren().add(imageView); // Add the player image view to the root pane.
        return imageView;
    }

    /**
     * Mirrors the player's image horizontally.
     * <p>
     * If the player's image is already mirrored, this method resets it to its original orientation.
     */
    public void mirror() {
        if (playerImageView.getScaleX() == -1) {
            playerImageView.setScaleX(1); // Reset to original orientation.
        } else {
            playerImageView.setScaleX(-1); // Mirror horizontally.
        }
    }
}
