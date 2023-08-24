public class LeftPaddle extends Paddle {
    public LeftPaddle() {
        super(
                Constants.PADDLE_WIDTH,
                Constants.LEFT_PADDLE_START_POSITION,
                new Range(Constants.HZ_CENTER * 1.25, Constants.SCREEN_WIDTH - 5),
                Constants.PADDLE_HORIZONTAL_ANGLES[0]
        );
    }
    @Override
    public double getNormalizedDistance() {
        double centerPoint = this.height / 2;
        return this.getMedianImpactPoint() - centerPoint;
    }
}
