package com.platformer.escape_beyond.controller;

import com.platformer.escape_beyond.manager.SceneManager;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Controller class for the first subpage of the information section.
 * This handles user interactions specific to the first subpage.
 */
public class InformationSubpage1Controller {

    /**
     * Handles the event when the user clicks the "Return to Information" button.
     * Navigates the user back to the main information page.
     *
     * @param mouseEvent The mouse event triggered by clicking the "Return to Information" button.
     * @throws IOException If an error occurs while navigating to the main information page.
     */
    public void return_toInformation(MouseEvent mouseEvent) throws IOException {
        SceneManager.getInstance().setRoot("information");
    }
}
