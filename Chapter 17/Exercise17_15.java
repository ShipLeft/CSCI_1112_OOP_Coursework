import java.io.*;
import java.util.Scanner;

/**
 * <h1>Exercise 17_15</h1>
 *
 * <p>This class will decrypt the file of the users choosing
 * and create a new (or write over a) file with the unencrypted data on it.</p>
 *
 * <p>Created: 11/18/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise17_15 {

    /**
     * This method will decrypt the file from 17_14
     * and make a new file with the decrypted data inside.
     *
     * @param args (String; placeholder of the main method)
     */
    public static void main(String[] args){
        int fileNumb = 0;
        String fileString;
        int key = 5;
        Scanner input = new Scanner(System.in);

        //Prompt user to enter file names.
        System.out.println("Enter the name of the input file: ");
        String inputName = input.next();
        System.out.println("Enter the name of the output file: ");
        String outputName = input.next();


        //Create an input stream for the old file to be read.
        try(
                BufferedInputStream inputStream =
                        new BufferedInputStream(new FileInputStream(inputName));
        ){
            fileNumb = inputStream.read();

        }catch (IOException ex){
            System.out.println("File cannot be opened.");
        }

        //Make the string for the values of the file and convert it to an int array.
        fileString = String.valueOf(fileNumb);
        int[] intArray = new int[fileString.length()];
        for(int i = 0; i < fileString.length(); i++){
            intArray[i] = fileString.charAt(i) - '0';
        }

        //Make the output stream for the new file.
        try(
                BufferedOutputStream output=
                        new BufferedOutputStream(new FileOutputStream(outputName,false));
        ) {

            for (int c : intArray) {
                c -= key;
                output.write(c);
            }

        }

        catch(IOException ex){
        }
    }
}
