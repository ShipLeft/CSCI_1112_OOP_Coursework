import java.util.Scanner;

/**
 * <h1>Exercise 18_09</h1>
 *
 * <p>This class will take a user inputted string, reverse it, and return the reverse to the user.</p>
 *
 * <p>Created: 11/18/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise18_09 {

    /**
     * This method will take the user input, will call upon the reverseString
     * method, and will print out the results of the reverseDisplay method.
     *
     * @param args (String; placeholder of the main method.)
     */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        //Prompt user to enter two integers.
        System.out.println("Enter a string: ");
        String forwards = input.next();

       //Print out the results and call upon the reverseString method.
        System.out.println("The reverse of " + forwards + " is: " + reverseDisplay(forwards) + ".");
    }

    /**
     * This method will reverse the string and return it to the main method.
     *
     * @param forwards (String; user's string from the main method.)
     *
     * @return
     */
    public static String reverseDisplay(String forwards){

        if(forwards.isEmpty()) return forwards;

        else return reverseDisplay(forwards.substring(1)) + forwards.charAt(0);
    }
}