package com.example.e1621;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *<h1>Exercise 16_21</h1>
 *
 * <p>This class will make a 30 integer countdown and
 * will play music forever after the countdown has reached zero.</p>
 *
 * <p>Created: 11/11/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise16_21 extends Application {

    private int secondsLeft = 30;
    private BorderPane pane = new BorderPane();

    /**
     * This method will launch the application.
     * @param args (String; placeholder for the main method.)
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    /**
     * This method will create the countdown and will
     * add the music and the functionality of the key released.
     */
    public void start(Stage primaryStage) {

        //Add the song to the program
        MediaPlayer player = new MediaPlayer(new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3"));
        player.setAutoPlay(false);
        player.setCycleCount(MediaPlayer.INDEFINITE);

        //Create the new Panes for the timer.
        HBox timer = new HBox();
        String time = String.valueOf(secondsLeft);
        Text numbers = new Text(50, 50, time);
        numbers.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR,50));
        timer.setAlignment(Pos.CENTER);
        timer.getChildren().add(numbers);
        pane.setCenter(timer);


        Scene scene = new Scene(pane, 200, 60);
        primaryStage.setTitle("Timer");
        primaryStage.setScene(scene);
        primaryStage.show();


            scene.setOnKeyReleased(e -> {
                if (e.getCode() == KeyCode.ENTER) {
                    if (secondsLeft != 0) {
                        secondsLeft--;
                        numbers.setText(String.valueOf(secondsLeft));
                    }
                }
                if (secondsLeft == 0) {
                    player.setStartTime(Duration.seconds(0));
                    player.setStopTime(Duration.seconds(79));
                    player.setCycleCount(MediaPlayer.INDEFINITE);
                    player.play();
                }

            });
    }
}
