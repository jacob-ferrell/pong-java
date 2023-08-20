import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovePaddleKeyListener implements KeyListener {
    Game game;
    boolean pressed;
    public MovePaddleKeyListener(Game game) {
        this.game = game;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            game.leftPaddle.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            game.leftPaddle.moveDown();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
