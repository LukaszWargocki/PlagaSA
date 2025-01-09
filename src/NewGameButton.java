import javax.swing.*;
import java.awt.event.*;

public class NewGameButton extends MainMenuButton {
    private int difficulty;
    public NewGameButton() {
        super("New Game");
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
                //System.out.println(options[difficulty]);
                //startGame(difficulty);
                SwingUtilities.windowForComponent((JButton) e.getSource()).dispose();
                Game game = new Game();
                game.start();
            }
        });
    }
}
