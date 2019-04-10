import javafx.geometry.Point2D;

public class Prize extends StationaryObject {
    private int      value;

    public Prize(Point2D loc, int val) {
        super(loc);
        value = val;
    }

    // The get/set methods
    public int getValue() { return value; }

    public String toString() {
        return "Prize" + " at (" + (int)location.getX() + "," + (int)location.getY() + ") with value " + value;
    }

    public char appearance() { return '$';}
}