package TableGame;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Tasos
 */
public class PcTurn { // Class that define which cards will choose
private static PanelMiddle middlePanel = PanelMiddle.getInstance();
   
    private static Random random1;
    private static int a = 0;
    private static ArrayList < Integer > arrayList = new ArrayList < Integer > ();
    public static int[] avalable = new int[40];
    
    public PcTurn() {
        cleanPc(); // Clean lists
        for (int i = 1; i <= middlePanel.getNumberButtons(); i++) { // Put from 1 to max numbers buttons 
            avalable[i] = i;
        }
    }

    public void cleanPc() {
        for (int i = 1; i < 20; i++) { // All posibble buttons
            avalable[i] = 0;
        }
    }

    public void removeList1(int x) {  // Remove the button chooced from first list
        avalable[x] = 0;
    }
    public void removeList2(int y) { // Remove the button chooced from second list
        avalable[y] = 0;
    }

    public int generateListea() { // Find a random number
        random1 = new Random();
        a = random1.nextInt(middlePanel.getNumberButtons()) + 1;  // Find from 1 to max numbers buttons 
        return a;
    }
}