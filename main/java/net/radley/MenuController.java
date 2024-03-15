package net.radley;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    SwitchScene switchScene = new SwitchScene();

    @FXML private Button easy, normal, hard;
    @FXML private Button settings;

    public void settingsRequest(ActionEvent event) throws IOException {
        switchScene.toSettings(event);
    }

    public void closeRequest(ActionEvent event) {
        switchScene.closeRequest(event);
    }

    public void startGame(ActionEvent event) {
        try {
            switchScene.toGame(event, easy, normal, hard);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
