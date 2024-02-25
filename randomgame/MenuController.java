package randomgame;

import java.io.IOException;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController{

    @FXML private AnchorPane anchorPane;
    @FXML private Button easy, normal, hard;

    private static int randomLimit = 30;
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
            controller.textField.setOnKeyPressed(arg0 -> {
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
                } else if (arg0.getCode().equals(KeyCode.SHIFT) || arg0.getCode().equals(KeyCode.CONTROL)) {
                    switch ((int) (Math.random() * (randomLimit + 1))) {
                        case 1:
                        controller.displayLabel.setText("Do you REALLY need help?");
                        break;
                    
                        case 2:
                        controller.displayLabel.setText("Can you use your common sense?");
                        break;
                        
                        case 3:
                        controller.displayLabel.setText("I\'m gonna quit this game...");
                        break;
                            
                        case 4:
                        controller.displayLabel.setText("Alright, this is just an insult...");
                        break;
                        
                        case 5:
                        controller.displayLabel.setText("Lemme go play CS:GO instead...");
                        break;
                        
                        case 6:
                        controller.displayLabel.setText("Roblox is still alive?");
                        break;
                        
                        case 7:
                        controller.displayLabel.setText("Can you bring something from Jeff\'s?");
                        break;
                        
                        case 8:
                        controller.displayLabel.setText("Who am I kidding...");
                        break;
                        
                        case 9:
                        controller.displayLabel.setText("Can\'t you leave a game alone?");
                        break;

                        case 10:
                        controller.displayLabel.setText("Charlie Brown, come stop this guy!");
                        break;

                        case 11:
                        controller.displayLabel.setText("Fortnite seems to be trending.");
                        break;

                        case 12:
                        controller.displayLabel.setText("FYI, my fav game is Geometry Dash.");
                        break;

                        case 13:
                        controller.displayLabel.setText("My fav dev is GDColon, is he dev tho?");
                        break;

                        case 14:
                        controller.displayLabel.setText("YOU WILL CRASH THIS GAME!!!");
                        break;
                        
                        case 15:
                        controller.displayLabel.setText("I can\'t stand this, HELP!!");
                        break;
                        
                        case 16:
                        controller.displayLabel.setText("Rats, Steam is dead RIP...");
                        break;
                        
                        case 17:
                        controller.displayLabel.setText("Itch.io is idle RIP...");
                        break;

                        case 18:
                        controller.displayLabel.setText("Game Jolt doesn\'t have good players...");
                        break;
                        
                        case 19:
                        controller.displayLabel.setText("When is the next GDColon video?");
                        break;
                        
                        case 20:
                        controller.displayLabel.setText("Why don\'t you help me code instead? Just go to my GitHub...");
                        break;  

                        case 21:
                        controller.displayLabel.setText("New updates are always good, right?");
                        break;
                        
                        case 22:
                        controller.displayLabel.setText("CS2 is trash, I\'d rather play Fortnite...");
                        break;
                        
                        case 23:
                        controller.displayLabel.setText("Gimme some robux in pls donate...");
                        break;
                        
                        case 24:
                        controller.displayLabel.setText("Win11 is mid, Ubuntu better!");
                        break;
                        
                        case 25:
                        controller.displayLabel.setText("My fav Roblox game is DOORS. It was when Win10 was ...");
                        break;
                            
                        case 26:
                        controller.displayLabel.setText("I am skilled in Java, mid in C#, noob in Lua");
                        break;
                        
                        case 27:
                        controller.displayLabel.setText("IDK why I love Java...");
                        break;
                        
                        case 28:
                        controller.displayLabel.setText("Lua is also quite good, man...");
                        break;

                        case 29:
                        controller.displayLabel.setText("C# is OP, tho!");
                        break;
                        
                        case 30:
                        controller.displayLabel.setText("Don't you have something else to do?");
                        break;

                        default:
                        controller.displayLabel.setText("IDONTHAVEANYTHINGTOSAYMATE");
                        break;
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
