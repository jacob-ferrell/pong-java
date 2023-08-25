import java.util.Random;

public class RightPaddle extends Paddle {
    public RightPaddle() {
        super(
                Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH,
                Constants.RIGHT_PADDLE_START_POSITION,
                new Range(5, Constants.HZ_CENTER * 0.75),
                Constants.PADDLE_HORIZONTAL_ANGLES[1],
                Constants.RIGHT_X_SERVE_START_POINT
        );
    }
    @Override
    public double getNormalizedDistance() {
        double centerPoint = this.height / 2;
        return -(this.getMedianImpactPoint() - centerPoint);
    }
    @Override
    public Position getRandomServeEndPosition() {
        var side = new Position(0, new Range(Constants.TOOLBAR_HEIGHT + 1, Constants.SCREEN_HEIGHT - 1));
        Position[] walls = {getRandomTopServePosition(), side, getRandomBottomServePosition()};
        return walls[new Random().nextInt(3)];
    }
}
