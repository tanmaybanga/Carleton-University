import javafx.geometry.Point2D;

public abstract class MovableObject extends GameObject {
    protected Point2D   previousLocation;
    protected int  direction;
    protected int   speed;

    public abstract void draw();

    public void setLocation(Point2D newLocation) {
        previousLocation = location;
        location = newLocation;
    }

    public MovableObject(int d, int s, Point2D loc) {
        super(loc);
        previousLocation = location;
        direction = d;
        speed = s;
    }

    public void update() {
        moveForward();
        draw();
    }





    public void moveForward() {
        if (speed > 0) {
            previousLocation = location;
            location = location.add((int) (Math.cos(Math.toRadians(direction)) * speed),
                    -(int) (Math.sin(Math.toRadians(direction)) * speed));
        }
    }

    public Point2D getPreviousLocation() { return previousLocation; }
}
