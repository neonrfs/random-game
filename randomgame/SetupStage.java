package randomgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SetupStage extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root, 640, 480);
            scene.getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
            // scene.getStylesheets().add("dark.css");
            stage.setTitle("Random game!");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.setOnCloseRequest(event -> {
                event.consume();
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.initStyle(StageStyle.DECORATED);
                alert.setTitle("Logout");
                alert.setHeaderText("You are about to logout!");
                alert.setContentText("Or in layman words, you are going to close!");
                if (alert.showAndWait().get().equals(ButtonType.OK)) {
                    System.out.println("Successfully logged out!");
                    stage.close();
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}