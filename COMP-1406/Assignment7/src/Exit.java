import javafx.geometry.Point2D;

public class Exit {
    private Point2D     location;   // The row/column coordinate of the exit in the building

    public Exit(int r, int c) {
        location = new Point2D(r,c);
    }

    public Point2D  getLocation() { return location; }
    public void setLocation(Point2D newLoc) { location = newLoc; }

    public boolean isAt(int r, int c) {
        return (location.getX() == r) && (location.getY() == c);
    }
}