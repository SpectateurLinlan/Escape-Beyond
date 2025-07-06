package test;

import com.platformer.escape_beyond.Main;
import com.platformer.escape_beyond.manager.SceneManager;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class MapPageTest {

    @Test
    public void mapPageTest() throws IOException {
        System.out.println("ScorePageTest");

        new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                SceneManager.getInstance().setRoot("maps");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Main.main(new String[]{});
    }
}