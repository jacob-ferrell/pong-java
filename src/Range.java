import java.util.Random;

public class Range {
    public double min, max;
    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }
    public Range getSharedRange(Range otherRange) {
        double sharedMin = Math.max(this.min, otherRange.min);
        double sharedMax = Math.min(this.max, otherRange.max);

        if (sharedMin <= sharedMax) {
            return new Range(sharedMin, sharedMax);
        } else {
            return null;
        }
    }
    public double getAverage() {
        return min + ((max - min) / 2);
    }
    public double getRandom() {
        Random random = new Random();
        return random.nextDouble(this.min, this.max);
    }

    @Override
    public String toString() {
        return "[Min: " + this.min + ", Max:  "+ this.max + "]";
    }
}
