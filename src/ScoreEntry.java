import java.io.Serializable;

public class ScoreEntry implements Serializable {
    public String name;
    public int score;
    public ScoreEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
     return name + " " + score;
    }
}
