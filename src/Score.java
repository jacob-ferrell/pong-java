import java.awt.*;

public class Score {
    private int score;
    private final Position position;
    public Score(int score, Position position) {
        this.score = score;
        this.position = position;
    }
    public void increment() {
        score++;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(Constants.FONT);
        g2.drawString(String.valueOf(score), (float) position.x, (float) position.y);
    }
    public boolean hasWon() {
        return score >= Constants.POINTS_TO_WIN;
    }
}
