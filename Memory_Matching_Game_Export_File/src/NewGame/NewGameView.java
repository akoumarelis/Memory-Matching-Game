package NewGame;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Tasos
 */
public class NewGameView {
    private JFrame frame; 
    private JPanel panel;
    private JLabel newgame, names, player1, player2, DiffLevel;
    private JButton close, easy, normal, hard;
    private Dimension dim;
    private JTextField nameUser, namePc; 
    private static NewGameView viewNewGame = new NewGameView(); // Singleton Desing Pattern
    
    private NewGameView() {
             
        frame = new JFrame();//creating instance of JFrame  
        panel = new JPanel();
        
        newgame = new JLabel("New Game"); //Menu title in jlabel
        jlabelsProperties(panel, newgame, 203, 5, 350, 40, 33); //Set the position of the jlabel
       
        names = new JLabel("Names:"); //Names title in jlabel
        jlabelsProperties(panel, names, 10, 35, 350, 40, 26); //Set the position of the jlabel
        
        player1 = new JLabel("Player 1:"); // Player 1 title in jlabel
        jlabelsProperties(panel, player1, 10, 75, 350, 40, 25); //Set the position of the jlabel
       
        player2 = new JLabel("Player 2 / Computer:"); // Player 2 title in jlabel
        jlabelsProperties(panel, player2, 10, 155, 350, 40, 25); //Set the position of the jlabel
        
        nameUser = new JTextField(13); // create a object of JTextField with 13 columns for the name of the user
        JTextFieldProperties(panel, nameUser, 10, 115, 250, 40, 21); //Set the position of the JTextField
        
        namePc = new JTextField(13); // create a object of JTextField with 13 columns for the name of the computer
        JTextFieldProperties(panel, namePc, 10, 195, 250, 40, 21); //Set the position of the JTextField
        
        DiffLevel = new JLabel("Difficulty Level:"); // Difficulty Level title in jlabel
        jlabelsProperties(panel, DiffLevel, 10, 245, 350, 40, 26); //Set the position of the jlabel
        
        easy = new JButton("4X3"); //Create Easy button
        buttonsProperties(panel, easy, 30, 300, 145, 90); //Set the position of the Easy button    
        easy.setBackground(new java.awt.Color(0,110,0)); //Color with RGB value
        
        normal = new JButton("4X4"); //Create Normal button
        buttonsProperties(panel, normal, 200, 300, 145, 90); //Set the position of the Normal button        
        normal.setBackground(new java.awt.Color(200,200,0)); //Color with RGB value
        
        hard = new JButton("4X5"); //Create Hard button
        buttonsProperties(panel, hard, 370, 300, 145, 90); //Set the position of the Hard button        
        hard.setBackground(new java.awt.Color(150,0,0)); //Color with RGB value
        
        close = new JButton("close"); //Close button
        close.setBounds(200, 425, 150, 30);
        close.setForeground(Color.WHITE); //Font color
        close.setBackground(new java.awt.Color(0,102,204)); //Button color
        close.setFont(new Font("Arial", Font.PLAIN, 19));
        
        panel.add(close);
        panel.setBackground(new java.awt.Color(72,72,72));
        panel.setLayout(null);
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width / 2 - 160, dim.height / 2 - frame.getSize().height / 2 - 260); // Show the jframe visible next to menu window
        
        frame.add(panel); //Add panel in jframe
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Stop running if user press exit
        frame.pack();
        frame.setSize(550,500); //Set frame size
        frame.setResizable(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getClose() {
        return close;
    }

    public JButton getEasy() {
        return easy;
    }

    public JButton getNormal() {
        return normal;
    }

    public JButton getHard() {
        return hard;
    }

    public JTextField getNameUser() {
        return nameUser;
    }

    public JTextField getNamePc() {
        return namePc;
    }
    
    public static NewGameView getInstance(){
        return viewNewGame;
    }
      
    private void jlabelsProperties(JPanel panel, JLabel jlabel, int b1, int b2, int b3, int b4, int x){ //Fuction for jlabels setting properties
        jlabel.setBounds(b1, b2, b3, b4); //Set position of jlabel
        jlabel.setFont(new Font("Serif", Font.PLAIN, x)); //Set font size of JLabel
        jlabel.setForeground(Color.WHITE);
        panel.add(jlabel);
    }
    
    private void JTextFieldProperties(JPanel panel, JTextField jtext, int b1, int b2, int b3, int b4, int x){ //Fuction for JTextFields setting properties
        jtext.setBounds(b1, b2, b3, b4); //Set position of jlabel
        jtext.setFont(new Font("Serif", Font.PLAIN, x)); //Set font size of JLabel
        jtext.setSelectedTextColor(Color.black); //Set blck color for the letters
        panel.add(jtext);
    }
    
    private void buttonsProperties(JPanel panel, JButton button, int b1, int b2, int b3, int b4){ //Fuction for jbuttons setting properties
        button.setBounds(b1, b2, b3, b4);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 19));
        panel.add(button);
    }
}
