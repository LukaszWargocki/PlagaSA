import javax.swing.*;
import java.util.*;

public class HighScoresComponent extends JFrame {
    public HighScoresComponent(List<HighScoreEntry> entryList) {
        generateHighscores(entryList);
    }
    private void generateHighscores(List<HighScoreEntry> entryList) {
        setSize(600, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        entryList.sort((o1, o2) -> {
            // replacement by InellJ for of double ternary operator
            return Integer.compare(o2.score, o1.score);
        });
        HighScoresListModel hslm = new HighScoresListModel(entryList);
        JList<String> jlist = new JList<>(hslm);
        JScrollPane pane = new JScrollPane(jlist);
        add(pane);
    }
}
