public class Angle {
    double x1;
    double y1;
    double x2;
    double y2;
    double deltaX;
    double deltaY;
    public double inRadians;
    public double inDegrees;
    public Angle(Position p1, Position p2) {
        x1 = p1.x;
        y1 = p1.y;
        x2 = p2.x;
        y2 = p2.y;
        deltaX = x2 - x1;
        deltaY = y2 - y1;
        inRadians = Math.atan2(deltaY, deltaX);
        inDegrees = Math.toDegrees(inRadians);
    }
}
