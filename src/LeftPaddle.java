import java.util.Random;

public class LeftPaddle extends Paddle {
    public LeftPaddle() {
        super(
                Constants.PADDLE_WIDTH,
                Constants.LEFT_PADDLE_START_POSITION,
                new Range(Constants.HZ_CENTER * 1.25, Constants.SCREEN_WIDTH - 5),
                Constants.PADDLE_HORIZONTAL_ANGLES[0],
                Constants.LEFT_X_SERVE_START_POINT
        );
    }
    @Override
    public Position getRandomServeEndPosition() {
        var side = new Position(Constants.SCREEN_WIDTH, new Range(Constants.TOOLBAR_HEIGHT + 1, Constants.SCREEN_HEIGHT - 1));
        Position[] walls = {getRandomTopServePosition(), side, getRandomBottomServePosition()};
        return walls[new Random().nextInt(3)];
    }
    @Override
    public double getNormalizedDistance() {
        double centerPoint = this.height / 2;
        return this.getMedianImpactPoint() - centerPoint;
    }

}
