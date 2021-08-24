package Menu;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Tasos
 */
public class MenuView {
    private JFrame frame; 
    private JPanel panel;
    private JLabel menu, game, options, history, help;
    private JButton newgame, restart, exit, showh, hideh, about;
    private static MenuView instance = new MenuView(); // Singleton Desing Pattern
    
    private MenuView(){
             
        frame = new JFrame();//creating instance of JFrame  
        panel = new JPanel();
        
        menu = new JLabel("MENU"); //Menu title in jlabel
        jlabelsProperties(panel, menu, 98, 5, 150, 40, 33); //Set the position of the menu jlabel

        menu = new JLabel("Game:"); //Game title in jlabel
        jlabelsProperties(panel, menu, 10, 32, 120, 40, 27); //Set the position of the Game jlabel
        
        newgame = new JButton("New Game"); //Create New Game button
        buttonsProperties(panel, newgame, 73, 86, 150, 50); //Set the position of the  New Game button

        restart = new JButton("Restart"); //Create Restart button
        buttonsProperties(panel, restart, 73, 146, 150, 50); //Set the position of the  Restart button
        
        exit = new JButton("Exit"); //Create Exit button
        buttonsProperties(panel, exit, 73, 206, 150, 50); //Set the position of the Exit button

        options = new JLabel("Options"); //Options title in jlabel
        jlabelsProperties(panel, options, 10, 265, 120, 40, 27); //Set the position of the Options jlabel
        
        history = new JLabel("History:"); //History title in jlabel
        jlabelsProperties(panel, history, 10, 295, 120, 40, 22); //Set the position of the History jlabel
        
        showh = new JButton("Show History"); //Create Show History button
        buttonsProperties(panel, showh, 73, 340, 150, 50); //Set the position of the Show History button
        
        hideh = new JButton("Hide History"); //Create Hide History button
        buttonsProperties(panel, hideh, 73, 400, 150, 50); //Set the position of the Hide History button
        
        help = new JLabel("Help:"); //Help title in jlabel
        jlabelsProperties(panel, help, 10, 445, 120, 40, 27); //Set the position of the Help jlabel
        
        about = new JButton("About"); //Create About button
        buttonsProperties(panel, about, 73, 492, 150, 50); //Set the position of the About button
        
        panel.setBackground(new java.awt.Color(72,72,72));
        panel.setLayout(null);
        
        frame.add(panel); //Add panel in jframe
        frame.pack();
        frame.setSize(290,600); //Set frame size
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Stop running if user press exit
        frame.setVisible(true);//making the frame visible 
    }

    public JButton getNewgame() { //Setters and Getters
        return newgame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getRestart() {
        return restart;
    }

    public JButton getExit() {
        return exit;
    }

    public JButton getShowh() {
        return showh;
    }

    public JButton getHideh() {
        return hideh;
    }

    public JButton getAbout() {
        return about;
    }
    
    public static MenuView getInstance(){
        return instance;
    }
    
    
    private void jlabelsProperties(JPanel panel, JLabel jlabel, int b1, int b2, int b3, int b4, int x){ //Fuction for jlabels setting properties
        jlabel.setBounds(b1, b2, b3, b4); //Set position of jlabel
        jlabel.setFont(new Font("Serif", Font.PLAIN, x)); //Set font size of JLabel
        jlabel.setForeground(Color.WHITE);
        panel.add(jlabel);
    }
    
    private void buttonsProperties(JPanel panel, JButton button, int b1, int b2, int b3, int b4){ //Fuction for jbuttons setting properties
        button.setBounds(b1, b2, b3, b4);
        button.setForeground(Color.WHITE);
        button.setBackground(new java.awt.Color(0,102,204)); //Color with RGB value
        button.setFont(new Font("Arial", Font.PLAIN, 19));
        panel.add(button);
    }
    
}