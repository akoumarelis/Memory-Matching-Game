package History;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tasos
 */
public class HistoryController { //Controller for the history frame
    private HistoryView v;
    private HistoryModel m;
    
    public HistoryController(HistoryModel m1,HistoryView v1) { //Constructor for Controller with model and view objects   
        v = v1;
        m = m1;
    }
    
    public void initController() { //Set history frame invisible if user press close button
        
       v.getClose().addActionListener(new ActionListener() { //If close button pressed
            public void actionPerformed(ActionEvent e) { 
                v.getFrame().setVisible(false);
            } 
        } ); 
    }   
    
    public void showHistory() { //Set history frame visible
       v.getFrame().setVisible(true);
    }   
     
    public void hideHistory() { //Set history frame invisible
       v.getFrame().setVisible(false);  
    }   
}