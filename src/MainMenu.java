import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu {

    public MainMenu(int screenWidth, int screenHeight) {
        JFrame backdrop = new JFrame("Plaga SA");
        backdrop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backdrop.setSize(screenWidth, screenHeight);
        backdrop.setLocationRelativeTo(null);
        backdrop.setVisible(true);
        JPanel menuBar = new JPanel();
        NewGameButton newGameButton = new NewGameButton();
        JButton highScoresButton = new JButton("High Scores");
        highScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  try {
                    //new HighScoreNamePrompt();
                    new HighScores();
              //  } catch (IOException ex) {
                    //throw new RuntimeException(ex);
              //  }
            }
        });
        ExitButton exitButton = new ExitButton();
        menuBar.add(newGameButton);
        menuBar.add(highScoresButton);
        menuBar.add(exitButton);
        backdrop.add(menuBar);

    }
}