import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * <h1>RectangleAnimation</h1>
 *
 * <p>This class will Create a pentagon and a rectangle in an application with the
 *  rectangle going along the pentagon's outside and fading in and out of color.</p>
 *
 * <p>Created: 11/04/2021</p>
 *
 * @author Rhett Boatright
 */
public class RectangleAnimation extends Application {
    @Override
    /**
     * This method will create the shapes and implement the transitions and fades
     * for the application as well as implement the pause and resume.
     */
    public void start(Stage primaryStage){
        StackPane pane = new StackPane();




        Polygon polygon = new Polygon();
        ObservableList<Double> list = polygon.getPoints();

        double centerX = pane.getWidth() / 2, centerY = pane.getHeight() / 2;
        double radius = Math.min(500, 500 * 0.4);

        // s represents the number of sides of the shape
        // Make sure to update this number when necessary
        int s = 5;
        // Add points to the polygon list
        for (int i = 0; i < s; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / s));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
        }

        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        polygon.setRotate(54);

        //create shapes for the scene
        Rectangle rectangle = new Rectangle(0, 0, 25,50);
        rectangle.setFill(Color.RED);//color of rectangle




        //Create path transition for rectangle to follow
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(2000));
        pathTransition.setPath(polygon);
        pathTransition.setNode(rectangle);
        //Allow the rectangle to follow the pentagons outline.
        pathTransition.setOrientation(
                PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.play();

        polygon.setOnMousePressed(e -> pathTransition.pause());//Pause when mouse button is held
        polygon.setOnMouseReleased(e -> pathTransition.play());//play when mouse button is released

        //Create a fade transition for the rectangle
        FadeTransition recFade
                = new FadeTransition(Duration.millis(1000),rectangle);//time to fade back and forth
        recFade.setFromValue(1.0);//Full color value set
        recFade.setToValue(0.1);//opacity value set
        recFade.setCycleCount(Timeline.INDEFINITE);//runtime of the fade
        recFade.play();

        pane.setOnMousePressed(e -> recFade.pause());//pause fade when mouse button is held
        pane.setOnMouseReleased(e -> recFade.play());//play fade when mouse button is released

        pane.getChildren().addAll(polygon, rectangle);


        Scene scene = new Scene(pane,500,500);
        primaryStage.setTitle("RectangleAnimation");//title for application
        primaryStage.setScene(scene);//Place scene in the stage
        primaryStage.show();//Show stage
    }

    /**
     * This method will launch the application.
     *
     * @param args (String; placeholder for the main method.
     */
    public static void main(String[] args){
        launch(args);
    }

}

