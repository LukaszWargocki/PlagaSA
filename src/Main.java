import java.awt.*;
import javax.swing.*;
// <a href="https://www.freepik.com/search">Icon by Freepik</a>
//<a href="https://www.freepik.com/search">Icon by Freepik</a>
public class Main {
    public static void main(String[] args) {
        // TODO: initial screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        SwingUtilities.invokeLater(() -> new MainMenu(width, height));
    }
}