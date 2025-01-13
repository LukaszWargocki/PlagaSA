import javax.swing.*;
import java.util.*;

public class HighScoresListModel extends AbstractListModel {
    private List<HighScoreEntry> entries;

    public HighScoresListModel() {
        this.entries = new ArrayList<>();
    }

    public HighScoresListModel(List<HighScoreEntry> list) {
        this.entries = list;
    }
    public void addEntry(String name, int score) {
        entries.add(new HighScoreEntry(name, score));
    }
    @Override
    public int getSize() {
        return entries.size();
    }

    @Override
    public String getElementAt(int index) {
        return entries.get(index).toString();
    }
}
