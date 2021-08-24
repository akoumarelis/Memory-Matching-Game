package Main;

import About.*;
import TextFile.FileFunctions;
import History.*;
import Menu.*;
import NewGame.*;
import Restart.RestartModel;
import TableGame.*;
import Winner.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tasos
 */
public class Main { //Made by Anastasios Koumarelis

    /**
     * @param args the command line arguments
     */
     private static MenuView viewMenu;
     private static HistoryModel modelHistory;
     private static HistoryView viewHistory;
     private static HistoryController controllerHistory;
     private static AboutModel modelAbout;
     private static AboutView viewAbout;
     private static AboutController controllerAbout;
     private static NewGameView viewNewGame;
     private static NewGameController controllerNewGame;
     private static TableGameController controllweTableGame;
     private static MenuController controllerMenu; 
     private static WinnerModel modelWinner;
     private static WinnerView viewWinner;
     private static WinnerController controllerWinner;
     private static RestartModel modelRestart;
     private static FileFunctions functionDatabase;
            
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
        functionDatabase = FileFunctions.getInstance(); // Database functions
        functionDatabase.cleanTheFile(); // Delete all the data from the database
        viewMenu = MenuView.getInstance(); // mv mean Menu View object and this constructor show the menu to user. Sigleton desing patter is used.
        modelHistory = new HistoryModel(); // Create history model object
        viewHistory = HistoryView.getInstance(); // Create history view object with the frame and the panel on
        controllerHistory = new HistoryController(modelHistory, viewHistory); // Create history controller object with model and view instances parameters for getters
        controllerHistory.initController(); // Setup close button actionlistener
        
        modelAbout = new AboutModel(); // Create About model object 
        viewAbout = AboutView.getInstance(); // Create About view object with the frame and the panel on
        controllerAbout = new AboutController(modelAbout, viewAbout); // Create About controller object with model and view instances parameters for getters
        controllerAbout.initController(); // Setup close button actionlistener
       
        viewNewGame = NewGameView.getInstance(); // mv mean New Game View object and this constructor show the new game window to user. Sigleton desing patter is used.
        controllerNewGame = NewGameController.getInstance();// Create About view object with the frame and the panel on
        controllerNewGame.initController(); // Setup buttons actionlisteners
     
        controllweTableGame  = TableGameController.getInstance(); // Create table game controller and is called once from frame. Next time will call from new game controller.
        controllweTableGame.initController(); // Setup buttons actionlisteners 
        
        controllerMenu = new MenuController(); // Create Menu controller object
        controllerMenu.initController(); // Setup all the actionlisters for all the button in the menu game
          
        controllerWinner = WinnerController.getInstance(); 
        controllerWinner.initController(); // Setup the actionlistener for the close button
}
}