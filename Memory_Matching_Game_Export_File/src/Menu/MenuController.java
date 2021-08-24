package Menu;

import About.*;
import TextFile.FileFunctions;
import History.*;
import NewGame.*;
import Restart.RestartModel;
import TableGame.TableGameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tasos
 */

public class MenuController { //Controller for the menu frame
    private MenuView viewMenu;
    private AboutView aboutView;
    private HistoryView viewHistory;
    private NewGameView viewNewGame;
    private RestartModel modelRestart;
    private NewGameController controllerNewGame;
    private TableGameController controllweTableGame;
    private static FileFunctions functionDatabase;
    
    public MenuController() { //Constructor for controller with view objects
        aboutView = AboutView.getInstance();
        viewHistory = HistoryView.getInstance();
        viewNewGame = NewGameView.getInstance();
        viewMenu = MenuView.getInstance();
        modelRestart = RestartModel.getInstance();
        controllerNewGame = NewGameController.getInstance();
        controllweTableGame = TableGameController.getInstance();
        functionDatabase = FileFunctions.getInstance();
    }
    
    public void initController() { // Init controller action listeners
        
        viewMenu.getRestart().addActionListener(new ActionListener() { //Stop running if user press exit button
            public void actionPerformed(ActionEvent e) { 
                   controllerNewGame.setTableGameFrame(modelRestart.getReNumButtons(), 1); // The function get the number of buttons as parameter
                   controllweTableGame.initController();
            } 
        } );
        viewMenu.getExit().addActionListener(new ActionListener() { //Stop running if user press exit button
            public void actionPerformed(ActionEvent e) { 
                viewMenu.getFrame().dispatchEvent(new WindowEvent(viewMenu.getFrame(), WindowEvent.WINDOW_CLOSING));
            } 
        } );
        
        viewMenu.getAbout().addActionListener(new ActionListener() { //About button show the frame with about info
            public void actionPerformed(ActionEvent e) { 
                 aboutView.getFrame().setVisible(true);
            } 
        } );
        
        viewMenu.getShowh().addActionListener(new ActionListener() { //Show history button show the frame with history info
            public void actionPerformed(ActionEvent e) {
                functionDatabase.GetFromFile(); //Read from database the data
                viewHistory.getFrame().setVisible(true);
                viewHistory.SetFromModel(); //Set the history text from model
            } 
        } );
              
        viewMenu.getHideh().addActionListener(new ActionListener() { //Hide history button show the frame with history info
            public void actionPerformed(ActionEvent e) { 
                viewHistory.getFrame().setVisible(false);
                viewHistory.getTextArea().selectAll();
                viewHistory.getTextArea().replaceSelection("");
            } 
        } );
    
        viewMenu.getNewgame().addActionListener(new ActionListener() { //New Game button show the frame with new game frame
            public void actionPerformed(ActionEvent e) { 
                viewNewGame.getFrame().setVisible(true);
                viewMenu.getFrame().setVisible(false);
            } 
        } );
    }   
}