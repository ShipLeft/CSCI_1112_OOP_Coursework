import java.io.*;
import java.util.Scanner;

/**
 * <h1>Exercise 17_14</h1>
 *
 * <p>This class will encrypt a file and make a new file with the encrypted data.
 * The user will choose what file to pull from and what file to push to.</p>
 *
 * <p>Created: 11/18/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise17_14 {

    /**
     * This method will take information from a file, encrypt it, and send it to a different file.
     *
     * @param args (String; placeholder of the main method)
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{
        int file = 0;
        String fileString;
        int key = 5;
        Scanner input = new Scanner(System.in);

        //Prompt user to enter file names.
        System.out.println("Enter the name of the input file: ");
        String inputName = input.next();
        System.out.println("Enter the name of the output file: ");
        String outputName = input.next();


        //Make an input stream for the old file to be read.
        try(
                BufferedInputStream inputStream =
                        new BufferedInputStream(new FileInputStream(inputName));
                ){
            file = inputStream.read();

        }catch (IOException ex){
            System.out.println("File cannot be opened.");
        }

        //Make the file values into a string and convert to an int array.
        fileString = String.valueOf(file);
        int[] intArray = new int[fileString.length()];
        for(int i = 0; i < fileString.length(); i++){
            intArray[i] = fileString.charAt(i) - '0';
        }

        //Create an output stream for the new file to be written.
        try(
                BufferedOutputStream output=
                        new BufferedOutputStream(new FileOutputStream(outputName,false));
                ) {
            for (int c : intArray) {
                c += key;
                output.write(c);
                System.out.println(c);
            }

            }catch(IOException ex){
        }
    }
}
