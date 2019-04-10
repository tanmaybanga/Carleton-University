import javafx.geometry.Point2D;

/**
 * Created by ImranJuma on 2017-01-30.
 */
public abstract class MovableObject extends GameObject {
    protected int			direction;
    protected int 		speed;

    public MovableObject(int d, int s, Point2D loc){
        super(loc);
        direction = d;
        speed = s;

    }
    public void update(){
        moveForward();
        draw();
    }


    public void moveForward(){
        if (speed > 0)
            location = location.add((int) (Math.cos(Math.toRadians(direction))*speed),
                                    (int)(Math.sin(Math.toRadians(direction))* speed));
    }

    public abstract void draw();
}
