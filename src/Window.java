import javax.swing.*;
import java.awt.*;


public class Window extends JFrame implements Runnable {
    Graphics2D g2;
    Game game;
    public Window() {
        setTitle(Constants.SCREEN_TITLE);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
        game = new Game();
        g2 = (Graphics2D)getGraphics();
        addMouseMotionListener(new MovePaddleMouseListener(game));
        addKeyListener(new MovePaddleKeyListener(game));
    }
    public void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage,0, 0, this);
        game.ball.update(dt);
    }
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        game.leftPaddle.draw(g2);
        game.rightPaddle.draw(g2);
        game.ball.draw(g2);
        game.playerScore.draw(g2);
        game.AIScore.draw(g2);
    }
    public void run() {
    double lastFrameTime = 0.0;
    while (true) {
        double time = Time.getTime();
        double deltaTime = time - lastFrameTime;
        lastFrameTime = time;
        update(deltaTime / 10_000_000.0);
//        try {
//            Thread.sleep(5);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }
    }
}