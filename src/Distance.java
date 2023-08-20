public class Distance {
    public Distance() {

    }
    public static double getDistance(Position start, Position end) {
        int deltaX = end.x - start.x;
        int deltaY = end.y - start.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
