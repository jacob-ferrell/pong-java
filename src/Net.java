import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Net {
    private final double sectionHeight;
    private final double width;
    private final Range yRange;
    private final List<Rectangle> net;

    public Net() {
        this.yRange = new Range(Constants.TOOLBAR_HEIGHT, Constants.SCREEN_HEIGHT);
        double height = yRange.max - yRange.min;
        this.width = Constants.NET_WIDTH;
        int numberOfSections = Constants.NET_SECTIONS;
        this.sectionHeight = height / numberOfSections;
        this.net = getNet();

    }
    private List<Rectangle> getNet() {
        List<Rectangle> net = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var position = new Position(Constants.NET_X, (sectionHeight * 0.25) + (yRange.min + (sectionHeight * i)));
            var rect = new Rectangle(width, sectionHeight * 0.5, position);
            net.add(rect);
        }
        return net;
    }
    public void draw(Graphics2D g2) {
        for (Rectangle rect : net) {
            rect.draw(g2);
        }
    }
}
