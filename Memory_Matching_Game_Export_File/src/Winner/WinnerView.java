package Winner;

import Menu.MenuView;
import TableGame.PanelMiddle;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Tasos
 */
public class WinnerView {
    private JFrame frame; 
    private JPanel panel;
    private JLabel winnerTitle, nameTitle, pointsTitle, name, points, timeTitle, time; 
    private JButton close;
    private WinnerModel m;
    private Dimension dim;
    private static WinnerView instance = new WinnerView(); // Singleton Desing Pattern
    private static WinnerModel modelWinner;
    
    private WinnerView(){
        modelWinner = WinnerModel.getInstance();
        frame = new JFrame(); //creating instance of JFrame  
        panel = new JPanel(); //creating the panel that will be added on jframe
        nameTitle = new JLabel(); 
        panel.setLayout(null);
        
        winnerTitle = new JLabel("Winner"); //Winner title in jlabel
        jlabelsProperties(panel, winnerTitle, 135, 5, 120, 40, 40); //Set the position of the Winner jlabel
        
        nameTitle = new JLabel("Name:"); //Name title in jlabel
        jlabelsProperties(panel, nameTitle, 10, 55, 120, 40, 32); //Set the position of the Name jlabel
        
        name = new JLabel(); //Name of the winner
        jlabelsProperties(panel, name, 140, 55, 120, 40, 32); //Set the position of the Name jlabel
        
        pointsTitle = new JLabel("Points:"); //Points title in jlabel
        jlabelsProperties(panel, pointsTitle, 10, 100, 120, 40, 32); //Set the position of the Points jlabel
        
        points = new JLabel(); //Points of the winner
        jlabelsProperties(panel, points, 140, 100, 120, 40, 32); //Set the position of the Name jlabel     
                
        timeTitle = new JLabel("Time:"); //Points title in jlabel
        jlabelsProperties(panel, timeTitle, 10, 150, 120, 40, 32); //Set the position of the Points jlabel
                
        time = new JLabel(); //The time of the round
        jlabelsProperties(panel, time, 140, 150, 170, 40, 32); //Set the position of the time jlabel
                
        close = new JButton("close"); //Close button
        close.setBounds(123, 315, 150, 30);
        close.setForeground(Color.WHITE); //Font color
        close.setBackground(new java.awt.Color(0,102,204)); //Button color
        close.setFont(new Font("Arial", Font.PLAIN, 19));
       
        panel.setBackground(new java.awt.Color(72,72,72)); //J[anel background color with RGB color values
        panel.add(close);
        
        frame.add(panel); //Add the jpanel to jframe
        frame.setSize(400,400); //Size of jframe
        frame.setResizable(false);
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        //Show the jframe visible next to menu window
        frame.setLocation(dim.width/2-frame.getSize().width/2-350, dim.height/2-frame.getSize().height/2+150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Stop running if user press exit
    }
    
    public void setValues(){ //Set the name and the points of the winner
         name.setText(modelWinner.getName());
         points.setText(modelWinner.getPoints());
         time.setText(modelWinner.getTime());
    }
   
    public JFrame getFrame() {
        return frame;
    }

    public JButton getClose() {
        return close;
    }
    
    private void jlabelsProperties(JPanel panel, JLabel jlabel, int b1, int b2, int b3, int b4, int x){ //Fuction for jlabels setting properties
        jlabel.setBounds(b1, b2, b3, b4); //Set position of jlabel
        jlabel.setFont(new Font("Serif", Font.PLAIN, x)); //Set font size of JLabel
        jlabel.setForeground(Color.WHITE);
        panel.add(jlabel);
    }
    
    public static WinnerView getInstance(){ //Sigleton pattern
        return instance;
    }
}