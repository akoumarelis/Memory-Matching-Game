package TableGame;

import TextFile.FileFunctions;
import Menu.MenuView;
import Winner.WinnerModel;
import Winner.WinnerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author tasos
 */
public class TableGameController { //Controller for Table Game Window
    private MenuView viewMenu;
    private TableGameView viewTableGame;
    private TableGameModel modelGameTable;
    private static PanelDown downPanel = PanelDown.getInstance(); // Singleton Desing Pattern
    private static TableGameController instance = new TableGameController(); // Singleton Desing Pattern
    private static WinnerModel modelWinner;
    private static PanelMiddle middlePanel;
    private static WinnerView viewWinner;
    private static PanelUp upPanel;
    private static Generate gene;
    private static PcTurn turn;
    private static FileFunctions functionFile;
    private static MyJButton[] buttons;
    private int numberButtons, player1Points = 0, ComputerPoints = 0;
    private static int ak = 0, a = 0, seira = 0, player = 0, x = 0, y = 0, end = 0, hours, minutes, seconds;


    private static int countime;
    Timer timer;
    ActionListener actListner;

    private TableGameController() {
        middlePanel = PanelMiddle.getInstance();
        viewMenu = MenuView.getInstance();
        viewTableGame = TableGameView.getInstance();
        upPanel = PanelUp.getInstance();
        gene = Generate.getInstance();
        modelGameTable = TableGameModel.getInstance();
        modelWinner = WinnerModel.getInstance();
        viewWinner = WinnerView.getInstance();
        functionFile = FileFunctions .getInstance();
    }

    public void initController() { // Init controller action listeners
        buttons = middlePanel.getButtons(); // Get the array with buttons
        numberButtons = middlePanel.getNumberButtons(); // Get the number of buttons
        downPanel.getClose().addActionListener(new ActionListener() { // If close button pressed, the menu frame show up
            public void actionPerformed(ActionEvent e) {
                viewTableGame.getFrame().setVisible(false);
                viewMenu.getFrame().setVisible(true);
                gene.clean(); // Clean the lists from random numbers
                player1Points = 0; //Set the points to 0
                ComputerPoints = 0;
                modelGameTable.setPlayer1Points(player1Points); // Set the points in model zero
                modelGameTable.setPcPoints(ComputerPoints);
                modelWinner.setName("");
                modelWinner.setPoints("" + 0);
                turn.cleanPc(); // Clean lists
                middlePanel.cleanPanel();
                end = 0; //Set the number of open cards to zero for next game
                timer.stop(); // Stop count the time
                countime = 0; // Put seconds 0 for next game
                seira = 0; // Set zero the turn of whos playing
            }
        });
    }

