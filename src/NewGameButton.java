import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends JButton {
    private int difficulty;
    public NewGameButton() {
        this.setText("New Game");
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
                System.out.println(options[difficulty]);
                //startGame(difficulty);
                SwingUtilities.windowForComponent((JButton) e.getSource()).dispose();
            }
        });
    }
    public int getDifficulty() {
        return this.difficulty;
    }
}
