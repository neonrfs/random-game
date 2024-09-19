package net.radley;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GameController implements Initializable {

    SwitchScene switchScene = new SwitchScene();
    @FXML Button submitButton;
    @FXML Label titleLabel;
    @FXML Label displayLabel;
    @FXML Label lowestScoreLabel;
    @FXML TextField textField;
    @FXML Label guessesLabel;
    @FXML AnchorPane anchorPane;

    Calculate calculate;
    
    public void getNumber() {
        try {
            if (textField.getText().contains("/")) {
                switch (textField.getText().toLowerCase()) {
                    case "/help", "/h", "/":
                        displayLabel.setText("See terminal for more info.");
                        System.out.println("Slash commands can be typed for info about the app. The following commands can be used.");
                        System.out.println("/appbuild\n/sdkinfo\n/credits\n/com.x\n/com.roblox");
                        break;
                    case "/appbuild", "/app":
                        displayLabel.setText("App version: " + Calculate.appbuild);
                        break;
                    case "/sdkinfo", "/sdk":
                        displayLabel.setText("Uses OpenJDK 21.0.2 and JFX SDK 21.0.2");
                        break;
                    case "/credits", "/c":
                        displayLabel.setText("Runs on JFX Framework, created in VSCode and SceneBuilder");
                        break;
                    case "/retry", "/r":
                        calculate.reset();
                        
                        displayLabel.setText("Enter a number between 1 and " + Calculate.difficulty + ".");
                        textField.setPromptText("1 and " + Calculate.difficulty);
                        guessesLabel.setText("Guesses: " + Calculate.guesses);
                        lowestScoreLabel.setText("Lowest Score: 0");
                        break;
                    case "/com.x":
                        displayLabel.setText("Sure, it\'s @neon_roomforsq");
                        break;
                    case "/com.roblox":
                        displayLabel.setText("Sure, it\'s @room_4squares");
                        break;
                    case "/com.ig":
                        displayLabel.setText("Sure, it\'s... wait what?");
                        break;
                    default:
                        displayLabel.setText("Something occured, I can\'t figure it out yet.");
                        break;
                }
            } else if (textField.getText().equals("")) {
                if (displayLabel.getText().equals("No marks for writing nothin\', mate!")) {
                    displayLabel.setText("Don't be lazy mate!");
                } else {
                    displayLabel.setText("No marks for writing nothin\', mate!");
                }
            } else {
                displayLabel.setText(calculate.matchNumber(Integer.parseInt(textField.getText())));
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            displayLabel.setText("Not a number, try again!");
        } catch (Exception e) {
            System.out.println(e);
            displayLabel.setText("Something went wrong, try again!");
        } finally {
            guessesLabel.setText("Guesses: " + Calculate.guesses);
            if (Calculate.difficulty == 50 && Saves.scores[0] < 1000) {
                lowestScoreLabel.setText("Lowest Score: " + Saves.scores[0]);
                // System.out.println(Saves.scores[0]);
            } else if (Calculate.difficulty == 100 && Saves.scores[1] < 1000) {
                lowestScoreLabel.setText("Lowest Score: " + Saves.scores[1]);
                // System.out.println(Saves.scores[1]);
            } else if (Calculate.difficulty == 200 && Saves.scores[2] < 1000) {
                lowestScoreLabel.setText("Lowest Score: " + Saves.scores[2]);
                // System.out.println(Saves.scores[2]);
            } else {
                lowestScoreLabel.setText("Lowest Score: 0");
            }
            textField.setText("");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calculate = new Calculate();
    }
}
