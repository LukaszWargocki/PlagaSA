import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButton extends JButton {
    public NewGameButton() {
        this.setText("New Game");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int difficulty = JOptionPane.show
            }
        });
    }
}
