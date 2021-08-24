package NewGame;

import Menu.*;
import Restart.RestartModel;
import TableGame.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tasos
 */
public class NewGameController { //Controller for the new game frame
    private static NewGameController instance = new NewGameController(); // Singleton Desing Pattern
    private MenuView viewMenu;
    private TableGameModel modelTableGame;
    private TableGameView viewTableGame;
    private NewGameView viewNewGame;
    private NewGameModel modelGameNew;
    private static PanelUp upPanel; // Singleton Desing Pattern
    private static PanelMiddle middlePanel;
    private static TableGameController controllweTableGame;
    private static RestartModel modelRestart;

    private NewGameController() {
        viewMenu = MenuView.getInstance();
        modelTableGame = TableGameModel.getInstance();
        viewNewGame = NewGameView.getInstance();
        modelGameNew = NewGameModel.getInstance();
        upPanel = PanelUp.getInstance();
        middlePanel = PanelMiddle.getInstance();
        viewTableGame = TableGameView.getInstance();
        controllweTableGame = TableGameController.getInstance();
        modelRestart = RestartModel.getInstance();
    }
     
    public void initController() { // Init controller action listeners
        
        viewNewGame.getClose().addActionListener(new ActionListener() { // If close button pressed, the menu frame show up
            public void actionPerformed(ActionEvent e) { 
                viewNewGame.getFrame().setVisible(false);
                viewMenu.getFrame().setVisible(true);
            } 
        } ); 
        
        viewNewGame.getEasy().addActionListener(new ActionListener() { // If close button pressed, the menu frame show up
                public void actionPerformed(ActionEvent e) { 
                   setTableGameFrame(12, 0); // The function get the number of buttons as parameter
                   controllweTableGame.initController();
                } 
            } ); 
    
        viewNewGame.getNormal().addActionListener(new ActionListener() { // If close button pressed, the menu frame show up
                public void actionPerformed(ActionEvent e) { 
                   setTableGameFrame(16, 0); // The function get the number of buttons as parameter
                   controllweTableGame.initController();
                } 
            } ); 
        
        viewNewGame.getHard().addActionListener(new ActionListener() { // If close button pressed, the menu frame show up
                public void actionPerformed(ActionEvent e) { 
                   setTableGameFrame(20, 0); // The function get the number of buttons as parameter
                   controllweTableGame.initController();
                } 
            } ); 
    }
    
    public void setTableGameFrame(int numberOfButtons, int i){ // Function for table game frame setup, if i=0 then tha game is played first time or if is 1 the game is from restart button
        viewNewGame.getFrame().setVisible(false);
        modelGameNew.setPlayer1(viewNewGame.getNameUser().getText()); // Set the the user name from JTextField and save the name in the class model new game 
        middlePanel.cleanPanel(); // Clean the panel to make sure that the right number of button will add on the panel
        middlePanel.setNumberButtons(numberOfButtons); // Set the number of buttons in middle panel
        modelRestart.setReNumButtons(numberOfButtons); // Set number of buttons for restart game
        middlePanel.setupPanel(); // Set the layout, color and buttons on the panel
        modelGameNew.setComputer2(viewNewGame.getNamePc().getText());// Set the the user name from JTextField and save the name in the class model new game 
        viewNewGame.getNameUser().setText(null); // Clean the user name jtextfield
        viewNewGame.getNamePc().setText(null); // Clean the computer name jtextfield
        modelTableGame.setPlayer1Points(0); //Set points to zero
        modelTableGame.setPcPoints(0);
        if(i==0){ // If game is played for first time
            modelTableGame.setPlayer1Name(modelGameNew.getPlayer1()); // Get the name of user from class model new game  and save the name in the class model table game
            modelTableGame.setPcName(modelGameNew.getComputer2()); // Get the name of computer from class model new game  and save the name in the class model table game
            modelRestart.setRePcName(modelGameNew.getComputer2()); //Set pc name for restart
            modelRestart.setRePlay1Name(modelGameNew.getPlayer1()); // Set player 1 name for restart
        } else{ // If game is from restart
            modelTableGame.setPlayer1Name(modelRestart.getRePlay1Name()); // Get the name of user from class model restart  and save the name in the class model table game
            modelTableGame.setPcName(modelRestart.getRePcName()); // Get the name of computer from class model restart and save the name in the class model table game             
        }
        upPanel.setPlayer1Name(modelTableGame.getPlayer1Name()); // Get the user name from class model table game and set it to jlabel from upPanel class table game
        upPanel.setComputerName(modelTableGame.getPcName()); // Get the pc name from class model table game and set it to jlabel from upPanel class table game
        upPanel.setComputerPoints(modelTableGame.getPcPoints());
        upPanel.setPlayer1Points(modelTableGame.getPlayer1Points());
        viewTableGame.getFrame().setVisible(true); //Show the frame
    }
    
    public static NewGameController getInstance(){ // Singleton design pattern 
        return instance;
    }
 }
