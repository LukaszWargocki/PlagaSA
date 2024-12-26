import javax.swing.JOptionPane;
import java.io.*;
import java.util.List;

public class HighScoreNamePrompt {
    public HighScoreNamePrompt() throws IOException {
        String name = JOptionPane.showInputDialog(
                null,
                "Please, enter your name",
                "New High Score!",
                JOptionPane.QUESTION_MESSAGE
        );
        if (name == null || name.isEmpty())
            name = "anonymous";
        int score = 100;
        List<ScoreEntry> entries = Loader.loadScores();
        entries.add(new ScoreEntry(name, score));
        File highscores = new File(Loader.PATH);
        highscores.delete();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(Loader.PATH, true));
            for (ScoreEntry entry: entries) {
                oos.writeObject(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (oos != null)
                oos.close();
        }
    }
}
