/**
 * Created by Imran on 2017-02-15.
 */

// Refrigerator Class Extends The Perishable Item Classs
public class RefrigeratorItem extends PerishableItem {

    // Empty Constructor
    public RefrigeratorItem() {super();}

    // Here We Can Use Super Insted Of Writing
    // n = name;
    // w = weight;
    // [ = price;
    public RefrigeratorItem(String n, float p, float w) {
        super(n, p, w);
    }

    // This is our toString That We Needed to implement to show what to keep reigerated
    public String toString() {
        return super.toString() + " [keep refrigerated]";
    }
}
