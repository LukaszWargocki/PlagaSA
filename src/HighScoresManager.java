import java.io.*;
import java.util.ArrayList;
import java.util.List;
// utility class for handing high scores creation and storing
public final class HighScoresManager {
    public static String PATH = "highscores.dat";
    private HighScoresManager() {
        throw new java.lang.UnsupportedOperationException("This class cannot be instantiated");
    }
    public static List<HighScoreEntry> loadScores() {
        ObjectInputStream ois = null;
        List<HighScoreEntry> entries = new ArrayList<>();
        File highscores = new File(PATH);
        try {
            if (!highscores.createNewFile()) {
                ois = new ObjectInputStream(new FileInputStream(PATH));
                HighScoreEntry hse;
                while ((hse = (HighScoreEntry) ois.readObject()) != null)
                    entries.add(hse);
            }
            if (ois != null)
                ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            new ErrorMessage(ex.toString());
        }
        return entries;
    }
    public static void saveScores(List<HighScoreEntry> entries) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(HighScoresManager.PATH, true));
            for (HighScoreEntry entry: entries) {
                oos.writeObject(entry);
            }
            oos.writeObject(null);
        } catch (IOException ex) {
            ex.printStackTrace();
            new ErrorMessage(ex.toString());
        } finally {
            if (oos != null)
                oos.close();
        }
    }
}
