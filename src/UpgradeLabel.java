import javax.swing.*;
import java.awt.*;

public class UpgradeLabel extends JLabel {
    public UpgradeLabel(String name) {
        setFont(new Font("Monospaced", Font.BOLD, 24));
        setText(name);
    }
}
