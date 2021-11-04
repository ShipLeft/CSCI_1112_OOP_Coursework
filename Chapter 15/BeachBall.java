import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.awt.event.ActionEvent;

/**
 * <h1>BeachBall</h1>
 *
 * <p>This class will launch an application to move a beach ball around on the pane.</p>
 *
 * <p>Created: 11/04/2021</p>
 *
 * @author Rhett Boatright
 */
public class BeachBall extends Application{
    @Override
    /**
     * This method will create the ball for the application. It will also
     * create the parameters for the ball's movement and create the buttons to do so.
     */
    public void start(Stage primaryStage){
        //Create circle
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        //Create pane and add circle
        Pane beach = new Pane(circle);
        circle.setCenterX(100);
        circle.setCenterY(100);

        //Add buttons for moving the ball.
        Button buttonUp = new Button("Up");
        Button buttonDown = new Button("Down");
        Button buttonLeft = new Button("Left");
        Button buttonRight = new Button("Right");

        //Create HBox for button placement
        HBox buttonHBox = new HBox(buttonUp, buttonDown, buttonLeft, buttonRight);
        buttonHBox.setSpacing(10);
        buttonHBox.setAlignment(Pos.CENTER);

        //Create BorderPane to set up the correct areas for the buttons and circle movement.
        BorderPane workArea = new BorderPane();
        workArea.setBottom(buttonHBox);
        workArea.setCenter(beach);


        //Create the scene and place in a stage.
        Scene scene = new Scene(workArea,400,400);
        primaryStage.setTitle("BeachBall");//set the title to BeachBall.
        primaryStage.setScene(scene);//place new scene in the stage
        primaryStage.show();//show the stage

        //Create listeners.
        buttonUp.setOnAction(e ->
                circle.setCenterY(circle.getCenterY() > 50?
                        circle.getCenterY() -50 :  50));
        buttonDown.setOnAction(e ->
                circle.setCenterY(circle.getCenterY() < beach.getHeight() - 75?
                        circle.getCenterY() + 50 : beach.getHeight() - 75));
        buttonLeft.setOnAction(e ->
                circle.setCenterX(circle.getCenterX() > 50?
                        circle.getCenterX() -50 :  50));
        buttonRight.setOnAction(e ->
                circle.setCenterX(circle.getCenterX() < beach.getWidth() - 50?
                        circle.getCenterX() + 50 : beach.getWidth() - 50));
    }

    /**
     * This method will launch the application for IDEs that need it.
     * @param args (String; placeholder for the main method.
     */
    public static void main(String[] args){
        launch(args);
    }
}
