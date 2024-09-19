package net.radley;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SwitchScene {
    private static int randomLimit = 60;
    private static FXMLLoader loader;
    private static Parent root;
    private static Stage stage;
    private static Scene scene;

    protected void toMenu(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource(Calculate.themeStatus).toExternalForm());
        stage.setScene(scene);
    }
    protected void toGame(ActionEvent event, Button easy, Button normal, Button hard) throws IOException {
        loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        root = loader.load();
        GameController controller = loader.getController();
        if (event.getSource().equals(easy)) {
            controller.calculate = new Calculate(50);
            if (Saves.scores[0] < 1000) {
                controller.lowestScoreLabel.setText("Lowest Score: " + Saves.scores[0]);
                // System.out.println(Saves.scores[0]);
            }
        } else if (event.getSource().equals(normal)) {
            controller.calculate = new Calculate(100);
            if (Saves.scores[1] < 1000) {
                controller.lowestScoreLabel.setText("Lowest Score: " + Saves.scores[1]);
                // System.out.println(Saves.scores[1]);
            }
        } else if (event.getSource().equals(hard)) {
            controller.calculate = new Calculate(200);
            if (Saves.scores[2] < 1000) {
                controller.lowestScoreLabel.setText("Lowest Score: " + Saves.scores[2]);
                // System.out.println(Saves.scores[2]);
            }
        } else {
            System.out.println("Error! No difficulty selected!");
            controller.lowestScoreLabel.setText("Lowest Score: 0");
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 640, 480);
        controller.displayLabel.setText("Enter a number between 1 and " + Calculate.difficulty + ".");
        controller.textField.setPromptText("1 and " + Calculate.difficulty);
        controller.textField.setOnKeyPressed(arg0 -> {
            if (arg0.getCode() == KeyCode.ENTER) {
                controller.getNumber();
            } else if (arg0.getCode().equals(KeyCode.ESCAPE)) {
                try {
                    root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                    scene = new Scene(root, 640, 480);
                    scene.getStylesheets().add(getClass().getResource(Calculate.themeStatus).toExternalForm());
                    stage.setScene(scene);
                } catch (IOException e) {
                    System.out.println(e);
                }
            } else if (arg0.getCode().equals(KeyCode.SHIFT) || arg0.getCode().equals(KeyCode.CONTROL) || arg0.getCode().equals(KeyCode.TAB)) {
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

                    case 31:
                    controller.displayLabel.setText("Let's all play a game");
                    break;

                    case 32:
                    controller.displayLabel.setText("WHY DON'T YOU TRY TO GUESS!");
                    break;

                    case 33:
                    controller.displayLabel.setText("Pam, pam pam pam, NICO'S!");
                    break;

                    case 34:
                    controller.displayLabel.setText("Repent for thy sins.");
                    break;

                    case 35:
                    controller.displayLabel.setText("One must sacrifice himself.");
                    break;

                    case 36:
                    controller.displayLabel.setText("The LORD bless thee and keep thee");
                    break;

                    case 37:
                    controller.displayLabel.setText("CS:Source reloads -> 3 secs. -> 'Slow'");
                    break;

                    case 38:
                    controller.displayLabel.setText("G&B reloads -> 35 secs -> 'Good things...'");
                    break;

                    case 39:
                    controller.displayLabel.setText("I was down, but now I'm...");
                    break;

                    case 40:
                    controller.displayLabel.setText("Is that you... NVM, i must be dreaming.");
                    break;

                    case 41:
                    controller.displayLabel.setText("Thank you for playing my game.");
                    break;

                    case 42:
                    controller.displayLabel.setText("I recommend you to try e-sword");
                    break;

                    case 43:
                    controller.displayLabel.setText("Man, I wish I got Linux back...");
                    break;

                    case 44:
                    controller.displayLabel.setText("I could have danced all night...");
                    break;

                    case 45:
                    controller.displayLabel.setText("They are corrupt, their deeds are vile.");
                    break;

                    case 46:
                    controller.displayLabel.setText("You died to displayLabel, look out for cues...");
                    break;

                    case 47:
                    controller.displayLabel.setText("Backdoor -> Hotel -> Rooms -> Hotel -> Mines");
                    break;

                    case 48:
                    controller.displayLabel.setText("Why don't you smile for me ;)");
                    break;

                    case 49:
                    controller.displayLabel.setText("You died to textField, remember to be careful");
                    break;

                    case 50:
                    controller.displayLabel.setText("I can't see you smiling ;)");
                    break;

                    case 51:
                    controller.displayLabel.setText("Even tho I hurt, see I smile ;)");
                    break;

                    case 52:
                    controller.displayLabel.setText("When is Floor 3 out?");
                    break;

                    case 53:
                    controller.displayLabel.setText("C'mon man, help me in Floor 1, I'm stuck");
                    break;

                    case 54:
                    controller.displayLabel.setText("BTW, Floor 2 is FIREEE!");
                    break;

                    case 55:
                    controller.displayLabel.setText("New day, new chance to live right!");
                    break;

                    case 56:
                    controller.displayLabel.setText("Your conscience will prick you...");
                    break;

                    case 57:
                    controller.displayLabel.setText("What is the sunshine (and the love)?");
                    break;

                    case 58:
                    controller.displayLabel.setText("Wild blue, deeper than I ever knew");
                    break;

                    case 59:
                    controller.displayLabel.setText("Who knows how long, how long, how long?");
                    break;

                    case 60:
                    controller.displayLabel.setText("The hills and valleys, y'all.");
                    break;

                    default:
                    controller.displayLabel.setText("It's a heartbreak warfare.");
                    break;
                }
            }
        });

        scene.getStylesheets().add(getClass().getResource(Calculate.themeStatus).toExternalForm());
        stage.setScene(scene);
    }
    protected void toSettings(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource(Calculate.themeStatus).toExternalForm());
        stage.setScene(scene);
    }
    protected void closeRequest(ActionEvent event) {
        SetupStage.saves.save();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
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
}
