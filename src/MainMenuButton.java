import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuButton extends JButton {
    // TODO: add scalable font size parameter
    public MainMenuButton(String title, int size) {
        super(title);
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Monospaced", Font.BOLD, size));
        MainMenuButton b = this;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                b.setBorderPainted(true);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                b.setBorderPainted(false);
            }
        });
    }
    public MainMenuButton(String title) {
        this(title, 30);
    }
}
