

public abstract class Paddle extends Rectangle {
    public final double xCollisionPoint;
    public final Range xServeRange;
    private final double xServeStartPoint;
    private double medianImpactPoint;
    public double hzLine;

    public Paddle(double xCollisionPoint, Position position, Range xServeRange, double hzLine, double xServeStartPoint) {
        super(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, position);
        this.xCollisionPoint = xCollisionPoint;
        this.xServeRange = xServeRange;
        this.hzLine = hzLine;
        this.xServeStartPoint = xServeStartPoint;
    }
    public void moveUp() {
        double newY = Math.max(Constants.TOOLBAR_HEIGHT, position.y - Constants.MOVEMENT_SPEED);
        this.position = new Position(position.x, newY);
    }
    public void setMedianImpactPoint(double medianImpactPoint) {
        this.medianImpactPoint = medianImpactPoint;
    }

    public void moveDown() {
        double newY = Math.min(Constants.SCREEN_HEIGHT - height, position.y + Constants.MOVEMENT_SPEED);
        this.position = new Position(position.x, newY);
    }
    public void moveToBallsPredictedPosition(Ball ball) {
        double vx = ball.vx;
        double vy = ball.vy;
        if (vx <= 0) {
            return;
        }
        var nextPosition = ball.position.predictOutOfBoundsPosition(vx, vy);
        if (this.position.y > nextPosition.y) {
            this.moveUp();
        } else if (this.position.y + height < nextPosition.y) {
            this.moveDown();
        }
    }
    public abstract double getNormalizedDistance();
    public Position getRandomServeStartPosition() {
        Range yRange = new Range(Constants.TOOLBAR_HEIGHT, Constants.SCREEN_HEIGHT);
        return new Position(this.xServeStartPoint, yRange.getRandom());
    }
    public Position getRandomTopServePosition() {
        return new Position(this.xServeRange, Constants.TOOLBAR_HEIGHT);
    }
    public Position getRandomBottomServePosition() {
        return new Position(this.xServeRange, Constants.SCREEN_HEIGHT - this.height);
    }
    public abstract Position getRandomServeEndPosition();
    public double getMedianImpactPoint() {
        return medianImpactPoint;
    }
}
