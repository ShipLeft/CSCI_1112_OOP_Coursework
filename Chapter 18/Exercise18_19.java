import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * <h1>Exercise 18-19</h1>
 *
 * <p>This class will create an application with a sierpinski triangle
 * that will be modifiable through the use of a plus or minus button</p>
 *
 * <p>Created: 11/23/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise18_19 extends Application {

    @Override //Override the application start method
    /**
     * This method will create the panes and call upon the other methods
     * (or classes) and will create and show the stage.
     */
    public void start(Stage primaryStage){

        SierpinskiTriangle triangles = new SierpinskiTriangle();

        //Add buttons for the increase or decrease
        Button buttonPlus = new Button("+");
        Button buttonMinus = new Button("-");

        //Add HBox for button placement
        HBox buttonHBox = new HBox(buttonMinus, buttonPlus);
        buttonHBox.setSpacing(10);
        buttonHBox.setAlignment(Pos.CENTER);

        //Create BorderPane to set buttons and triangles in
        BorderPane pane = new BorderPane();
        pane.setCenter(triangles);
        pane.setBottom(buttonHBox);

        //Create a scene for the pane to go inside
        Scene scene = new Scene(pane, 300,350);
        primaryStage.setTitle("Exercise 18_19"); //Set new title
        primaryStage.setScene(scene); //Set the scene into the stage
        primaryStage.show(); //Show the stage

        //Add listeners to the program and show the triangle
        triangles.size();
        buttonPlus.setOnAction(e ->{
            triangles.setBigOrder(true);
            triangles.size();
        });
        buttonMinus.setOnAction(e -> {
            triangles.setLittleOrder(true);
            triangles.size();
        });
    }

    /**
     * <h1>SierpinskiTriangle</h1>
     *
     * <p>This class will create the triangle and the points for the new triangles.</p>
     *
     * <p>Created: 11/23/2021</p>
     *
     * @author Rhett Boatright
     */
    static class SierpinskiTriangle extends Pane{

        //Create variables for the program
        private int order = 0;
        private boolean bigOrder = false;
        private boolean littleOrder = false;

        //Get order for the triangles
        int getOrder(){
            return order;
        }

        //Set order for the triangles
        public void setOrder(int order){
            this.order = order;
            size();
        }

        //Set bigOrder
        public void setBigOrder(boolean bigOrder){
            this.bigOrder = bigOrder;
        }

        //Set littleOrder
        public void setLittleOrder(boolean littleOrder){
            this.littleOrder = littleOrder;
        }

        //Constructor
        SierpinskiTriangle() {

        }

        //Create size method to change the amount of triangles
        protected void size(){

            //new points in proportion with the size of the triangle
            Point2D point1 = new Point2D(getWidth()/2, 10);
            Point2D point2 = new Point2D(10, getHeight()-10);
            Point2D point3 = new Point2D(getWidth() - 10, getHeight() - 10);

            //Change the order size to apply changes
            if(bigOrder == true){
                order ++;
                bigOrder = false;
            }
            if(littleOrder == true && order != 0){
                order --;
                littleOrder = false;
            }

            this.getChildren().clear(); //Clear the pane before showing the new one.

            showTriangles(order, point1, point2, point3);
        }

        /**
         * This method will create the triangles and will add them to the SierpinskiTriangle
         *
         * @param order (int; amount of levels for the triangles)
         * @param point1 (Point2D; point 1 of the triangle)
         * @param point2 (Point2D; point 2 of the triangle)
         * @param point3 (Point2D; point 3 of the triangle)
         */
        private void showTriangles(int order, Point2D point1,
                                   Point2D point2, Point2D point3){
            //Create single triangle for order 0
            if (order == 0){
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(point1.getX(), point1.getY(),
                        point2.getX(), point2.getY(), point3.getX(), point3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);

                this.getChildren().add(triangle);
            }

            //Create new triangles matching the level of orders
            else {
                //Find triangle midpoint for the new triangles
                Point2D pointOne2 = point1.midpoint(point2);
                Point2D pointTwo2 = point2.midpoint(point3);
                Point2D pointThree2 = point3.midpoint(point1);

                //Draw new triangles
                showTriangles(order -1, point1, pointOne2, pointThree2);
                showTriangles(order -1, pointOne2, point2, pointTwo2);
                showTriangles(order -1, pointThree2, pointTwo2, point3);
            }
        }
    }

    /**
     * This method will launch the application if needed
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args){
        launch(args);
    }
}
