package TableGame;

/**
 *
 * @author tasos
 */
public class TableGameModel {
    private String player1Name, pcName ; // Players names
    private int player1Points, pcPoints; // Players points
    private static TableGameModel instance = new TableGameModel(); // Singleton Desing Pattern
    
    private TableGameModel() {
    }
    
    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public void setPlayer1Points(int player1Points) {
        this.player1Points = player1Points;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public int getPcPoints() {
        return pcPoints;
    }

    public void setPcPoints(int pcPoints) {
        this.pcPoints = pcPoints;
    }
    
    public static TableGameModel getInstance(){
        return instance;
    }
}
