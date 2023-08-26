import java.util.Objects;

public class Position {
    public double x, y;
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Position(Range rx, Range ry) {
        this.x = rx.getRandom();
        this.y = ry.getRandom();
    }
    public Position(double x, Range ry) {
        this.x = x;
        this.y = ry.getRandom();
    }
    public Position(Range rx, double y) {
        this.x = rx.getRandom();
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
    public Position predictOutOfBoundsPosition(double vx, double vy) {
        double timeToHitBottom = Math.abs((Constants.SCREEN_HEIGHT - y + Constants.BALL_HEIGHT) / vy);
        double timeToHitTop = Math.abs((y - Constants.TOOLBAR_HEIGHT) / vy);
        double timeToHitRight = ((Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH) - x + Constants.BALL_WIDTH) / vx;
        double predictedTime;

        if (vy > 0) {
            predictedTime = Math.min(timeToHitBottom, timeToHitRight);
        } else {
            predictedTime = Math.min(timeToHitTop, timeToHitRight);
        }

        double predictedX = x + vx * predictedTime;
        double predictedY = y + vy * predictedTime;

        var nextPosition = new Position(predictedX, predictedY);

        if (Math.min(timeToHitBottom, timeToHitTop) == predictedTime) {
            return nextPosition.predictOutOfBoundsPosition(vx, -vy);
        }

        return nextPosition;
    }
}
