package About;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Tasos
 */
public class AboutView {
    private static AboutView instance = new AboutView(); // Singleton Desing Pattern 
    private JFrame frame; 
    private JPanel panel;
    private JLabel about, textInfo; 
    private JButton close;
    private AboutModel m;
    
    private AboutView(){
        frame = new JFrame(); //creating instance of JFrame  
        panel = new JPanel(); //creating the panel that will be added on jframe
        textInfo = new JLabel(); 
        panel.setLayout(null);
        
        about = new JLabel("ABOUT", SwingConstants.CENTER); //Title for the history window
        about.setFont(new Font("Serif", Font.PLAIN, 28)); //Set font for the title
        about.setForeground(Color.WHITE); //Color
        about.setBounds(128, 5, 150, 40); //Set the label to specific location on jpanel
         
        textInfo.setBounds(23, 5, 350, 250); //Jlabel with text info
        textInfo.setFont(new Font("Serif", Font.PLAIN, 19)); 
        textInfo.setForeground(Color.WHITE);
        
        close = new JButton("close"); //Close button
        close.setBounds(123, 315, 150, 30);
        close.setForeground(Color.WHITE); //Font color
        close.setBackground(new java.awt.Color(0,102,204)); //Button color
        close.setFont(new Font("Arial", Font.PLAIN, 19));
       
        panel.setBackground(new java.awt.Color(72,72,72)); //J[anel background color with RGB color values
        panel.add(about); //Add to jpanel
        panel.add(textInfo);
        panel.add(close);
        
        frame.add(panel); //Add the jpanel to jframe
        frame.setSize(400,400); //Size of jframe
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //Show the jframe visible next to menu window
        frame.setLocation(dim.width/2-frame.getSize().width/2-350, dim.height/2-frame.getSize().height/2+150);
    }

    public JLabel getAbout() {
        return about;
    }

    public void setAbout(JLabel about) {
        this.about = about;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getClose() {
        return close;
    }
    
    public JLabel getTextInfo() {
        return textInfo;
    }
    
    public static AboutView getInstance() {
        return instance;
    }
}