import javafx.geometry.Point2D;

public class Trap extends StationaryObject{

    public Trap(Point2D loc) {
        //location = loc;
        super(loc);
    }

    public String toString() {
        return "Trap" + " at (" + (int)location.getX() + "," + (int)location.getY() + ")";
    }
    public void update() {

    }
}