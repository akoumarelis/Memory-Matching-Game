package TableGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Tasos
 */
public class Generate {

    private static Generate instance = new Generate(); // Singleton Desing Pattern
    private static PanelMiddle middlePanel;
    private static Random random1, random2;
    private static ArrayList < Integer > arrayList1 = new ArrayList < Integer > ();
    private static ArrayList < Integer > arrayList2 = new ArrayList < Integer > ();
    private static int a = 0, b = 0;
    
    private Generate() {
        middlePanel = PanelMiddle.getInstance();
    }

    public int Generate1() {
        random1 = new Random();
        while (arrayList1.size() < middlePanel.getNumberButtons()/2) { // Find 6 random numbers and save them in first list array
            a = random1.nextInt(middlePanel.getNumberButtons()/2) + 1; // the number is for 1 to number of cards
            while (!arrayList1.contains(a)) { // Add the random number only once in the array list
                arrayList1.add(a);
                return a;
            }
        }
        return -1;
    }

    public int Generate2() {
        random2 = new Random();
        while (arrayList2.size() < middlePanel.getNumberButtons()/2) { // Find 6 random numbers and save them in first list array
            b = random2.nextInt(middlePanel.getNumberButtons()/2) + 1; // the number is for 1 to number of cards
            while (!arrayList2.contains(b)) { // Add the random number only once in the array list
                arrayList2.add(b);
                return b;
            }
        }
        return -1;
    }

    public void clean() { // Clean the array lists for restart game 
        arrayList1.clear();
        arrayList2.clear();
    }
    
    public static Generate getInstance(){ // Singleton design pattern 
        return instance;
    }

}