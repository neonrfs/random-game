package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SceneController {
    @FXML
    Label displayLabel;
    @FXML
    TextField textField;
    @FXML
    Label guessesLabel;
    @FXML
    CheckBox editTheme;

    Calculate calculate = new Calculate();

    public void getNumber(ActionEvent event) {
        try {
            if (displayLabel.getText().toLowerCase() == "appbuild") {
                displayLabel.setText("App version: " + calculate.appbuild);
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
            textField.setText("");
        }
    }
    public void changeTheme(ActionEvent event) {
        displayLabel.setText("Sorry, doesn\'t work yet. Waiting for v0.1.5");
    }
}
