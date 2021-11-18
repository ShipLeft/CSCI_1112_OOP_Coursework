import java.util.Scanner;

/**
 * <h1>Exercise 18_03</h1>
 *
 * <p>This class will determine what the gcd of two user inputs is and display it to the user.</p>
 *
 * <p>Created: 11/18/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise18_03 {

    /**
     * This method will take the user inputs, will call upon gCD, and will print the results.
     *
     * @param args (String; placeholder for the main method.)
     */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        //Prompt user to enter two integers.
        System.out.println("Enter two integers separated by a space: ");
        int first = input.nextInt();
        int second = input.nextInt();

        int bigger;
        int smaller;

        //Find which of the two is bigger and set values for bigger and smaller.
        if(first > second){
            bigger = first;
            smaller = second;
        }else{
            bigger = second;
            smaller = first;
        }

        System.out.println("Greatest Common Divisor of " + first +
                " and " + second + " is " + gCD(bigger, smaller) + ".");
    }

    /**
     * This method will determine the gcd of the two user inputs from the main method.
     *
     * @param bigger (int; the bigger integer that the user put in.)
     * @param smaller (int; the smaller integer that the user put in.)
     * @return
     */
    public static int gCD(int bigger, int smaller){
        if(smaller == 0) return bigger;

        else return gCD(smaller, bigger % smaller);
    }
}
