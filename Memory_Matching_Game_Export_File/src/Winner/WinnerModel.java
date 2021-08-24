package Winner;

/**
 *
 * @author Tasos
 */
public class WinnerModel {
    private static WinnerModel instance = new WinnerModel(); // Singleton Desing Pattern
    private String name, points, time; // Strings for winner informations

    private WinnerModel() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
    
    public static WinnerModel getInstance(){ //Sigleton pattern
        return instance;
    }
}
