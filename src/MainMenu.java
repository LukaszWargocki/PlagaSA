import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
            java.util.List<HighScoreEntry> scores = HighScoresManager.loadScores();
            for (HighScoreEntry score: scores) {
                System.out.println(score);
            }
            new HighScoresComponent(scores);
        });
        ExitButton exitButton = new ExitButton();
        backdrop.add(newGameButton);
        backdrop.add(highScoresButton);
        backdrop.add(exitButton);
        add(backdrop);
    }
}