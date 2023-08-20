import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Paddle {
    public Position position;
    public String side;
    private Color color;
    private int topY;
    private int width;
    private int height;

    public Paddle(String side, Position startPosition, int width, int height) {
        this.position = startPosition;
        this.width = width;
        this.height = height;
        this.side = side;
        this.color = Color.WHITE;
    }

    public int getBottomY() {
        return position.y + this.height;
    }


    public void moveUp() {
        int newY = Math.max(Constants.TOOLBAR_HEIGHT, position.y - Constants.MOVEMENT_SPEED);
        this.position = new Position(position.x, newY);
    }

    public void moveDown() {
        int newY = Math.min(Constants.SCREEN_HEIGHT - height, position.y + Constants.MOVEMENT_SPEED);
        this.position = new Position(position.x, newY);
    }
    public void moveAI(int vx, int vy) {
        if (vx <= 0) {
            return;
        }
        var nextPosition = position.predictOutOfBoundsPosition(vx, vy);
        if (this.position.y > nextPosition.y) {
            this.moveUp();
        } else if (this.position.y + Constants.PADDLE_HEIGHT < nextPosition.y) {
            this.moveDown();
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(position.x, position.y, width, height);
    }
    public void setPosition(Position position) {
        this.position = position;
    }

}
