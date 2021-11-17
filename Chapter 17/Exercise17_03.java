import java.io.*;
import java.util.Random;

/**
 * <h1>Exercise 17_03</h1>
 *
 * <p>This Class will create a new file, populate it with 100 random integers,
 * read the integers from the file, and total up all of the integers and print out the total.</p>
 *
 * <p>Created 11/17/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise17_03 {

    /**
     * This method will create the new file (or write over the top of the old file) and put 100 random
     * integers inside of the new file.
     *
     * @throws IOException
     */
    public static void fileMaker () throws IOException {

        Random randomInt = new Random();


        try(
                FileOutputStream outputStream = new FileOutputStream("Exercise17_03.dat", false);
        ){
            for(int j = 0; j < 100; j++) outputStream.write(randomInt.nextInt());
        }
    }

    /**
     * This method will read the integers from the file, total them up, and print out the results.
     *
     * @param args (String; placeholder for the main method)
     *             
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        int total = 0;
        fileMaker();
        try(
                //InputStream creation for the binary file.
                DataInputStream inputStream =
                        new DataInputStream(new FileInputStream("Exercise17_03.dat"));
        ) {
            int numberFromFile;
            while ((numberFromFile = inputStream.read()) != -1) {
                total += numberFromFile;
                System.out.print(numberFromFile + " ");
            }
            System.out.println("\n" + total);
        }
    }
}
