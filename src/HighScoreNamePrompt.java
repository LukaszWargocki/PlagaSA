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
        int score = 99;
        List<HighScoreEntry> entries = HighScoresManager.loadScores();
        entries.add(new HighScoreEntry(name, score));
        File highscores = new File(HighScoresManager.PATH);
        highscores.delete();
        HighScoresManager.saveScores(entries);
    }
}
