import javax.swing.*;
import java.awt.event.*;

public class ExitButton extends MainMenuButton {
    public ExitButton() {
        super("Exit");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to quit",
                        "Exit",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
    }
}
