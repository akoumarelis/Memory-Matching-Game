package TableGame;

import NewGame.NewGameModel;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Tasos
 */

public class PanelMiddle {
    private JPanel panel;
    private int NumberButtons; // Number of buttons
    private static MyJButton[] buttons = new MyJButton[21]; // Array of jbuttons
    private static PanelMiddle instance = new PanelMiddle(); // Singleton Desing Pattern
    private static TableGameController controllweTableGame = TableGameController.getInstance();
    
    private PanelMiddle() {
        panel = new JPanel(); //creating the panel that will be added on jframe
    }

    public void cleanPanel(){ //Clean the panel 
        panel.removeAll(); 
        NumberButtons=0;
        Arrays.fill(buttons, null);
    }
    
    public void setupPanel(){ // Set the layout, color and buttons on the panel
        if(NumberButtons == 12){ //Create the layout of the panel for adding the jbuttons
            panel.setLayout(new GridLayout(4, 3)); // Easy level (12 buttons 4*3)
        } else if(NumberButtons == 16){
            panel.setLayout(new GridLayout(4, 4)); //Normal level (16 buttons 4*4)
        }else{
            panel.setLayout(new GridLayout(4, 5)); // Hard level (20 buttons 4*5)
        }
        panel.setBackground(new java.awt.Color(72, 72, 72)); // Set background color
       
             
        for(int i =1; i < NumberButtons+1; i++){
            buttons[i] = new MyJButton(i);
            panel.add(buttons[i]);
        }
        controllweTableGame.initActionButtons(buttons);
    }
    
    public int getNumberButtons() {
        return NumberButtons;
    }

    public void setNumberButtons(int NumberButtons) {
        this.NumberButtons = NumberButtons;
    }

    public JPanel getPanelMiddle() {
        return panel;
    }
    
    public static PanelMiddle getInstance(){ // Singleton design pattern 
        return instance;
    }
    
    public static MyJButton[] getButtons() { // Get the array with buttons
        return buttons;
    }
    
}