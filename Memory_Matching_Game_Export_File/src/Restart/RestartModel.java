package Restart;

import TableGame.TableGameController;
import Winner.WinnerController;

/**
 *
 * @author Tasos
 */
public class RestartModel {
    private static RestartModel instance = new RestartModel(); // Singleton Desing Pattern
    String rePlay1Name, rePcName; // Player 1 and 2 name
    int reNumButtons; // Number of buttons
    
    
    private  RestartModel() {
        
        
        
        
    }

    public String getRePlay1Name() { //Getters and Setters
        return rePlay1Name;
    }

    public void setRePlay1Name(String rePlay1Name) {
        this.rePlay1Name = rePlay1Name;
    }

    public String getRePcName() {
        return rePcName;
    }

    public void setRePcName(String rePcName) {
        this.rePcName = rePcName;
    }

    public int getReNumButtons() {
        return reNumButtons;
    }

    public void setReNumButtons(int reNumButtons) {
        this.reNumButtons = reNumButtons;
    }

    
    public static RestartModel getInstance(){ // Singleton design pattern
        return instance;
    } 
    
    
    
}
   