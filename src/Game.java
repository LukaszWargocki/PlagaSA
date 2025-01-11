import java.awt.*;
import javax.swing.*;

public class Game implements Runnable {

    public int difficulty = -1;
    private boolean running = false;
    private Thread thread;

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

    }

    public static void main(String[] args) {
        // TODO: initial screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        SwingUtilities.invokeLater(() -> new MainMenu(width, height));
    }
}