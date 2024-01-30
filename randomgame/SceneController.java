package randomgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class SceneController {
    @FXML Button submitButton;
    @FXML Label titleLabel;
    @FXML Label displayLabel;
    @FXML Label lowestScoreLabel;
    @FXML TextField textField;
    @FXML Label guessesLabel;
    @FXML CheckBox editTheme;
    @FXML AnchorPane anchorPane;

    Calculate calculate = new Calculate();

    public void getNumber() {
        try {
            if (textField.getText().contains("/")) {
                switch (textField.getText().toLowerCase()) {
                    case "/help":
                        displayLabel.setText("See terminal for more info.");
                        System.out.println("Slash commands can be typed for info about the app. The following commands can be used.");
                        System.out.println("/appbuild\n/sdkinfo\n/credits\n/com.x\n/com.roblox");
                        break;
                    case "/appbuild":
                        displayLabel.setText("App version: " + calculate.appbuild);
                        break;
                    case "/sdkinfo":
                        displayLabel.setText("Uses JDK 21.0.2 and JFX SDK 21.0.2");
                        break;
                    case "/credits":
                        displayLabel.setText("Runs on JFX Framework, created in VSCode and SceneBuilder");
                        break;
                    case "/retry":
                        displayLabel.setText("Enter a number between 1 to 100");
                        calculate = new Calculate();
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
                        break;
                }
            } else if (textField.getText().toLowerCase().equals("help")) {
                displayLabel.setText("See terminal for more info.");
                System.out.println("Slash commands can be typed for info about the app. The following commands can be used.");
                System.out.println("/appbuild\n/sdkinfo\n/credits\n/com.x\n/com.roblox\n/help");
            } else if (textField.getText().equals("")) {
                if (displayLabel.getText().equals("No marks for writing nothin\', bro!")) {
                    displayLabel.setText("Don't be lazy bro!");
                } else {
                    displayLabel.setText("No marks for writing nothin\', bro!");
                }
            } else {
                displayLabel.setText(calculate.matchNumber(Long.parseLong(textField.getText())));
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            displayLabel.setText("Not a number, try again!");
        } catch (Exception e) {
            System.out.println(e);
            displayLabel.setText("Something went wrong, try again!");
        } finally {
            guessesLabel.setText("Guesses: " + calculate.guesses);
            lowestScoreLabel.setText("Lowest Score: " + calculate.lowestScore);
            textField.setText("");
        }
    }
    public void changeTheme(ActionEvent event) {
        if (!editTheme.isSelected()) {
            submitButton.setBackground(new Background(new BackgroundFill(Color.valueOf("#ff3030"), null, null)));
            submitButton.setTextFill(Color.BLACK);
            displayLabel.setTextFill(Color.BLACK);
            titleLabel.setTextFill(Color.BLACK);
            guessesLabel.setTextFill(Color.BLACK);
            lowestScoreLabel.setTextFill(Color.BLACK);
            editTheme.setTextFill(Color.BLACK);
            anchorPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        } else {
            submitButton.setBackground(new Background(new BackgroundFill(Color.valueOf("#dd0707"), null, null)));
            submitButton.setTextFill(Color.WHITE);
            displayLabel.setTextFill(Color.WHITE);
            titleLabel.setTextFill(Color.WHITE);
            guessesLabel.setTextFill(Color.WHITE);
            lowestScoreLabel.setTextFill(Color.WHITE);
            editTheme.setTextFill(Color.WHITE);
            anchorPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        }
    }
}
