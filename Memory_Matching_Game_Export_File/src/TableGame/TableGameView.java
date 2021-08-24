package TableGame;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author tasos
 */ 
public class TableGameView {
    private JFrame frame; 
    private JPanel panelUp, panelMiddle, panelDown, mainPanel;
    private Dimension dim;
    private TableGameModel modelGameTable = TableGameModel.getInstance();
    private static PanelUp upPanel = PanelUp.getInstance(); // Singleton Desing Pattern
    private static PanelMiddle middlePanel = PanelMiddle.getInstance(); // Singleton Desing Pattern
    private static PanelDown downPanel = PanelDown.getInstance(); // Singleton Desing Pattern
    private static TableGameView viewGameTable = new TableGameView(); // Singleton Desing Pattern
    
    private TableGameView(){
        frame = new JFrame(); //creating instance of JFrame  
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        panelUp = new JPanel(); //creating the panel that will be added on jframe with the name of user and computer
        panelMiddle = new JPanel(); //creating the panel that will be added on jframe with the cards (jbuttons)
        panelDown = new JPanel(); //creating the panel that will be added on jframe with close button
        panelUp = upPanel.getPanel();
        panelMiddle = middlePanel.getPanelMiddle();
        panelDown = downPanel.getPanelDown(); 
        
        mainPanel.add(panelUp, BorderLayout.PAGE_START); // We set the panels in main panel
        mainPanel.add(panelMiddle, BorderLayout.CENTER);
        mainPanel.add(panelDown, BorderLayout.PAGE_END);
        
        frame.add(mainPanel);
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width / 2 - 500, dim.height / 2 - frame.getSize().height / 2 - 400); // Show the jframe visible next to menu window
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Stop running if user press exit
        frame.setSize(new Dimension(920, 850));
        frame.setResizable(true); 
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public static TableGameView getInstance(){ // Singleton design pattern 
        return viewGameTable;
    }
    
}
