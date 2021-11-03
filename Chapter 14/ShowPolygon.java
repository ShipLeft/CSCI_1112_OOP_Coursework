import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.*;

/**
 * <h1>ShowPolygon</h1>
 *
 * <p>This class will create a polygon, fill the shape color as red,
 * and show a white text over the top creating a stop sign.</p>
 *
 * <p>Created: 11/03/2021</p>
 *
 * @Author Rhett Boatright
 */
public class ShowPolygon extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(new MyPolygon(), 400, 400);
        primaryStage.setTitle("ShowPolygon"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

/**
 * This class will create a polygon and fill that polygon
 *  as well as make some text to go over the top of that polygon.
 */
class MyPolygon extends StackPane {
    private void paint() {
        // Create a polygon and place polygon to pane
        Polygon polygon = new Polygon();
        polygon.setFill(Color.RED);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();

        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;

        // s represents the number of sides of the shape
        // Make sure to update this number when necessary
        int s = 8;
        // Add points to the polygon list
        for (int i = 0; i < s; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / s));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
        }

        getChildren().clear();
        polygon.setRotate(22.5);


        Text label = new Text("STOP");
        label.setFont(Font.font("Times New Roman",
                FontWeight.NORMAL, FontPosture.REGULAR, 62));
        label.setFill(Color.WHITE);
        getChildren().addAll(polygon, label);


    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}