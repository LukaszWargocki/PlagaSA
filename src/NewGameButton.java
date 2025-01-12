import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewGameButton extends MainMenuButton {
    private int difficulty;
    public NewGameButton(int fontHeight) {
        super("New Game", fontHeight);
        String[] options = {"Easy", "Normal", "Hard"};
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty = JOptionPane.showOptionDialog(
                        null,
                        "Select difficulty",
                        "Start a new game",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options, options[1]
                );
                //startGame(difficulty);
                Window menuWindow = SwingUtilities.windowForComponent((JButton) e.getSource());
                Game game = new Game();
                GameScreen gs = new GameScreen(menuWindow.getWidth(), menuWindow.getHeight(), game);
                game.start();
                menuWindow.dispose();
            }
        });
    }
}
