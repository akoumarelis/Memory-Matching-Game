package Winner;

import Menu.MenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tasos
 */
public class WinnerController {
    private static WinnerController instance = new WinnerController(); // Singleton Desing Pattern
    private static WinnerView viewWinner;
    private MenuView mv;
    
    private  WinnerController() {
        viewWinner = WinnerView.getInstance();
        mv = MenuView.getInstance();
    }
     
    public void initController() { // Init controller action listeners
        
        viewWinner.getClose().addActionListener(new ActionListener() { // If close button pressed, the menu frame show up
                public void actionPerformed(ActionEvent e) { 
                    viewWinner.getFrame().setVisible(false);
                    mv.getFrame().setVisible(true);
                } 
            } ); 
    }
      
    public static WinnerController getInstance(){ //Sigleton pattern
        return instance;
    }
}
