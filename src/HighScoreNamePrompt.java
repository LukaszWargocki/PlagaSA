import javax.swing.JOptionPane;
import java.io.*;

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
        HighScoresEntry entry = new HighScoresEntry(name, score);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("highscores.txt"));
            oos.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (oos != null)
                oos.close();
        }
    }
}
