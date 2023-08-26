import java.awt.*;

public class Constants {
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 800;
    public static final int TOOLBAR_HEIGHT = 30;
    public static final String SCREEN_TITLE = "Pong";
    public static final double MOVEMENT_SPEED = 1;
    public static final double PADDLE_HEIGHT = 102;
    public static final double PADDLE_WIDTH = 5;
    public static final int V_CENTER = SCREEN_HEIGHT / 2;
    public static final int HZ_CENTER = SCREEN_WIDTH / 2;
    public static final double BALL_HEIGHT = 7;
    public static final double NET_WIDTH = 1;
    public static final int NET_SECTIONS = 10;
    public static final int POINTS_TO_WIN = 11;
    public static final double NET_X = HZ_CENTER - (NET_WIDTH / 2);
    public static final double BALL_WIDTH = 7;
    public static final double BALL_START_SPEED = 3;
    public static final double MAX_BALL_SPEED = 30;
    public static final double PADDLE_START_Y = V_CENTER - (PADDLE_HEIGHT / 2);
    public static final double LEFT_X_SERVE_START_POINT = HZ_CENTER - (PADDLE_WIDTH - 5);
    public static final double RIGHT_X_SERVE_START_POINT = HZ_CENTER + 5;
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 28);

    public static final double SCORE_WIDTH = 50.0;
    public static final Position LEFT_SCORE_POSITION = new Position(SCREEN_WIDTH * .1, TOOLBAR_HEIGHT + (SCREEN_HEIGHT * .1));
    public static final Position RIGHT_SCORE_POSITION = new Position(SCREEN_WIDTH * .9 - SCORE_WIDTH, TOOLBAR_HEIGHT + (SCREEN_HEIGHT * .1));
    public static final double MAX_ANGLE_STEEPNESS = 75.0;
    public static final double[] PADDLE_HORIZONTAL_ANGLES = {360, 180.0};
    public static final Position LEFT_PADDLE_START_POSITION = new Position(0, PADDLE_START_Y);
    public static final Position RIGHT_PADDLE_START_POSITION = new Position(SCREEN_WIDTH - PADDLE_WIDTH, PADDLE_START_Y);

}
