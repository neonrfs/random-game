package randomgame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
    private static int randomLimit = 20;
    
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
            Parent root = loader.load();
            SceneController controller = loader.getController();
            Scene scene = new Scene(root, 640, 480);
            controller.textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent arg0) {
                    if (arg0.getCode() == KeyCode.ENTER) {
                        controller.getNumber();
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
            // scene.getStylesheets().add("dark.css");
            stage.setTitle("Random game!");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
