import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        SwingUtilities.invokeLater(() -> new MainMenu(screenWidth, screenHeight));
    }
}