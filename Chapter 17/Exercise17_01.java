import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Random;

/**
 * <h1>Exercise 17_01</h1>
 *
 * <p>This Class will create a new .txt file and will write 100 random integers into it,
 * if the file already exists, it will append the new numbers to the .txt file</p>
 *
 * <p>Created: 11/17/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise17_01 {

    /**
     * This method will create the .txt file and create the
     * array of random ints and write the the file.
     *
     * @param args (String; placeholder of the main method.)
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws java.io.IOException{

        //Create a new array for 100 numbers and add Random for the random ints.
        int[] numbers = new int[100];
        Random randomNumbs = new Random();

        //Write the random integers into the array.
        for(int i = 0; i < 100; i++) numbers[i] = randomNumbs.nextInt();

        //Create the new file, append the file, and write to the file.
        File file = new File("RandomIntegers.txt");
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        for(int j = 0; j < 100; j++) printWriter.print(numbers[j] + " ");

        //Close each writer as to not corrupt data.
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();



    }
}
