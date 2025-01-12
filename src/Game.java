import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class Game implements Runnable {
    Game game = this;
    public int difficulty = -1;
    private boolean running = false;
    private Thread thread;
    public Region nam = new Region("North America", Region.NAM_COL, 389604080, 0.1, 0.2, 0.3);
    private Region lam = new Region("Latin America", Region.LAM_COL, 572194,0.4,0.3,0.3);
    private Region sub = new Region("Sub-Saharan Africa", Region.SUB_COL, 1240124111, 0.5,0.4,0.2);
    private Region mag = new Region("Maghreb", Region.MAG_COL, 217095436, 0.3,0.3,0.3);
    private Region eur = new Region("Europe", Region.EUR_COL, 621789154,0.33,0.23,0.8);
    private Region sca = new Region("Scandinavia", Region.SCA_COL, 27562156,0.2,0.2,0.2);
    private Region mea = new Region("Western Asia", Region.MEA_COL, 289733123,0.45,0.45,0.6);
    private Region nas = new Region("North Asia", Region.NAS_COL, 185897577,0.7,0.2,0.4);
    private Region sas = new Region("South Asia", Region.SAS_COL, 1989452478,0.5,0.4,0.22);
    public Region eas = new Region("East Asia", Region.EAS_COL, 1663696923,0.44,0.5,0.6);
    private Region sea = new Region("South-East Asia", Region.SEA_COL, 675796065, 0.4,0.1,0.23);
    private Region oce = new Region("Oceania", Region.OCE_COL, 44491724, 0.6,0.3,0.3);

    // spopulować mapę
    Map<Color, Region> regiony = new HashMap<>();

    protected void start() {
        if (running)
            return;
        // setting up regions
        eas.setInfected(1);
        regiony.put(Region.NAM_COL, nam);
        regiony.put(Region.LAM_COL, lam);
        regiony.put(Region.SUB_COL, sub);
        regiony.put(Region.MAG_COL, mag);
        regiony.put(Region.EUR_COL, eur);
        regiony.put(Region.SCA_COL, sca);
        regiony.put(Region.MEA_COL, mea);
        regiony.put(Region.NAS_COL, nas);
        regiony.put(Region.SAS_COL, sas);
        regiony.put(Region.EAS_COL, eas);
        regiony.put(Region.SEA_COL, sea);
        regiony.put(Region.OCE_COL, oce);

        running = true;
        thread = new Thread(this);
        thread.start();
        new GameScreen(1920, 1080, game);
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
}

