import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class MainMenu extends JFrame {
    public MainMenu(int screenWidth, int screenHeight) {
        this.setTitle("Plaga SA");
        // TODO: icon image assets and import
        //ImageIcon titleIcon = new ImageIcon("biohazard600.png");
        JPanel backdrop = new JPanel(new GridLayout(4,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        NewGameButton newGameButton = new NewGameButton();
        JButton highScoresButton = new JButton("High Scores");
        highScoresButton.addActionListener(e -> {
            try {
                new HighScoreNamePrompt();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
            java.util.List<ScoreEntry> scores = Loader.loadScores();
            for (ScoreEntry score: scores) {
                System.out.println(score);
            }
            HighScores highscore = new HighScores(scores);
        });
        ExitButton exitButton = new ExitButton();
        backdrop.add(newGameButton);
        backdrop.add(highScoresButton);
        backdrop.add(exitButton);
        add(backdrop);
    }
}