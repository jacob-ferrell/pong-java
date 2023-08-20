public class Pixel {
    public Position position;
    private Object occupiedBy;
    public Pixel(Position position) {
        this.position = position;
        occupiedBy = null;
    }

    public void setOccupiedBy(Object occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    public Object getOccupiedBy() {
        return occupiedBy;
    }

    public void clear() {
        this.occupiedBy = null;
    }
}
