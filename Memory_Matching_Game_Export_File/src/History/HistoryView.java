package History;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Tasos
 */
public class HistoryView {
    private static HistoryView instance = new HistoryView(); // Singleton Desing Pattern  
    private static HistoryModel modelHistory; // Set connection with the database
    private JFrame frame; 
    private JPanel panel;
    private JLabel history;
    private JTextArea  textArea; 
    private JButton close;
    private Dimension dim;
    
    private HistoryView(){
        modelHistory = HistoryModel.getInstance();
        frame = new JFrame(); //creating instance of JFrame  
        panel = new JPanel(); //creating the panel that will be added on jframe
        textArea = new JTextArea(10, 20);
        panel.setLayout(null);
        
        history = new JLabel("HISTORY", SwingConstants.CENTER); //Title for the history window
        history.setFont(new Font("Serif", Font.PLAIN, 28)); //Set font for the title
        history.setForeground(Color.WHITE); //Color
        history.setBounds(128, 5, 150, 40); //Set the label to specific location on jpanel
        
        textArea.setBounds(23, 55, 350, 250);
        textArea.setEditable(false); //The user cant write in textfield, only read
        
        close = new JButton("close"); //Close button
        close.setBounds(123, 315, 150, 30);
        close.setForeground(Color.WHITE); //Font color
        close.setBackground(new java.awt.Color(0,102,204)); //Button color
        close.setFont(new Font("Arial", Font.PLAIN, 19));
       
        panel.setBackground(new java.awt.Color(72,72,72)); //J[anel background color with RGB color values
        panel.add(history); //Add to jpanel
        panel.add(textArea);
        panel.add(close);
        
        frame.add(panel); //Add the jpanel to jframe
        frame.setSize(400,400); //Size of jframe
        frame.setResizable(false);
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        //Show the jframe visible next to menu window
        frame.setLocation(dim.width/2-frame.getSize().width/2-350, dim.height/2-frame.getSize().height/2-250);
    }

    public void SetFromModel(){ // Set the history from model
        textArea.setText(modelHistory.getHistory());
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getClose() {
        return close;
    }
    
    public static HistoryView getInstance() {
        return instance;
    }

}