import java.io.*;
import java.util.ArrayList;
import java.util.List;
// utility class for loading scores from a file
public final class Loader {
    public static String PATH = "highscores.dat";
    private Loader() {
        throw new java.lang.UnsupportedOperationException("This class cannot be instantiated");
    }
    public static List<ScoreEntry> loadScores() {
        ObjectInputStream ois = null;
        List<ScoreEntry> entries = new ArrayList<>();
        File highscores = new File(PATH);
        try {
            if (!highscores.createNewFile()) {
                ois = new ObjectInputStream(new FileInputStream(PATH));
                ScoreEntry se;
                while (true) {
                    try {
                        se = (ScoreEntry) ois.readObject();
                        entries.add(se);
                    } catch (EOFException eofException) {
                            break;
                        }
                }
                ois.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return entries;
    }
}
