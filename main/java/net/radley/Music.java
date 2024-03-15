package net.radley;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music implements Initializable {
    protected static MediaPlayer mediaPlayer;
    protected static Media media;

    protected static MediaPlayer fxPlayer;
    protected static Media fxMedia;

    public void play() throws MalformedURLException {
        String path = getClass().getResource("theme.mp3").getPath();
        path = path.replaceAll("%20", " ");
        media = new Media(new File(path).toURI().toURL().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    public void fxPlay() throws MalformedURLException {
        String path = getClass().getResource("hover.mp3").getPath();
        path = path.replaceAll("%20", " ");
        fxMedia = new Media(new File(path).toURI().toURL().toString());
        fxPlayer = new MediaPlayer(fxMedia);
        fxPlayer.play();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String path = getClass().getResource("theme.mp3").getPath();
        path = path.replaceAll("%20", " ");
        try {
            media = new Media(new File(path).toURI().toURL().toString());
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }
}
