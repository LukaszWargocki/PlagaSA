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
        // obsługa braku wejścia
        if (name == null || name.isEmpty())
            name = "anonymous";
        // TODO: pobieranie rzeczywistego wyniku
        int score = 3;
        // zczytaj wyniki z pliku do listy, dodaj wynik
        List<HighScoreEntry> entries = HighScoresManager.loadScores();
        entries.add(new HighScoreEntry(name, score));
        // z jeden plik - jeden strumień; nadpisuję nową listę
        File highscores = new File(HighScoresManager.PATH);
        highscores.delete();
        HighScoresManager.saveScores(entries);
    }
}
