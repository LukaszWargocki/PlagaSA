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
    }
}
