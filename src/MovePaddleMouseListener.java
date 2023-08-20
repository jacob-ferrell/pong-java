import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MovePaddleMouseListener extends MouseMotionAdapter {
    Game game;
    public MovePaddleMouseListener(Game game) {
        this.game = game;
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        int y = Math.min(Math.max(e.getY(), 0), Constants.SCREEN_HEIGHT - Constants.PADDLE_HEIGHT);
        game.leftPaddle.setPosition(new Position(game.leftPaddle.position.x, y));
    }


}
