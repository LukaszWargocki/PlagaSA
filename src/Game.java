import java.awt.*;
import javax.swing.*;

public class Game implements Runnable {

    public int difficulty = -1;
    public final String TITLE = "Plaga SA";
    private boolean running = false;
    private Thread thread;

    protected synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
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
        while (running) {
            System.out.println("Game logic happening");
        }
        stop();
    }
    public static void main(String[] args) {
        // TODO: testy skalowania
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        SwingUtilities.invokeLater(() -> new MainMenu(screenWidth, screenHeight));
    }


}