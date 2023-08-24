import java.util.Random;

public class Round {
    Game game;
    public Round(Game game) {
        this.game = game;
        //game.ball.serve();
    }



    public static int getRandomY() {
        Random random = new Random();
        return random.nextInt((int)(Constants.SCREEN_HEIGHT - Constants.BALL_HEIGHT));
    }
}
