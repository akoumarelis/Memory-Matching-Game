package TableGame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Tasos
 */
public class PanelDown {
    private JPanel panel;
    private static PanelDown downPanel = new PanelDown(); // Singleton Desing Pattern
    private JButton close;
    
    
    
    private PanelDown() {
        panel = new JPanel(); //creating the panel that will be added on jframe
        //panel.setLayout(null);
        panel.setBackground(new java.awt.Color(72, 72, 72));

        
        close = new JButton("close"); //Close button
        close.setBounds(420, 220, 150, 30);
        close.setForeground(Color.WHITE); //Font color
        close.setBackground(new java.awt.Color(239,50,50)); //Button color
        close.setFont(new Font("Arial", Font.PLAIN, 19));
        panel.add(close);
    
    }

    public JButton getClose() {
        return close;
    }

    public JPanel getPanelDown() {
        return panel;
    }
    
    
    public static PanelDown getInstance(){ // Singleton design pattern 
        return downPanel;
    }
    
}
