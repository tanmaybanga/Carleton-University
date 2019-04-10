import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Player extends MovableObject {
    private String  name;
    private Color       color;
    private boolean  hasBall;
    private int    score;

    public Player(String n, Color c, Point2D loc, int dir) {
        super(dir, 0, loc);
        name = n;
        color = c;
        hasBall = false;
        score = 0;
    }

    // The get/set methods
    public int getDirection() { return direction; }
    public int getSpeed() { return speed; }
    public String getName() { return name; }
    public Color getColor() { return color; }
    public boolean hasBall() { return hasBall; }
    public int getScore() { return score; }
    public void setDirection(int newDirection) { direction = newDirection; }
    public void setSpeed(int newSpeed) { speed = newSpeed; }
    public void setHasBall(boolean newHasBall) { hasBall = newHasBall; }
    public void setScore(int newScore) { score = newScore; }

    public String toString() {
        String  s =  "Player" + " " + name + " at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction + " degrees";
        if (hasBall)
            s += " with the ball";
        return s;
    }

    public void draw() {
        //System.out.println("Player is at (" + (int)location.getX() + "," + (int)location.getY() + ") facing " + direction + " degrees and moving at " + speed + " pixels per second");
    }

    public char appearance() {
        switch(direction) {
            case 0: return '>';
            case 90: return '^';
            case 180: return '<';
            case 270: return 'V';
            default: return '.';
        }
    }
}