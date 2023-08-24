import java.util.Random;

public class Wall {
    Position start;
    Position end;
    public Wall(Position start, Position end) {
        this.start = start;
        this.end = end;
    }
    public Position getRandomPosition() {
        Random random = new Random();
        int randomX = random.nextInt((int)start.x, (int)end.x + 1);
        int randomY = random.nextInt((int)start.y, (int)end.y + 1);
        return new Position(randomX, randomY);
    }
}