    public void initActionButtons(MyJButton button[]) { // Action listener for each card button
        turn = new PcTurn();

        actListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                countime += 1; //Count seconds
                hours = countime / 3600; //Convert seconds to hours
                minutes = (countime % 3600) / 60;
                seconds = countime % 60;
                upPanel.getTimeNumber().setText(String.format("    %02d:%02d:%02d", hours, minutes, seconds));
            }
        };
        timer = new Timer(500, actListner); // Repeat the listener to count the time
        timer.start(); //Start the timer

        for (int i = 1; i < middlePanel.getNumberButtons() + 1; i++) {
            final int i2 = i;
            button[i].addActionListener(new ActionListener() { // A actionlistener for every button
                @Override
                public void actionPerformed(ActionEvent e) {
                    Thread t = new Thread(()->{
                        button[i2].back(i2); // Open the button we press
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TableGameController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        switch (ak) { //Depend from ak value we find if one card is pressed or two
                            case 0: // If we chooce zero cards
                                a = i2;
                                button[a].SetIsSelected(true); // Make the cards selected
                                ak++; // Open one card
                                break;
                            case 1: // If we already open a card
                                if (seira % 2 == 0) {
                                    player = 0; // If player is 0 then is player1 turn
                                } else {
                                    player = 1; //If player is 0 then is computer turn
                                }
                                if (i2 == a) { // If we choose the same card
                                    break;
                                }
                                ak = 0; // We have open and second card and set the ak zero for next round  
                                if (button[i2].GetId() == button[a].GetId() && button[i2].GetIsSelected() == false || button[a].GetIsSelected() == false) { //If the cards have the same id but we select only one already
                                    end++;
                                    button[i2].setEnabled(false); // We close the both cards
                                    button[a].setEnabled(false);
                                    seira++; // Next turn will play the other player
                                    turn.removeList1(i2); // Remove the ids from array that computer will choose random
                                    turn.removeList1(a);
                                    switch (player) { // Depend which turn is the skor is saved
                                        case 0:
                                            player1Points += 10; // Player 1 take the points
                                            modelGameTable.setPlayer1Points(player1Points); // Set the points in model class
                                            upPanel.setPlayer1Points(player1Points);
                                            break;
                                        case 1:
                                            ComputerPoints += 10; // Player 2 take the points
                                            modelGameTable.setPcPoints(ComputerPoints); // Set the points in model class
                                            upPanel.setComputerPoints(ComputerPoints);
                                            break;
                                    }
                                    if (end == middlePanel.getNumberButtons() / 2) { // If all cards is open find the winner
                                        if (player1Points > ComputerPoints) { //If player 1 win
                                            modelWinner.setName(modelGameTable.getPlayer1Name()); // set the winner name and points in winner model class
                                            modelWinner.setPoints("" + modelGameTable.getPlayer1Points());
                                        } else if (player1Points < ComputerPoints) { // If computer wins
                                            modelWinner.setName(modelGameTable.getPcName());
                                            modelWinner.setPoints("" + modelGameTable.getPcPoints());
                                        } else { // Draw game
                                            modelWinner.setName("Draw");
                                            modelWinner.setPoints("" + modelGameTable.getPcPoints());
                                        } //Made by Anastasios Koumarelis
                                        timer.stop(); // Stop count the time
                                        hours = countime / 3600; //Convert seconds to hours
                                        minutes = (countime % 3600) / 60;
                                        seconds = countime % 60;
                                        modelWinner.setTime(String.format("%02d:%02d:%02d", hours, minutes, seconds)); // Write the gameplay time of the round
                                        viewWinner.setValues(); //Set the name and the points of the winner
                                        viewWinner.getFrame().setVisible(true);
                                        viewTableGame.getFrame().setVisible(false);
                                        functionFile.writeToFile(); //Write the winner information in the database
                                        /*
                                        Code to write the points and time in the database
                                        */
                                        countime = 0; // Put seconds 0 for next game
                                        end = 0; //Set the number of open cards to zero for next game
                                        player1Points = 0; // Set Player 1 zero points for next game
                                        modelGameTable.setPlayer1Points(player1Points); // Set the points in model class
                                        ComputerPoints = 0; // Set Player 2 zero points for next game
                                        modelGameTable.setPcPoints(ComputerPoints); // Set the points in model class
                                        break;
                                    }
                                    if (seira % 2 != 0) { // If is player2 turn
                                        PcPlay(button);
                                    }
                                    break;
                                }
                                if (button[i2].GetId() == button[a].GetId() && button[i2].GetIsSelected() == true) { // If the cards is the same but one card is already selected
                                    button[i2].front(i2); // Close both cards
                                    button[a].front(a);
                                    button[i2].SetIsSelected(false);
                                    seira++;
                                    if (seira % 2 != 0) { // If is player2 turn
                                        PcPlay(button);
                                        break;
                                    }
                                    break;
                                }

                                if (button[i2].GetId() != button[a].GetId()) // If the cards is different
                                {
                                    button[a].front(a);
                                    button[i2].front(i2);
                                    button[a].SetIsSelected(false);
                                    seira++;
                                    if (seira % 2 != 0) { // If is player2 turn
                                        PcPlay(button);
                                    }
                                    break;
                                }
                        }
                    });
                    t.start();
                }
            });
        }
    }

    private static void PcPlay(MyJButton button[]) { //Function for player2 turn 
        x = turn.generateListea(); // Find two random different numbers
        y = turn.generateListea();
        while (turn.avalable[x] == 0) { // Search that numbers is not the ids from open cards
            x = turn.generateListea();
        }
        while ((turn.avalable[y] == 0) || (x == y)) { // If the computer choose tha same card twice
            y = turn.generateListea(); //Made by Anastasios Koumarelis
        }
        button[x].doClick(); //Press the random cards
        button[y].doClick();
    }

    public static TableGameController getInstance() {
        return instance;
    }
}