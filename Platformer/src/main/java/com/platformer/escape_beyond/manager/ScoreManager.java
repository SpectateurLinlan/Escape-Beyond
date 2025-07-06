package com.platformer.escape_beyond.manager;

import com.platformer.escape_beyond.model.game.Score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for managing the serialization and deserialization of game scores.
 * <p>
 * The {@code ScoreManager} class provides methods to save scores to a file and read scores
 * from a file, enabling persistent storage and retrieval of player scores.
 * </p>
 */
public class ScoreManager {
    private static final String SCORES_FILE = "/file/scores.dat";

    /**
     * Obtain the path to the resource file
     * @param resourceName 资源名称
     * @return InputStream
     */
    private static InputStream getResourceAsStream(String resourceName) {
        return ScoreManager.class.getResourceAsStream(resourceName);
    }

    /**
     * Make sure the file exists, and create it if it does not
     */
    private static void ensureFileExists() {
        File file = new File(getFilePath());
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs(); // 创建目录
                file.createNewFile();
                serializeScores(new ArrayList<>()); // 初始化空分数
            } catch (IOException e) {
                System.err.println("Failed to create scores file.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Get the actual file path
     */
    private static String getFilePath() {
        return new File("src/main/resources" + SCORES_FILE).getPath();
    }

    /**
     * Serializes a list of scores to a specified file.
     * <p>
     * This method saves the provided list of {@code Score} objects to the specified file
     * using Java's Object Serialization mechanism. If the file does not exist, it will be created.
     * </p>
     *
     * @param scores   The list of {@code Score} objects to be serialized.
     */
    public static void serializeScores(List<Score> scores) {
        ensureFileExists();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFilePath()))) {
            oos.writeObject(scores);
            System.out.println("Scores serialized successfully");
        } catch (IOException e) {
            System.err.println("Error serializing scores: " + e.getMessage());
        }
    }

    /**
     * Deserializes a list of scores from a specified file.
     * <p>
     * This method reads a list of {@code Score} objects from the specified file. If the file
     * cannot be read or does not exist, an error message is logged, and {@code null} or an empty list
     * is returned.
     * </p>
     *
     * @return A {@code List<Score>} containing the deserialized scores, or {@code null} if an error occurs.
     */
    @SuppressWarnings("unchecked")
    public static List<Score> deserializeScores() {
        ensureFileExists();
        List<Score> scores = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFilePath()))) {
            scores = (List<Score>) ois.readObject();
            System.out.println("Scores deserialized successfully");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading scores file: " + e.getMessage());
        }
        return scores;
    }
}