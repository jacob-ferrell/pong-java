public class Constants {
    public static final int SCREEN_WIDTH = 800;
    public static final int NUM_PADDLE_SECTIONS = 3;
    public static final int SCREEN_HEIGHT = 800;
    public static final int TOOLBAR_HEIGHT = 30;
    public static final String SCREEN_TITLE = "Pong";
    public static final double MOVEMENT_SPEED = 1;
    public static final double PADDLE_HEIGHT = 102;
    public static final double PADDLE_WIDTH = 5;
    public static final int V_CENTER = SCREEN_HEIGHT / 2;
    public static final int HZ_CENTER = SCREEN_WIDTH / 2;
    public static final double BALL_HEIGHT = 5;
    public static final double BALL_WIDTH = 5;
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static final double BALL_START_SPEED = 3;
    public static final double MAX_BALL_SPEED = 30;
    public static final double PADDLE_START_Y = V_CENTER - (PADDLE_HEIGHT / 2);
    public static final double MAX_ANGLE_STEEPNESS = 75.0;
    public static final double[] PADDLE_HORIZONTAL_ANGLES = {360, 180.0};
    public static final double[] PADDLE_SECTION_REFLECTION_ANGLES = {320.0, 0.0, 55.0};
    public static final Position LEFT_PADDLE_START_POSITION = new Position(0, PADDLE_START_Y);
    public static final Position RIGHT_PADDLE_START_POSITION = new Position(SCREEN_WIDTH - PADDLE_WIDTH, PADDLE_START_Y);
    public static Position[][] TOP_WALL_POINTS = {
            {new Position(1, 0), new Position(HZ_CENTER / 2, 0)},
            {new Position(HZ_CENTER + (HZ_CENTER / 2), 0), new Position(SCREEN_WIDTH - 1, 0)}
    };
    public static Position[][] SIDE_WALL_POINTS = {
            {new Position(0, 1), new Position(0, SCREEN_HEIGHT - 1)},
            {new Position(SCREEN_WIDTH, 1), new Position(SCREEN_WIDTH, SCREEN_HEIGHT - 1)}
    };
    public static Position[][] BOTTOM_WALL_POINTS = {
            {new Position(1, SCREEN_HEIGHT), new Position((HZ_CENTER / 2), SCREEN_HEIGHT)},
            {new Position(HZ_CENTER + (HZ_CENTER / 2), SCREEN_HEIGHT), new Position(SCREEN_WIDTH - 1, SCREEN_HEIGHT)}
    };
    public static Position[][][] WALL_START_END_POINTS = {
            TOP_WALL_POINTS,
            SIDE_WALL_POINTS,
            BOTTOM_WALL_POINTS
    };
}
