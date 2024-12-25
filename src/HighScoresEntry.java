import java.io.Serializable;

public class HighScoresEntry implements Serializable {
    public String name;
    public int score;
    public HighScoresEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return this.name;
    }
    public int getScore() {
        return this.score;
    }
    @Override
    public String toString() {
     return this.name + " " + this.score;
    }
}
