public class Range {
    public double min, max;
    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }
    public boolean includes(double n) {
        return n >= this.min && n <= this.max;
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

    @Override
    public String toString() {
        return "[Min: " + this.min + ", Max:  "+ this.max + "]";
    }
}
