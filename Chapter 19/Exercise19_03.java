import java.util.ArrayList;

/**
 * <h1>Exercise 19_03</h1>
 *
 * <p>This class will create an ArrayList, go through the
 * ArrayList to remove duplicate integers, and will print the results. </p>
 *
 * <p>Created: 11/23/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise19_03 {


    /**
     * This method will remove the duplicates in an ArrayList.
     *
     * @param list (ArrayList; list from main method)
     * @param <E> (Generic value; allows ArrayList to pass generic values)
     * @return
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){

        //Add temporary array for the duplicate removal
        ArrayList <E> temp = new ArrayList<>(list.size());

        //Go through list and add all non duplicate numbers to temp
        for(int i = 0; i < list.size(); i++){
            if(!temp.contains(list.get(i))) {
                temp.add(list.get(i));
            }
        }

        return temp;
    }

    /**
     * This method will create a new list to be run
     * through removeDuplicates and print the results.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args) {

        //Create ArrayList to be run through removeDuplicates
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);

        //Run list through removeDuplicates
        ArrayList<Integer> newList = removeDuplicates(list);

        //print results
        System.out.print(newList);
    }
}