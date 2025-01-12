import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
public class Game implements Runnable {

    public int difficulty = -1;
    private boolean running = false;
    private Thread thread;
    private Region nam = new Region("North America", Region.NAM_COL, 100);
    private Region lan = new Region("Latin America", Region.LAN_COL, 100);
    private Region sub = new Region("Sub-Saharan Africa", Region.SUB_COL, 100);
    private Region mag = new Region("Maghreb", Region.MAG_COL, 190);
    private Region eur = new Region("Europe", Region.EUR_COL, 100);
    private Region sca = new Region("Scandinavia", Region.SCA_COL, 100);
    private Region mea = new Region("Middle East", Region.MEA_COL, 100);
    private Region nas = new Region("North Asia", Region.NAS_COL, 100);
    public Region sas = new Region("South Asia", Region.SAS_COL, 100);
    private Region eas = new Region("East Asia", Region.EAS_COL, 100);
    private Region sea = new Region("South-East Asia", Region.SEA_COL, 100);
    private Region oce = new Region("Oceania", Region.OCE_COL, 100);

    protected void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    protected void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            new ErrorMessage(ex.toString());
        }
    }

    public void run() {
        // TODO: GAME LOOP!!!
        long initialTime = System.nanoTime();
        int numberOfUpdates = 0;
        int numberOfFrames = 0;
        long timer = System.currentTimeMillis();
        final double fps = 60;
        double nanos = 1000000000 / fps;
        // represents 1/60 of a second
        double framesElapsed = 0;
        while (running) {
            long currentTime = System.nanoTime();
            framesElapsed += (currentTime - initialTime) / nanos;
            initialTime = currentTime;
            if (framesElapsed >= 1) {
                tick();
                numberOfUpdates++;
                framesElapsed--;
            }
            render();
            numberOfFrames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(numberOfUpdates + " - Ticks, FPS - " + numberOfFrames);
                numberOfUpdates = 0;
                numberOfFrames = 0;
            }
        }
        stop();
    }

    private void tick() {

    }

    private void render() {
//        ImageIcon plane = new ImageIcon("resources/plane512.jpg");
    }
}

class GameScreen  {
    GameScreen(int screenWidth, int screenHeight, Game game) {
        JFrame gs = new JFrame("Plaga SA");
        gs.setSize(screenWidth, screenHeight);
        gs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gs.setVisible(true);
        gs.setSize(screenWidth, screenHeight);
        Image image;

        try {
            // created at https://www.geograf.in/en/map-color.php
            image = ImageIO.read(new File("resources/mapa.jpg"));
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
        gs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                BufferedImage bi = new BufferedImage(gs.getWidth(), gs.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                gs.paint(g);
                Color color = new Color(bi.getRGB(point.x, point.y));
                if (color.equals(Region.SAS_COL))
                    System.out.println("India clicked!");
                if (color.equals(Region.NAM_COL))
                    SwingUtilities.invokeLater(() -> new RegionInfo("North America", gs.getWidth()/6, gs.getHeight()/2));
            }
        });
    }
}
