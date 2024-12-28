import javax.swing.*;
import java.io.*;
import java.util.*;

public class HighScores extends JFrame {
    public HighScores(List<ScoreEntry> entries) {
        generateHighscores(entries);
    }
    private void generateHighscores(List<ScoreEntry> entries) {
//       TODO: Abstract List model for <ScoreEntry class
//        JList scores = new JList(entries);
//        this.getContentPane().add(scores);
        setSize(600, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        entries.sort(new Comparator<ScoreEntry>() {
            @Override
            public int compare(ScoreEntry o1, ScoreEntry o2) {
                // replacement by InellJ for of double ternary operator
                return Integer.compare(o2.score, o1.score);
            }
        });
        JList<ScoreEntry> list = new JList<>((ListModel) entries);
        JScrollPane pane = new JScrollPane(list);
        add(pane);
    }
}
