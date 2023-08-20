public class Game {
    public final Paddle leftPaddle;
    public final Paddle rightPaddle;
    public int playerScore;
    public int AIScore;
    public Side sideServing;
    public Ball ball;
    public Side leftSide;
    public Side rightSide;
    public Game() {
        this.leftSide = new Side(Constants.LEFT);
        this.rightSide = new Side((Constants.RIGHT));
        this.leftPaddle = new Paddle(Constants.LEFT, Constants.LEFT_PADDLE_START_POSITION, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
        this.rightPaddle = new Paddle((Constants.RIGHT), Constants.RIGHT_PADDLE_START_POSITION, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
        this.ball = new Ball(this, Constants.BALL_WIDTH, Constants.BALL_HEIGHT);
        this.sideServing = rightSide;
        this.playerScore = 0;
        this.AIScore = 0;
        play();
    }

    public void play() {
        Round round = new Round(this);
    }
    public void incrementPlayerScore() {
        playerScore++;
    }
    public void incrementAIScore() {
        AIScore++;
    }

}
