import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rectangle {
    public Position position;
    private final Color color = Color.WHITE;
    public final double width, height;
    public Rectangle(double width, double height, Position position) {
        this.width = width;
        this.height = height;
        this.position = position;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Rectangle2D.Double(this.position.x, this.position.y, width, height));
    }
    public HashMap<String, List<Position>> getCorners() {
        HashMap<String, List<Position>> corners = new HashMap<>();
        List<Position> leftCorners = new ArrayList<>(), rightCorners = new ArrayList<>();
        leftCorners.add(this.position);
        leftCorners.add(new Position(this.position.x, this.getBottomY()));
        corners.put(Constants.LEFT, leftCorners);
        rightCorners.add(new Position(this.getRightX(), this.position.y));
        rightCorners.add(new Position(this.getRightX(), this.getBottomY()));
        corners.put(Constants.RIGHT, rightCorners);
        return corners;
    }
    public double getRightX() {
        return position.x + width;
    }
    public double getBottomY() {
        return position.y + height;
    }
    public Range getYRange() {
        return new Range(this.position.y, this.getBottomY());
    }

}