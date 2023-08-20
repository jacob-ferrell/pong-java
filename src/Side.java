import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Side {
    public String side;
    List<Wall> walls;
    public Side(String side) {
        this.side = side;
        walls = new ArrayList<>();
        buildWalls();
    }
    private void buildWalls() {
        int ind = side.equals(Constants.LEFT) ? 0 : 1;
        for (Position[][] startEnd : Constants.WALL_START_END_POINTS) {
            Wall wall = new Wall(startEnd[ind][0], startEnd[ind][1]);
            walls.add(wall);
        }
    }
    public Wall getRandomWall() {
        Random random = new Random();
        int randomInd = random.nextInt(3);
        return walls.get(randomInd);
    }
    public Position getRandomServingStartPosition() {
        int adjust = side.equals(Constants.LEFT) ? -(Constants.BALL_WIDTH + 5) : 5;
        return new Position(Constants.HZ_CENTER + adjust, Round.getRandomY());
    }

}
