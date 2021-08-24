package NewGame;

/**
 *
 * @author Tasos
 */
public class NewGameModel {
    private String player1, computer2; // Players names
    private static NewGameModel instance = new NewGameModel(); // Singleton Desing Pattern

    private NewGameModel() {
    }

    public String getComputer2() {
        return computer2;
    }

    public void setComputer2(String computer2) {
        this.computer2 = computer2;
    }
    
    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

  
    public static NewGameModel getInstance(){ // Singleton design pattern 
        return instance;
    }
}
