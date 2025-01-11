import java.io.IOException;

public class HighScoresButton extends MainMenuButton {
    public HighScoresButton(int fontHeight) {
        super("High Scores", fontHeight);
        this.addActionListener(e -> {
            try {
                new HighScoreNamePrompt();
            } catch (IOException ex) {
                ex.printStackTrace();
                new ErrorMessage(ex.toString());
            }
            java.util.List<HighScoreEntry> scores = HighScoresManager.loadScores();
            // TODO: Usunąć
            for (HighScoreEntry score: scores) {
                System.out.println(score);
            }
            new HighScoresComponent(scores);
        });
    }
}
