package net.radley;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

public class SettingsController implements Initializable {
    
    @FXML private Slider volume;
    @FXML private ChoiceBox<String> pickTheme;

    private SwitchScene switchScene = new SwitchScene();
    private String[] themes = {"dark", "light"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pickTheme.getItems().addAll(themes);
        pickTheme.setOnAction(this::switchTheme);

        volume.setValue(Music.mediaPlayer.getVolume());
        volume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Music.mediaPlayer.setVolume(volume.getValue());
            }
        });
    }

    public void switchTheme(ActionEvent event) {
        Calculate.themeStatus = pickTheme.getValue() + ".css";
        try {
            switchScene.toSettings(event);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void toMenu(ActionEvent event) throws IOException {
        switchScene.toMenu(event);
    }

    public void hover() {
        try {
            SetupStage.music.fxPlay();
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
    }
}
