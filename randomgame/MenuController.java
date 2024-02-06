package randomgame;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {
    @FXML private AnchorPane anchorPane;
    @FXML private Button easy, normal, hard;

    private static int randomLimit = 20;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void closeRequest(ActionEvent event) {
        stage = (Stage) anchorPane.getScene().getWindow();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.DECORATED);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Or in layman words, you are going to close!");
        if (alert.showAndWait().get().equals(ButtonType.OK)) {
            System.out.println("Successfully logged out!");
            stage.close();
        }
    }

    public void startGame(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
            root = loader.load();
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root, 640, 480);
            GameController controller = loader.getController();
            if (event.getSource().equals(easy)) {
                controller.calculate = new Calculate(50);
            } else if (event.getSource().equals(normal)) {
                controller.calculate = new Calculate(100);
            } else if (event.getSource().equals(hard)) {
                controller.calculate = new Calculate(200);
            } else {
                System.out.println("Error! No difficulty selected!");
            }
            controller.displayLabel.setText("Enter a number between 1 and " + Calculate.difficulty + ".");
            controller.textField.setPromptText("1 and " + Calculate.difficulty);
            controller.textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

                    @Override
                    public void handle(KeyEvent arg0) {
                        if (arg0.getCode() == KeyCode.ENTER) {
                            controller.getNumber();
                        } else if (arg0.getCode().equals(KeyCode.ESCAPE)) {
                            try {
                                root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                                scene = new Scene(root, 640, 480);
                                scene.getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
                                stage.setScene(scene);
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        } else if (arg0.getCode() == KeyCode.SHIFT) {
                            if ((int) (Math.random() * randomLimit) + 1 == 1) {
                                controller.displayLabel.setText("Do you REALLY need help?");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 2) {
                                controller.displayLabel.setText("Can you use your common sense?");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 3) {
                                controller.displayLabel.setText("I\'m gonna quit this game...");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 4) {
                                controller.displayLabel.setText("Alright, this is just an insult...");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 5) {
                                controller.displayLabel.setText("Lemme go play CS:GO instead...");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 6) {
                                controller.displayLabel.setText("Roblox is still alive?");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 7) {
                                controller.displayLabel.setText("Can you bring something from Jeff\'s?");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 8) {
                                controller.displayLabel.setText("Who am I kidding...");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 9) {
                                controller.displayLabel.setText("Can\'t you leave a game alone?");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 10) {
                                controller.displayLabel.setText("Charlie Brown, come stop this guy!");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 11) {
                                controller.displayLabel.setText("Fortnite seems to be trending.");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 12) {
                                controller.displayLabel.setText("FYI, my fav game is Geometry Dash.");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 13) {
                                controller.displayLabel.setText("My fav dev is GDColon, is he dev tho?");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 14) {
                                controller.displayLabel.setText("YOU WILL CRASH THIS GAME!!!");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 15) {
                                controller.displayLabel.setText("I can\'t stand this, HELP!!");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 16) {
                                controller.displayLabel.setText("Rats, Steam is dead RIP...");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 17) {
                                controller.displayLabel.setText("Itch.io is idle RIP...");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 18) {
                                controller.displayLabel.setText("Game Jolt doesn\'t have good players...");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 19) {
                                controller.displayLabel.setText("When is the next GDColon video?");
                            } else if ((int) (Math.random() * randomLimit) + 1 == 20) {
                                controller.displayLabel.setText("Why don\'t you help me code instead? Just go to my GitHub...");
                            } else {
                                controller.displayLabel.setText("Don't you have something else to do?");
                            }
                        }
                    }
                    
                });

            scene.getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
