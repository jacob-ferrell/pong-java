import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ball extends Rectangle {
    private double speed = Constants.BALL_START_SPEED;
    private final double maxSpeed = Constants.MAX_BALL_SPEED;
    public double vx, vy;
    private Position startPoint;
    private Position endPoint;
    private final Game game;
    private double dt;
    public Ball(Game game) {
        super(Constants.BALL_WIDTH, Constants.BALL_HEIGHT, new Position(Constants.HZ_CENTER, Constants.V_CENTER));
        this.game = game;
    }
    public void update(double dt) {
        this.dt = dt;
        serve();
        game.rightPaddle.moveToBallsPredictedPosition(this);
        game.handleCollision();
        handleScore();
        setPosition();
    }
    private void serve() {
        if (!startEndPointsAreNull()) {
            return;
        }
        this.speed = Constants.BALL_START_SPEED;
        this.startPoint = game.serving.getRandomServeStartPosition();
        this.endPoint = game.serving.getRandomServeEndPosition();
        var angle = new Angle(startPoint, endPoint);
        setVelocities(angle.getVelocities());
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
            game.AIScore.increment();
            game.serving = game.rightPaddle;
        } else {
            game.playerScore.increment();
            game.serving = game.leftPaddle;
        }
        if (game.AIScore.hasWon() || game.playerScore.hasWon()) {
            game.endGame();
            return;
        }
        clearStartEndPoints();
        serve();
    }
    public void incrementSpeed() {
        this.speed = Math.min(maxSpeed, this.speed + 1);
    }
    private boolean startEndPointsAreNull() {
        return this.startPoint == null || this.endPoint == null;
    }
    private void clearStartEndPoints() {
        this.startPoint = null;
        this.endPoint = null;
    }
    public void setVelocities(VelocityPair velocities) {
        this.vx = velocities.vx * this.speed;
        this.vy = velocities.vy * this.speed;
    }
    private void setPosition() {
        this.position =  new Position((position.x + (vx * dt)), position.y + (vy * dt));
    }
}
