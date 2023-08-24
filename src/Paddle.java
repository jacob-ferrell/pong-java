import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Paddle extends Rectangle {
    private int numberOfSections;
    public final double xCollisionPoint;
    private final Range xServeRange;
    private List<PaddleSection> sections;
    private double medianImpactPoint;
    public double hzLine;

    public Paddle(double xCollisionPoint, Position position, Range xServeRange, double hzLine) {
        super(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, position);
        this.xCollisionPoint = xCollisionPoint;
        this.xServeRange = xServeRange;
        this.hzLine = hzLine;
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
    private void addSections() {
        this.sections = new ArrayList<>();
        for (int i = 0; i < height; i += height / numberOfSections) {
            sections.add(new PaddleSection(new Range(i, i + (height / numberOfSections)), sections.size()));
        }
    }
    public double getMedianImpactPoint() {
        return medianImpactPoint;
    }
}
