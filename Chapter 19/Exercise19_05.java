/**
 * <h1>Exercise 19_05</h1>
 *
 * <p>This class will create arrays of Circles, Integers, and Strings
 * and will sort them all using a generic method to sort all three.</p>
 *
 * <p>Created: 11/23/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise19_05 {

    /**
     * This method will find the max in an array and return it.
     *
     * @param list (E; generic list from the main method)
     * @param <E> (Generic value; allows the main method
     *          to pass multiple different array types)
     * @return
     */
    public static <E extends Comparable<E>> E max(E[] list){
        E max = null;

        //For loop to search the array
        for(int i = 0; i < list.length - 1; i++){
            max = list[i];

            //for loop to compare items in the array
            for(int j = 0; j < list.length; j++){
                if(max.compareTo(list[j]) < 0){
                    max = list[j];
                }
            }
        }
        return max;
    }

    /**
     * This method will create three different arrays (Integer, Circle, and String)
     * and will call upon the max method to find the max values.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3}; //Integer array
        System.out.println(max(numbers));

        String[] words = {"red", "green", "blue"}; //String array
        System.out.println(max(words));

        Circle[] circles = {new Circle(3), new Circle(2.9),
                new Circle(5.9)}; //Circle array
        System.out.println(max(circles));
    }

    /**
     * <h1>Circle</h1>
     *
     * <p>This class will make a circle constructor</p>
     *
     * <p>Created: unknown</p>
     *
     * @author unknown
     */
    static class Circle implements Comparable<Circle> {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public int compareTo(Circle c) {
            if (radius < c.radius)
                return -1;
            else if (radius == c.radius)
                return 0;
            else
                return 1;
        }

        @Override
        public String toString() {
            return "Circle radius: " + radius;
        }
    }
}