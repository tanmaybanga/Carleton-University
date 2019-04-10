import java.awt.geom.Point2D;

/**
 * Created by Imran on 2017-03-28.
 */
public class CollisionException extends Exception {
    public CollisionException() {
        super ("Payer Collided with Wall!");
    }

    public boolean contains (Point2D p) {
        // Returns true if p.x is in the range from "this.location.x to
        // (this.locaton.x+this.width-1) and id p.y is in the range from
        // this.location.y to this.location.y+this.heeight-1
        //otherwise return false
        return false;
    }
}