package test;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.Main;
import com.platformer.escape_beyond.manager.GameManager;
import com.platformer.escape_beyond.manager.SceneManager;
import com.platformer.escape_beyond.model.entity.Character;
import com.platformer.escape_beyond.model.entity.Map;
import javafx.application.Platform;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Level1Test {

    @Test
    public void level1Test() throws IOException {
        System.out.println("ScorePageTest");

        new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            GameManager gameManager = GameManager.getInstance();
            SceneManager sceneManager = SceneManager.getInstance();
            DataManager.getInstance().getGameState().character = new Character();
            DataManager.getInstance().getGameState().map = new Map(1);

            Platform.runLater(() -> {
                try {
                    gameManager.startGame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            try {
                sceneManager.setRoot("score");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Main.main(new String[]{});
    }
}