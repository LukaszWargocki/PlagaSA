import java.io.Serializable;
//
public class HighScoreEntry implements Serializable {
    // final - thus/since no need for setters
    public final String name;
    public final int score;

    public HighScoreEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }
    // getters
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    // toString into JList presentable String
    @Override
    public String toString() {
        return name + "     -     " + score;
    }
}
