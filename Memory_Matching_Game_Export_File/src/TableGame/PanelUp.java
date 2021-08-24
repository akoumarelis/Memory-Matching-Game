package TableGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Tasos
 */
public class PanelUp {
    private JPanel panelAll, panelUser, panelComp, panelTime;
    private JLabel player1Title, player1NameTitle, player1PointsTitle, player1Name, player1Points, computerTitle, computerNameTitle, computerPointsTitle, computerName, computerPoints, timeTitle, timeNumber, null1, null2, null3; 
    private TableGameModel modelGameTable = TableGameModel.getInstance();
    private static PanelUp instance = new PanelUp(); // Singleton Desing Pattern
    
    private PanelUp() { 
        panelAll = new JPanel(); // creating the panel that will have all the other panel on
        panelUser = new JPanel(); // Panel for player 1 informations
        panelComp = new JPanel(); // Panel for time informations
        panelTime = new JPanel(); // Panel for player 2 informations

        panelAll.setBackground(new java.awt.Color(72, 72, 72)); //  Set same color for all panels
        panelUser.setBackground(new java.awt.Color(72, 72, 72));
        panelTime.setBackground(new java.awt.Color(72, 72, 72));
        panelComp.setBackground(new java.awt.Color(72, 72, 72));
       
        
        panelUser.setLayout(new GridLayout(3, 2)); //Set layouts for panels
        panelTime.setLayout(new GridLayout(3, 0));
        panelComp.setLayout(new GridLayout(3, 2));
        panelAll.setLayout(new GridLayout(0, 3));
        
        
        //Player 1 panel
        player1Title = new JLabel("Player 1"); // Player 1 title jlabel
        jlabelsProperties(panelUser, player1Title, 40); // Set the position of the Player 1 jlabel
        null1 = new JLabel(" ");
        panelUser.add(null1);
        player1NameTitle = new JLabel("Name:"); // Player 1 Name title jlabel
        jlabelsProperties(panelUser, player1NameTitle, 30); // Set the position of the Player 1 Name jlabel
        player1Name  = new JLabel(modelGameTable.getPlayer1Name()); // Player 1 Name jlabel
        jlabelsProperties(panelUser, this.player1Name, 30); // Set the position of the Player 1 Name jlabel
        player1PointsTitle = new JLabel("Points:"); // Player 1 Points title jlabel
        jlabelsProperties(panelUser, player1PointsTitle, 30); // Set the position of the Player 1 Points jlabel
        player1Points = new JLabel("" + modelGameTable.getPlayer1Points()); // Player 1 Name jlabel
        jlabelsProperties(panelUser, player1Points, 30); // Set the position of the Player 1 Name jlabel  
        panelAll.add(panelUser);
        
        //Time panel
        timeTitle = new JLabel("   Time"); // Time title in jlabel
        jlabelsProperties(panelTime, timeTitle, 40); // Set the position of the Time jlabel   
        timeNumber = new JLabel();        
        jlabelsProperties(panelTime, timeNumber, 30); // Set the position of the Time jlabel
        null2 = new JLabel(" ");
        panelTime.add(null2);
        panelAll.add(panelTime);

        //Player 2 panel
        computerTitle = new JLabel("Player 2"); // Player 2 title jlabel
        jlabelsProperties(panelComp, computerTitle, 40); // Set the position of the Player 1 jlabel
        null3 = new JLabel(" ");
        panelComp.add(null3);
        computerNameTitle = new JLabel("Name:"); // Player 2 Name title jlabel
        jlabelsProperties(panelComp, computerNameTitle, 30); // Set the position of the Player 1 Name jlabel
        computerName = new JLabel(modelGameTable.getPcName()); // Player 2 Name jlabel
        jlabelsProperties(panelComp, computerName, 30);
        computerPointsTitle = new JLabel("Points:"); // Player 2 Points title jlabel
        jlabelsProperties(panelComp, computerPointsTitle, 30); // Set the position of the Player 1 Points jlabel
        computerPoints = new JLabel("" + modelGameTable.getPcPoints()); // Player 1 Name jlabel
        jlabelsProperties(panelComp, computerPoints, 30); // Set the position of the Player 1 Name jlabel
        panelAll.add(panelComp);
        
    }

    public void setPlayer1Points(int Points) { // Set the player 1 points
        this.player1Points.setText("" + Points); 
    }

    public void setComputerPoints(int Points) { // Set the player 2 points
        this.computerPoints.setText("" + Points); 
    }

    public JLabel getPlayer1Points() {
        return player1Points;
    }

    public JLabel getComputerPoints() {
        return computerPoints;
    }

    public JPanel getPanel() {
        return panelAll;
    }
    
    public static PanelUp getInstance(){ // Singleton design pattern 
        return instance;
    }
    
    public void setPlayer1Name(String plaName) { // Set player name from jtextfiel in new game frame
        player1Name.setText(plaName);
    }

    public void setComputerName(String compName) {  // Set computer name from jtextfiel in new game frame
        computerName.setText(compName); 
    }
    
    public void setTimeNumber(JLabel timeNumber) {
        this.timeNumber = timeNumber;
    }

    public JLabel getTimeNumber() {
        return timeNumber;
    }
    
    private void jlabelsProperties(JPanel panel, JLabel jlabel, int x){ // Fuction for jlabels setting properties
        jlabel.setFont(new Font("Serif", Font.PLAIN, x)); // Set font size of JLabel
        jlabel.setForeground(Color.WHITE);
        panel.add(jlabel);
    }
    
}
