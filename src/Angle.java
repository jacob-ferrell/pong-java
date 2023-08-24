
public class Angle {
    double x1, x2, y1, y2;
    double deltaX, deltaY;
    public double vx, vy;
    public double inRadians;
    public double inDegrees;
    public double againstVertical;
    public double ofReflection;
    public Angle(Position p1, Position p2) {
        x1 = p1.x;
        y1 = p1.y;
        x2 = p2.x;
        y2 = p2.y;
        deltaX = x2 - x1;
        deltaY = y2 - y1;
        init();
    }
    public Angle(double degrees) {
        this.inDegrees = degrees;
        this.inRadians = Math.toRadians(degrees);
        this.deltaX = Math.cos(inRadians);
        this.deltaY = Math.sin(inRadians);
        this.againstVertical = Math.PI / 2 - inRadians;
        this.ofReflection = Math.PI - inRadians;
    }
    private void init() {
        inRadians = Math.atan2(deltaY, deltaX);
        inDegrees = Math.toDegrees(inRadians);
        againstVertical = Math.PI / 2 - inRadians;
        ofReflection = Math.PI - inRadians;
    }
    public VelocityPair getVelocities() {
        return new VelocityPair(Math.cos(inRadians), Math.sin(inRadians));
    }
}
