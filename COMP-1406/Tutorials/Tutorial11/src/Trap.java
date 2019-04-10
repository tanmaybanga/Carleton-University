import javafx.geometry.Point2D;

public class Trap extends StationaryObject implements Harmful{
    public Trap(Point2D loc) {
        super(loc);
    }

    public String toString() {
        return "Trap" + " at (" + (int)location.getX() + "," + (int)location.getY() + ")";
    }
    public int getDamageAmount() {
        return -50;
    }
    public char appearance() { return '@';}
}