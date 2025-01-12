import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuButton extends JButton {
    public MainMenuButton(String title, int size) {
        super(title);
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Monospaced", Font.BOLD, size));

        // cause MouseListener would've required implementation of all mouseEvents
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton b = (JButton) e.getSource();
                b.setBorderPainted(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                JButton b = (JButton) e.getSource();
                b.setBorderPainted(false);
            }
        });
    }
    public MainMenuButton(String title) {
        this(title, 30);
    }
}
