import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    public MainMenu(int screenWidth, int screenHeight) {

        // window setup
        setTitle("Plaga SA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setVisible(true);

        // background
        JLabel background = new JLabel(new ImageIcon("resources/bg1080.jpg"));
        background.setBounds(0, 0, screenWidth, screenHeight);
        setContentPane(background);

        // buttons panel
        JPanel menuPanel = new JPanel(new GridLayout(3,1, 10, 10));
        menuPanel.setBounds(getWidth()/6, getHeight() / 3, getWidth() / 6, getHeight() / 3);
        menuPanel.setOpaque(false);

        // construct buttons
        NewGameButton newGameButton = new NewGameButton();
        HighScoresButton highScoresButton = new HighScoresButton();
        ExitButton exitButton = new ExitButton();

        // add components
        menuPanel.add(newGameButton);
        menuPanel.add(highScoresButton);
        menuPanel.add(exitButton);
        add(menuPanel);

        // update menu size on resizing of window
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                menuPanel.setBounds(getWidth()/6, getHeight() / 3, getWidth() / 6, getHeight() / 3);
                revalidate();
            }
        });
    }
}