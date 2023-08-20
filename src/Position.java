import java.util.Objects;

public class Position {
    public int x;
    public int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position otherPosition)) {
            return false;
        }
        return x == otherPosition.x && y == otherPosition.y;
    }
    @Override
    public String toString() {
       return "[ x: " + x + ", y: " + y + " ]" ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    public boolean isTopOrBottomWall() {
        return y <= Constants.TOOLBAR_HEIGHT || y >= Constants.SCREEN_WIDTH;
    }
    public Position predictOutOfBoundsPosition(int vx, int vy) {
        double timeToHitBottom = Math.abs((double)(Constants.SCREEN_HEIGHT - y + Constants.BALL_HEIGHT) / vy);
        double timeToHitTop = Math.abs((double) y / vy);
        double timeToHitRight = (double)(Constants.SCREEN_WIDTH - x + Constants.BALL_WIDTH) / vx;
        double predictedTime;

        if (vy > 0) {
            predictedTime = Math.min(timeToHitBottom, timeToHitRight);
        } else {
            predictedTime = Math.min(timeToHitTop, timeToHitRight);
        }

        int predictedX = (int) (x + vx * predictedTime);
        int predictedY = (int) (y + vy * predictedTime);

        var nextPosition = new Position(predictedX, predictedY);

        if (Math.min(timeToHitBottom, timeToHitTop) == predictedTime) {
            return nextPosition.predictOutOfBoundsPosition(vx, -vy);
        }

        return nextPosition;
    }
}
