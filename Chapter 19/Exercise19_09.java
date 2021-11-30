import java.util.ArrayList;

/**
 * <h1>Exercise19_09</h1>
 *
 * <p>This Class will sort an ArrayList and print it out into the console</p>
 *
 * <p>Created: 11/30/2021</p>
 *
 * @author Rhett Boatright
 */
public class Exercise19_09 {

    /**
     * This method will sort a given Array list.
     *
     * @param list (ArrayList; This is a list from the main method)
     * @param <E> (Generic value; allows ArrayList to pass generic values)
     */
    public static <E extends Comparable<E>> void sort(ArrayList<E> list){

        //Set the variables to be used in the sort
        E min;
        int currentMinI;

        //For loop to hold one value
        for(int i = 0; i < list.size() - 1; i++){
            min = list.get(i); //find the minimum of list ArrayList.
            currentMinI = i;

            //For loop to hold another value and compare it to the first value held
            for(int j = i + 1; j<list.size(); j++){
                if(min.compareTo(list.get(j)) > 0){
                    min = list.get(j); //Compare to next number to find the minimum.
                    currentMinI = j;
                }
            }

            //Swap the old min for the new min if needed
            if(currentMinI != i){
                list.set(currentMinI, list.get(i));
                list.set(i, min);
            }
        }
    }

    /**
     * This method will create an ArrayList and will call upon sort
     * to sort the list. It will also print out the sorted ArrayList.
     *
     * @param args (String; Placeholder for the main method.
     */
    public static void main(String[] args) {

        //Make a new Array list and fill it with Integers
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(4);
        list.add(42);
        list.add(5);

        //Sort the list
        Exercise19_09.<Integer>sort(list);

        //print out the list that has now been sorted
        System.out.print(list);
    }

}

