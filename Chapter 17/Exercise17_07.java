/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <h1>Exercise 17_07</h1>
 *
 * <p>This class will create two loan objects, will put them into a file, will read the file
 * for the objects, and then will total the loans up and give the count of loans.</p>
 *
 * <p>Created 11/18/2021</p>
 *
 * @author Rhett Boatright
 */
import java.io.*;

public class Exercise17_07 {

    /**
     * This method will create two loan objects and write them to a file.
     *
     * @param args (String; placeholder for the main method.)
     *
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);

        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        }
        catch (IOException ex) {
             System.out.println("File could not be opened");
        }
        outputData();
    }

    /**
     * This method will read the file for the loans and will total
     * the amount up as well as count the amount of loans inside of the file.
     */
    public static void outputData(){
        int totalLoan = 0;
        int countLoans = 0;
        try(
                ObjectInputStream input =
                        new ObjectInputStream(new BufferedInputStream(new FileInputStream("Exercise17_07.dat")));
        ){
            while(true){
                Loan loan = (Loan) (input.readObject());
                totalLoan += loan.getLoanAmount();
                countLoans++;


            }
        }catch(EOFException ex){
            System.out.println("Total loan amount: $" + totalLoan
                    + "\n total number of loans: " + countLoans);
        }
        catch(Exception ex){

        }

    }
}