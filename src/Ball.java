import java.awt.*;

public class Ball {
    public Position position;
    private int width;
    private int height;
    private int speed;
    public int vx;
    public int vy;
    private Position startPoint;
    private Position endPoint;
    Game game;
    public Ball(Game game, int width, int height) {
        this.game = game;
        this.width = width;
        this.height = height;
        speed = Constants.BALL_START_SPEED;
        this.position = new Position(Constants.HZ_CENTER, Constants.V_CENTER);
    }
    public void update() {
        if (this.startPoint == null || endPoint == null) {
            serve();
            return;
        }
        game.rightPaddle.moveAI(this);
        handlePaddleHit();
        handleWallBounce();
        handleScore();
        this.position = new Position(position.x + vx, position.y + vy);
    }
    private void serve() {
        this.startPoint = getStartPoint();
        this.endPoint = getEndPoint();

        //System.out.println(new Angle(startPoint, endPoint).inDegrees);
        var angleInRadians = new Angle(startPoint, endPoint).inRadians;
        double distance = Distance.getDistance(this.startPoint, this.endPoint);
        double directionX = (endPoint.x - startPoint.x) / distance;
        double directionY = (endPoint.y - startPoint.y) / distance;
        this.vx = (int) (Math.cos(angleInRadians) * speed);
        this.vy = (int) (Math.sin(angleInRadians) * speed);
        if (vx == 0 && Math.abs(vy) == 1) {
            serve();
        }
        //System.out.println(vx + ", " + vy);
        this.position = startPoint;
    }
    private boolean hitPaddle() {
        var paddle = vx < 0 ? game.leftPaddle : game.rightPaddle;
        if (position.x > Constants.PADDLE_WIDTH && getRightX() < Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH) {
            return false;
        }
        return position.y >= paddle.position.y && position.y <= paddle.getBottomY();
    }
    private void handlePaddleHit() {
        if (hitPaddle()) {
            this.vx *= -1;
        }
    }
    private void handleWallBounce() {
        if (position.y + vy >= Constants.SCREEN_HEIGHT || position.y + vy <= Constants.TOOLBAR_HEIGHT) {
            this.vy *= -1;
        }
    }
    private boolean isOutOfBounds() {
        return position.x <= 0 || getRightX() >= Constants.SCREEN_WIDTH;
    }
    private void handleScore() {
        if (!isOutOfBounds()) {
            return;
        }
        if (vx < 0) {
            game.incrementAIScore();
            //game.sideServing = game.rightSide;
        } else {
            game.incrementPlayerScore();
            game.sideServing = game.leftSide;
        }
        this.startPoint = null;
        this.endPoint = null;
        serve();
    }
    public Position getStartPoint() {
        return game.sideServing.getRandomServingStartPosition();
    }
    public Position getEndPoint() {
        Side sideServingTo = game.sideServing.equals(game.leftSide) ? game.rightSide : game.leftSide;
        Wall wallServingTo = sideServingTo.getRandomWall();
        return wallServingTo.getRandomPosition();
    }
    public static Position lerp(Position start, Position end, double t) {
        int x = (int) (start.x + t * (end.x - start.x));
        int y = (int) (start.y + t * (end.y - start.y));
        return new Position(x, y);
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(position.x, position.y, width, height);
    }

    public int getLeftX() {
        return position.x;
    }
    public int getRightX() {
        return position.x + width;
    }
    public int getTopY() {
        return position.y;
    }
    public int getBottomY() {
        return position.y + height;
    }
}
