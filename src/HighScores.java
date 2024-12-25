import javax.swing.*;
import java.io.*;
import java.util.*;

public class HighScores extends JFrame {
    public void HighScores () throws IOException {
        ObjectInputStream ois = null;
        List<HighScoresEntry> rating = new ArrayList<>();
        try {
            ois = new ObjectInputStream(new FileInputStream("highscores.txt"));
            HighScoresEntry entry;
            while ((entry = (HighScoresEntry) ois.readObject()) != null)
                rating.add(entry);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null)
                ois.close();
        }
        HighScoresEntry[] hs = (HighScoresEntry[]) rating.toArray();
       for (HighScoresEntry he: hs) {
           System.out.println(he);
       }
    }
}
