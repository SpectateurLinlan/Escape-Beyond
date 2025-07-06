package com.platformer.escape_beyond.manager;

import com.platformer.escape_beyond.Main;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.Objects;

/**
 * Manages the background music for the game.
 */
public class MusicManager {

    private static final MusicManager instance = new MusicManager(); // Singleton instance
    private MediaPlayer mediaPlayer;

    // Default volume for the media player
    private static final float MEDIAPLAYER_VOLUME = 0.2f;

    public static MusicManager getInstance() {
        return instance;
    }

    /**
     * Plays the background music based on the current map index.
     *
     * @param mapIndex the index of the current game map (1 = Glacier, 2 = Desert)
     */
    public void playMusic(int mapIndex) {
        Media audioMedia = switch (mapIndex) {
            case 1 -> new Media(Objects.requireNonNull(Main.class.getResource("/sounds/glacier_bgm.mp3")).toExternalForm());
            case 2 -> new Media(Objects.requireNonNull(Main.class.getResource("/sounds/desert_bgm.mp3")).toExternalForm());
            default -> throw new RuntimeException("Invalid map index: " + mapIndex);
        };

        if (mediaPlayer != null) {
            stopMusic(); // Stop any previous music before playing new one
        }

        mediaPlayer = new MediaPlayer(audioMedia);
        mediaPlayer.setVolume(MEDIAPLAYER_VOLUME);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    /**
     * Stops the current background music if it's playing.
     */
    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer = null;
        }
    }
}
