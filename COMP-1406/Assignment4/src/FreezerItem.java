/**
 * Created by Imran on 2017-02-15.
 */

// This is our Freezer Item Class that extends From Perisbale Item
public class FreezerItem extends PerishableItem {

    // Empty Constructor
    public FreezerItem() {

    }

    // Here We Are able to use super insted of writing
    // n = name
    // p = price
    // w = weight
    // We Are Able To Do this because we are extending From Another Class
    public FreezerItem(String n, float p, float w) {
        super(n, p, w);
    }



    // This is our Implemented toString
    public String toString() {
        return super.toString() + " [keep frozen]";
    }
}
