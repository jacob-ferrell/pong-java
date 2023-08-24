public class Distance {
    public Distance() {

    }
    public static double getDistance(Position start, Position end) {
        double deltaX = end.x - start.x;
        double deltaY = end.y - start.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
