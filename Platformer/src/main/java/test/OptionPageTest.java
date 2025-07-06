package test;

import com.platformer.escape_beyond.Main;
import com.platformer.escape_beyond.manager.SceneManager;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class OptionPageTest {

    @Test
    public void optionPageTest() throws IOException {
        System.out.println("ScorePageTest");

        new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            SceneManager sceneManager = SceneManager.getInstance();

            try {
                sceneManager.setRoot("option");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Main.main(new String[]{});
    }
}