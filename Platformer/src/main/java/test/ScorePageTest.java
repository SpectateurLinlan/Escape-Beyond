package test;

import com.platformer.escape_beyond.manager.DataManager;
import com.platformer.escape_beyond.Main;
import com.platformer.escape_beyond.manager.SceneManager;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class ScorePageTest {

    @Test
    public void scorePageTest() throws IOException {
        System.out.println("ScorePageTest");

        new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            SceneManager sceneManager = SceneManager.getInstance();

            DataManager.getInstance().getGameState().collectedSupplies = 9;
            DataManager.getInstance().getGameState().totalSupplies = 9;
            DataManager.getInstance().getGameState().spentTime = 100;

            try {
                sceneManager.setRoot("score");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Main.main(new String[]{});
    }
}