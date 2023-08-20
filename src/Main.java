import java.awt.*;

public class Main {
    Graphics2D g2;

    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        t1.start();
    }
}
