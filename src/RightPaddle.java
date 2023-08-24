public class RightPaddle extends Paddle {
    public RightPaddle() {
        super(
                Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH,
                Constants.RIGHT_PADDLE_START_POSITION,
                new Range(5, Constants.HZ_CENTER * 0.75),
                Constants.PADDLE_HORIZONTAL_ANGLES[1]
        );
    }
    @Override
    public double getNormalizedDistance() {
        double centerPoint = this.height / 2;
        return -(this.getMedianImpactPoint() - centerPoint);
    }
}
