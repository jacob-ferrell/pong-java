

import java.util.Random;

public class Game {
    public final LeftPaddle leftPaddle;
    public final RightPaddle rightPaddle;
    public Score playerScore;
    public Score AIScore;
    public Paddle serving;
    public Ball ball;
    public Net net;
    private boolean isOver = false;
    public final Range heightRange = new Range(Constants.TOOLBAR_HEIGHT, Constants.SCREEN_HEIGHT);
    public Game() {
        this.leftPaddle = new LeftPaddle();
        this.rightPaddle = new RightPaddle();
        this.ball = new Ball(this);
        this.serving = new Paddle[]{leftPaddle, rightPaddle}[new Random().nextInt(2)];
        this.playerScore = new Score(0, Constants.LEFT_SCORE_POSITION);
        this.AIScore = new Score(0, Constants.RIGHT_SCORE_POSITION);
        this.net = new Net();
    }
    public void endGame() {
        this.isOver = true;
    }
    public boolean getIsOver() {
        return this.isOver;
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

}
