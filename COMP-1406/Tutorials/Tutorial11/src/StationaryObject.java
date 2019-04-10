import javafx.geometry.Point2D;

public abstract class StationaryObject extends GameObject {
    public StationaryObject(Point2D loc) {
        super(loc);
    }
    public void update() {}
}
