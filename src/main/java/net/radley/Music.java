package net.radley;

import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
    protected static MediaPlayer mediaPlayer;
    protected static Media media;

    protected static MediaPlayer fxPlayer;
    protected static Media fxMedia;

    public Music() {
        String path = getClass().getResource("theme" + Integer.toString((int)(Math.random() * 10) + 1) +  ".mp3").getPath();
        path = path.replaceAll("%20", " ");
        try {
            media = new Media(new File(path).toURI().toURL().toString());
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        path = getClass().getResource("hover" + Integer.toString((int)(Math.random() * 2) + 1) +  ".mp3").getPath();
        path = path.replaceAll("%20", " ");
        try {
            fxMedia = new Media(new File(path).toURI().toURL().toString());
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
        fxPlayer = new MediaPlayer(fxMedia);
        fxPlayer.setCycleCount(1);
    }

    public void play() throws MalformedURLException {
        mediaPlayer.play();
    }
    public void fxPlay() throws MalformedURLException {
        fxPlayer.play();
    }
}
