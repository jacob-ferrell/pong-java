import java.util.Objects;

public class Position {
    public double x, y;
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double interpolate(double x, Position p2) {
        return this.y + (x - this.x) * (p2.y - this.y) / (p2.x - this.x);
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
    public Position predictOutOfBoundsPosition(double vx, double vy) {
        double timeToHitBottom = Math.abs((Constants.SCREEN_HEIGHT - y + Constants.BALL_HEIGHT) / vy);
        double timeToHitTop = Math.abs(y / vy);
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
