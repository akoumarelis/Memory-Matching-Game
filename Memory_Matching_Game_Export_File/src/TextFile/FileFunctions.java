package TextFile;

import History.HistoryModel;
import History.HistoryView;
import Winner.WinnerModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tasos
 */
public class FileFunctions implements  DAOInterface {
    private static FileFunctions instance = new FileFunctions(); // Singleton Desing Pattern  
    private static WinnerModel modelWinner; // Get the data from the winner model
    private static HistoryModel modelHistory; // Set the history string
    private static HistoryView viewHistory; 
    private File file; 
    FileWriter fileWriter;
    Scanner reader;
    private String oldData; 
    private int id = 0;

    private FileFunctions() {
        modelWinner = WinnerModel.getInstance();
        modelHistory = HistoryModel.getInstance();
        viewHistory = HistoryView.getInstance();
        file = new File("History.txt"); //Create the file 
    }

    @Override
    public void writeToFile() {   //Write the history to file      
        try { //Write in the file
            fileWriter = new FileWriter("History.txt");
            if(oldData==null){
                oldData = "Winner: " + modelWinner.getName() + " Points: " + modelWinner.getPoints() + " Time: " + modelWinner.getTime() + "\n";
            } else {
                oldData = oldData + "Winner: " + modelWinner.getName() + " Points: " + modelWinner.getPoints() + " Time: " + modelWinner.getTime() + "\n";
            }
            fileWriter.write(oldData);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred at write file.");
            e.printStackTrace();
        }
  }

    @Override
    public void GetFromFile() {  // Get data from file
        viewHistory.getTextArea().setText(null);
        modelHistory.setHistory(null);
        try {
            reader = new Scanner(file);
        while (reader.hasNextLine()) { //Read from file line by line
            String line = reader.nextLine();
            if(modelHistory.getHistory() == null){ // If we get data first time from file
                modelHistory.setHistory("\n" + line); // Create the history informationn from file
            } else{
                modelHistory.setHistory(modelHistory.getHistory() + "\n" + line); // Create the history informationn from line
            }
        }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred at read file.");
            e.printStackTrace();
        }
    }

    public static FileFunctions getInstance() {
        return instance;
    }

    @Override
    public void cleanTheFile() { // Delete all data from table
        oldData = null;
        try {
            fileWriter = new FileWriter("History.txt");
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FileFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
}
