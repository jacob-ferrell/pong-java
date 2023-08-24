import java.util.List;

public class Game {
    public final LeftPaddle leftPaddle;
    public final RightPaddle rightPaddle;
    public int playerScore;
    public int AIScore;
    public Side sideServing;
    public Ball ball;
    public Side leftSide;
    public Side rightSide;
    public final Range heightRange = new Range(Constants.TOOLBAR_HEIGHT, Constants.SCREEN_HEIGHT);
    public Game() {
        this.leftSide = new Side(Constants.LEFT);
        this.rightSide = new Side((Constants.RIGHT));
        this.leftPaddle = new LeftPaddle();
        this.rightPaddle = new RightPaddle();
        this.ball = new Ball(this);
        this.sideServing = rightSide;
        this.playerScore = 0;
        this.AIScore = 0;
    }

    public Paddle getHitPaddle() {
        var ballYRange = this.ball.getYRange();
        Paddle paddle = this.ball.vx < 0 ? this.leftPaddle : this.rightPaddle;
        var paddleYRange = paddle.getYRange();
        var sharedYRange = ballYRange.getSharedRange(paddleYRange);
        if (sharedYRange != null) {
            paddle.setMedianImpactPoint(sharedYRange.getAverage() - paddle.position.y);
            return paddle;
        }
        return null;
    }

    public void handleCollision() {
        if (this.ball.isInBounds()) {
            return;
        }
        if (this.ball.position.y <= this.heightRange.min
                || this.ball.getBottomY() >= this.heightRange.max) {
            this.ball.invertYVelocity();
            return;
        }
        var hitPaddle = getHitPaddle();
        if (hitPaddle == null) {
            return;
        }
        double normalizedDistance = hitPaddle.getNormalizedDistance();
        double percentage = normalizedDistance / (hitPaddle.height / 2);
        double newAngleInDegrees = hitPaddle.hzLine + (Constants.MAX_ANGLE_STEEPNESS * percentage);
        var angle = new Angle(newAngleInDegrees);
        this.ball.setVelocities(angle.getVelocities());
        this.ball.incrementSpeed();
    }

    public void incrementPlayerScore() {
        playerScore++;
    }
    public void incrementAIScore() {
        AIScore++;
    }

}
