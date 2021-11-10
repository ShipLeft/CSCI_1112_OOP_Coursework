package com.example.exercise161;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

/**
 * <h1>ColorChangingText</h1>
 *
 * <p>This class will create an application that allows
 * the user to move text and change the color of the text.</p>
 *
 * <p>Created: 11/10/2021</p>
 *
 * @author Rhett Boatright
 */
public class ColorChangingText extends Application {
    private Text t = new Text(50,50,"Programming is fun");

    /**
     * This method will create the BorderPane, the buttons, and the text to go with them
     * as well as implement what each button will accomplish.
     *
     * @return
     */
    private BorderPane newPane(){

        //Set up HBox for the lower buttons.
        HBox lowerButtons = new HBox(20);
        Button moveLeft = new Button ("<=");
        Button moveRight = new Button("=>");
        lowerButtons.getChildren().addAll(moveLeft, moveRight);
        lowerButtons.setAlignment(Pos.CENTER);
        lowerButtons.setStyle("-fx-border-color: black");

        //Set up BorderPane and add the lowerButtons
        BorderPane pane = new BorderPane();
        pane.setBottom(lowerButtons);

        //Set up the pane for the text
        Pane textPane = new Pane();
        textPane.getChildren().add(t);
        pane.setCenter(textPane);

        //Set up HBox for radio buttons for the color changing.
        HBox upperButtons = new HBox(20);
        upperButtons.setPadding(new Insets(5, 5, 5, 5));
        upperButtons.setStyle("-fx-border-color: black");
        RadioButton redButton = new RadioButton("Red");
        RadioButton yellowButton = new RadioButton("Yellow");
        RadioButton blackButton = new RadioButton("Black");
        RadioButton orangeButton = new RadioButton("Orange");
        RadioButton greenButton = new RadioButton("Green");
        RadioButton blueButton = new RadioButton("Blue");
        upperButtons.getChildren().addAll(redButton,
                yellowButton,blackButton,orangeButton,greenButton, blueButton);
        upperButtons.setAlignment(Pos.CENTER);
        pane.setTop(upperButtons);

        //Set up toggle group for the different color buttons.
        ToggleGroup toggleGroup = new ToggleGroup();
        redButton.setToggleGroup(toggleGroup);
        yellowButton.setToggleGroup(toggleGroup);
        blackButton.setToggleGroup(toggleGroup);
        orangeButton.setToggleGroup(toggleGroup);
        greenButton.setToggleGroup(toggleGroup);
        blueButton.setToggleGroup(toggleGroup);

        //Set each radiobutton to fill to their respective colors.
        redButton.setOnAction(e -> {
            if (redButton.isSelected()){
                t.setFill(Color.RED);
            }
        });

        yellowButton.setOnAction(e -> {
            if (yellowButton.isSelected()){
                t.setFill(Color.YELLOW);
            }
        });

        blackButton.setOnAction(e -> {
            if (blackButton.isSelected()){
                t.setFill(Color.BLACK);
            }
        });

        orangeButton.setOnAction(e -> {
            if (orangeButton.isSelected()){
                t.setFill(Color.ORANGE);
            }
        });

        greenButton.setOnAction(e -> {
            if (greenButton.isSelected()){
                t.setFill(Color.GREEN);
            }
        });

        blueButton.setOnAction(e -> {
            if (blueButton.isSelected()){
                t.setFill(Color.BLUE);
            }
        });


        //Set what the moveLeft and moveRight buttons will do.
        moveLeft.setOnAction(e -> t.setX(t.getX() > 10?
                t.getX() -20: 10));
        moveRight.setOnAction(e -> t.setX(t.getX() < pane.getWidth() - 210?
                t.getX() + 20: pane.getWidth() - 210));

        //Set text font and size.
        t.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR,20));

        return pane;
    }

    @Override
    /**
     * This method will start the application.
     */
    public void start(Stage primaryStage){
        //Create a new scene and place in primaryStage
        Scene movingText = new Scene(newPane(), 450, 200);
        primaryStage.setTitle("Exercies 16_01");
        primaryStage.setScene(movingText);
        primaryStage.show();
    }

    /**
     * This method will launch the program.
     * @param args (String; placeholder for the main method.)
     */
    public static void main(String[] args){
        launch(args);
    }
}
