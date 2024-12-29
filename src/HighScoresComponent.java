import javax.swing.*;
import java.io.*;
import java.util.*;

public class HighScoresComponent extends JFrame {
    public HighScoresComponent(List<HighScoreEntry> entryList) {
        generateHighscores(entryList);
    }
    private void generateHighscores(List<HighScoreEntry> entryList) {
        setSize(600, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        entryList.sort(new Comparator<HighScoreEntry>() {
            @Override
            public int compare(HighScoreEntry o1, HighScoreEntry o2) {
                // replacement by InellJ for of double ternary operator
                return Integer.compare(o2.score, o1.score);
            }
        });
        HighScoresListModel hslm = new HighScoresListModel(entryList);
        JList<String> jlist = new JList<>(hslm);
        JScrollPane pane = new JScrollPane(jlist);
        add(pane);
    }
}
