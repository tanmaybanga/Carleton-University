import javafx.geometry.Point2D;

public class Ball extends MovableObject implements Harmful{
    private boolean  isBeingHeld;

    public Ball(Point2D loc) {
        super(0, 0, loc);
        isBeingHeld = false;
    }

    // The get/set methods
    public int getDirection() { return direction; }
    public int getSpeed() { return speed; }
    public boolean isBeingHeld() { return isBeingHeld; }
    public void setDirection(int newDirection) { direction = newDirection; }
    public void setSpeed(int newSpeed) { speed = newSpeed; }
    public void setIsBeingHeld(boolean newHoldStatus) { isBeingHeld = newHoldStatus; }

    public String toString() {
        return "Ball" + " at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction +
                " degrees going " + speed + " pixels per second";
    }

    public void draw() {
        //System.out.println("Ball is at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction + " degrees and moving at " + speed + " pixels per second");
    }

    public void update() {
        moveForward();
        draw();
        if (speed > 0)
            speed -= 1;
    }

    public int getDamageAmount() {
        return -200;
    }

    public char appearance() { return 'O';}
}