import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * <h1>Test</h1>
 *
 * <p>This class will make a new clock and launch an application with a pane.</p>
 *
 * <p>Created: 11/03/2021</p>
 *
 * @author Rhett Boatright
 */
public class Test extends Application{

    /**
     * This class will override the start method on Application and will create the pane
     * for the clock to be put onto. This will also set the clock hands.
     *
     * @param primaryStage (Stage; is what it describes)
     */
    @Override
    public void start(Stage primaryStage){
        ClockPane clock = new ClockPane();


        clock.setSecondHandVisible(false);
        clock.setMinuteHandVisible(true);
        clock.setHourHandVisible(true);

        clock.setSecond(45);

        int random = (int)( Math.random() * 11);
        int choice = (int)( Math.random() * 2);
        System.out.println(random + "      " + choice);

        if(choice == 0){
            clock.setMinute(0);
        }
        else if(choice == 1) {
            clock.setMinute(30);
        }

        clock.setHour(random);

        String timeString = clock.getHour() + ":" + clock.getMinute();
        Label lblTime = new Label(timeString);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblTime);
        BorderPane.setAlignment(lblTime, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * This method will launch if the ide requires it.
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args){
        launch(args);
    }
}
