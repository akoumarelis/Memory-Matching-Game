package History;

/**
 *
 * @author Tasos
 */
public class HistoryModel {
    private static HistoryModel instance = new HistoryModel(); // Singleton Desing Pattern  
    private String history; //String history for textfield GUI

    public HistoryModel() {
    }
    public String getHistory() { //Getter for history string
        return history;
    }

    public void setHistory(String history) { //Setter for history string
        this.history = history;
    }
    
    public static HistoryModel getInstance() {
        return instance;
    }

}
