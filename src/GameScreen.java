import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GameScreen  {
    GameScreen(int screenWidth, int screenHeight, Game game) {
        JFrame gs = new JFrame("Plaga SA");
        gs.setSize(screenWidth, screenHeight);
        gs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gs.setVisible(true);
        gs.setSize(screenWidth, screenHeight);
        Image image;
        try {
            // created at https://www.geograf.in/en/map-color.php
            image = ImageIO.read(new File("resources/wm2203x1117.jpg"));
            JLabel map = new JLabel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int width = getWidth();
                    int height = getHeight();
                    g.drawImage(image, 0, 0, width, height, null);
                }
            };
            gs.setContentPane(map);
        } catch (IOException ex) {
            ex.printStackTrace();
            new ErrorMessage(ex.toString());
        }
        // exit to main menu
        gs.requestFocus();
        gs.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
                    System.out.println("works");
                    SwingUtilities.invokeLater(() -> new MainMenu(screenWidth, screenHeight));
                    gs.dispose();
                    game.stop();
                }
            }
        });
    }
}
