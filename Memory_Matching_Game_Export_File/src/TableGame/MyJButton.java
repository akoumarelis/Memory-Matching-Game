package TableGame;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Tasos
 */
public class MyJButton extends JButton { // Custom jbutton because we need variables in the jbutton
    private static String backview[] = new String[40]; // Saves the path for back view images
    private static String frontview[] = new String[40]; // Saves the path for front view images
    private boolean isSelected = false;
    private ImageIcon img, img2;
    private int ak = 0, key;
    private static Generate klo = Generate.getInstance();
    private static PanelMiddle middlePanel = PanelMiddle.getInstance();


    public MyJButton(int id) {
        klo = Generate.getInstance();
        if (id == 1) klo.clean(); // Clean the array lists
        if (id < ((middlePanel.getNumberButtons()/2)+1)) { // Find a random number for button id from 1 to number of buttons. Here we find the first half card ids
            ak = klo.Generate1();
        } else if (id < middlePanel.getNumberButtons()) {  // Find a random number for button id from 1 to number of buttons. Here we find the second half card ids
            ak = klo.Generate2();
        } else if (id == middlePanel.getNumberButtons()) { //Find the last  random number and clean the array lists
            ak = klo.Generate2();
            klo.clean();
        }
        key = ak;
        this.setBackground(Color.WHITE);
        frontview[ak] = "/Images/flipped.png";
        img = new ImageIcon(getClass().getResource((frontview[ak])));
        this.setIcon(img);
        backview[id] = "/Images/" + ak + ".png";
        isSelected = false;
    }

    public void SetIsSelected(boolean select) { //Setter for the isSelected of the card
        isSelected = select;
    }

    public boolean GetIsSelected() { //Getter for the isSelected of the card
        return isSelected;
    }

    public int GetId() { //Getter for id of the card
        return key;
    }

    public void back(int f) { // Show the back image of the card
        img2 = new ImageIcon(getClass().getResource((backview[f])));
        this.setIcon(img2);
    }

    public void front(int f) { //deixnei to mprosta tis kartas
        frontview[f] = "/Images/flipped.png";
        img = new ImageIcon(getClass().getResource(frontview[f]));
        this.setIcon(img);
    }
}