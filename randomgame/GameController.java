package randomgame;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController {
    @FXML Button submitButton;
    @FXML Label titleLabel;
    @FXML Label displayLabel;
    @FXML Label lowestScoreLabel;
    @FXML TextField textField;
    @FXML Label guessesLabel;
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
                        displayLabel.setText("Uses OpenJDK 21.0.2 and JFX SDK 21.0.2");
                        break;
                    case "/credits":
                        displayLabel.setText("Runs on JFX Framework, created in VSCode and SceneBuilder");
                        break;
                    case "/retry":
                        displayLabel.setText("Enter a number between 1 and " + Calculate.difficulty + ".");
                        textField.setPromptText("1 and " + Calculate.difficulty);
                        calculate.reset();
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
                displayLabel.setText(calculate.matchNumber(Long.parseLong(textField.getText())));
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            displayLabel.setText("Not a number, try again!");
        } catch (Exception e) {
            System.out.println(e);
            displayLabel.setText("Something went wrong, try again!");
        } finally {
            guessesLabel.setText("Guesses: " + Calculate.guesses);
            lowestScoreLabel.setText("Lowest Score: " + Calculate.lowestScore);
            textField.setText("");
        }
    }
    public void toMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
        stage.setScene(scene);
    }
}
