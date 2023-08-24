import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ball extends Rectangle {
    private double speed = Constants.BALL_START_SPEED;
    private final double maxSpeed = Constants.MAX_BALL_SPEED;
    public double vx, vy;
    private Position startPoint;
    private Position endPoint;
    private final Game game;
    public Ball(Game game) {
        super(Constants.BALL_WIDTH, Constants.BALL_HEIGHT, new Position(Constants.HZ_CENTER, Constants.V_CENTER));
        this.game = game;
    }
    public void update(double dt) {
        if (this.startPoint == null || endPoint == null) {
            serve();
            return;
        }
        game.rightPaddle.moveToBallsPredictedPosition(this);
        this.game.handleCollision();
//        handlePaddleHit(dt);
//        handleWallBounce();
        handleScore();
        double newX = this.position.x + (this.vx * dt);
        double newY = this.position.y + (this.vy * dt);
        this.position = new Position(newX, newY);
    }
    private void serve() {
        this.speed = Constants.BALL_START_SPEED;
        this.startPoint = getStartPoint();
        this.endPoint = getEndPoint();
        var angle = new Angle(startPoint, endPoint);
        setVelocities(angle.getVelocities());
//        if (vx == 0 && Mnew VelocityPair(angleInRadians, speed)ath.abs(vy) > 0) {
//            serve();
//        }
        this.position = startPoint;
    }
    public boolean isInBounds() {
        if (this.getBottomY() > Constants.SCREEN_HEIGHT || this.position.y < Constants.TOOLBAR_HEIGHT) {
            return false;
        }
        return this.position.x > game.leftPaddle.xCollisionPoint && this.getRightX() < game.rightPaddle.xCollisionPoint;
    }
    public void invertYVelocity() {
        this.vy *= -1;
    }

    private boolean isOutOfBounds() {
        return position.x <= 0 || getRightX() >= Constants.SCREEN_WIDTH;
    }
    private void handleScore() {
        if (!isOutOfBounds()) {
            return;
        }
        if (vx < 0) {
            game.incrementAIScore();
            //game.sideServing = game.rightSide;
        } else {
            game.incrementPlayerScore();
            game.sideServing = game.leftSide;
        }
        this.startPoint = null;
        this.endPoint = null;
        serve();
    }
    public Position getStartPoint() {
        return game.sideServing.getRandomServingStartPosition();
    }
    public Position getEndPoint() {
        Side sideServingTo = game.sideServing.equals(game.leftSide) ? game.rightSide : game.leftSide;
        Wall wallServingTo = sideServingTo.getRandomWall();
        return wallServingTo.getRandomPosition();
    }
    public void incrementSpeed() {
        this.speed = Math.min(maxSpeed, this.speed + 1);
    }
    public void setVelocities(VelocityPair velocities) {
        this.vx = velocities.vx * this.speed;
        this.vy = velocities.vy * this.speed;
    }
}
