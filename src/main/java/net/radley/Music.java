package net.radley;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.StageStyle;

public class Music {
    protected static MediaPlayer mediaPlayer;
    protected static Media media;

    protected static MediaPlayer fxPlayer;
    protected static Media fxMedia;

    protected static String song;

    public Music() {
        song = "theme" + Integer.toString((int)(Math.random() * 10) + 1) +  ".mp3";
        String path = getClass().getResource(song).getPath();
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
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.initStyle(StageStyle.DECORATED);
        alert.setTitle("Music");
        if (song.equals("theme1.mp3")) {
            alert.setHeaderText("Fractured Poetry");
            alert.setContentText("Currently playing Fractured Poetry by Urgel");
        } else if (song.equals("theme2.mp3")) {
            alert.setHeaderText("The Final Push");
            alert.setContentText("Bradley Farmer has set you off, now GO cross the bridge!");
        } else if (song.equals("theme3.mp3")) {
            alert.setHeaderText("safe room");
            alert.setContentText("Relax, it's safe, nicopatty's got ya back :)");
        } else if (song.equals("theme4.mp3")) {
            alert.setHeaderText("Dawn of the DOORS");
            alert.setContentText("Look out, you might get Lightning_Splashed...");
        } else if (song.equals("theme5.mp3")) {
            alert.setHeaderText("Explorer");
            alert.setContentText("Explore the seas with AXS!");
        } else if (song.equals("theme6.mp3")) {
            alert.setHeaderText("Globally Offensive");
            alert.setContentText("Theme song by Mike Morasky");
        } else if (song.equals("theme7.mp3")) {
            alert.setHeaderText("1812 Overture");
            alert.setContentText("Tchaikovsky... MMM...");
        } else if (song.equals("theme8.mp3")) {
            alert.setHeaderText("30.000");
            alert.setContentText("Currently jamming to 30.000 by Colbreakz");
        } else if (song.equals("theme9.mp3")) {
            alert.setHeaderText("Werk");
            alert.setContentText("Currently bass boosting Work by Teminite");
        } else if (song.equals("theme10.mp3")) {
            alert.setHeaderText("i sleep");
            alert.setContentText("Currently chilling out, thanks LSPLASH:)");
        } else {
            alert.setHeaderText("i am not sure");
            alert.setContentText("But, just jam to it ;D");
        }
        alert.show();
        
    }
    public void fxPlay() throws MalformedURLException {
        fxPlayer.play();
    }

    public void pause() {
        mediaPlayer.pause();
    }
}
