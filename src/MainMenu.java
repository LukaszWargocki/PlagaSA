import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainMenu {
    public MainMenu(int width, int height) {
        JFrame mm = new JFrame("Plaga SA");
        // window setup
        mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mm.setSize(width, height);
        mm.setLocationRelativeTo(null);
        mm.setVisible(true);
        // resizable background image
        Image image;
        try {
            // free licence image from Unsplashed, provided by CDC
            image = ImageIO.read(new File("resources/bg1080.jpg"));
            JLabel background = new JLabel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // current window size
                    int w = getWidth();
                    int h = getHeight();
                    g.drawImage(image, 0, 0, w, h, null);
                }
            };
            mm.setContentPane(background);
        } catch (IOException ex) {
            ex.printStackTrace();
            new ErrorMessage(ex.toString());
        }

        // buttons panel
        JPanel menuPanel = new JPanel(new GridLayout(3,1, 10, 10));
        menuPanel.setBounds(width / 6, height / 3, width / 6, height / 3);
        menuPanel.setOpaque(false);

        // construct buttons
        NewGameButton newGameButton = new NewGameButton(height/27);
        HighScoresButton highScoresButton = new HighScoresButton(height/27);
        ExitButton exitButton = new ExitButton(width/27);

        // add components
        menuPanel.add(newGameButton);
        menuPanel.add(highScoresButton);
        menuPanel.add(exitButton);
        mm.add(menuPanel);

        // update menu size on resizing of window
        mm.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int h = mm.getHeight();
                int w = mm.getWidth();
                super.componentResized(e);
                menuPanel.setBounds(w / 6, h / 3, w / 6, h / 3);
                newGameButton.setFont(new Font("Monospaced", Font.BOLD, Math.min(h/27, w/48)));
                highScoresButton.setFont(new Font("Monospaced", Font.BOLD, Math.min(h/27, w/48)));
                exitButton.setFont(new Font("Monospaced", Font.BOLD, Math.min(h/27, w/48)));
                mm.revalidate();
            }
        });
    }
}