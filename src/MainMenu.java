import javax.swing.*;
import java.awt.*;

public class MainMenu {

    public MainMenu(int screenWidth, int screenHeight) {
        JFrame backdrop = new JFrame("Plaga SA");
        backdrop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backdrop.setSize(screenWidth, screenHeight);
        backdrop.setLocationRelativeTo(null);
        backdrop.setVisible(true);
        JPanel menuBar = new JPanel();
        JButton newGameButton = new JButton("New Game");
        JButton highScoresButton = new JButton("High Scores");
        ExitButton exitButton = new ExitButton();
        menuBar.add(newGameButton);
        menuBar.add(highScoresButton);
        menuBar.add(exitButton);
        backdrop.add(menuBar);

    }
}
