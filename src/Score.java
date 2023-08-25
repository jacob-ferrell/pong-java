import java.awt.*;

public class Score {
    private int score;
    private Position position;
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
}
