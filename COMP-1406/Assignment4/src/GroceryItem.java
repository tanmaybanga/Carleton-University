/**
 * Created by Imran on 2017-02-15.
 */

// Public Strings
public class GroceryItem implements Carryable {
    private String      name;
    private float       price;
    private float       weight;

    // Constructor
    public GroceryItem() {
        name = "?";
        price = 0;
        weight = 0;
    }

    // This Was Our Needed toString
    public String toString () {
        return name + " weighing " + weight + "kg with price $" + price;
    }

    // Regular Sorting Not Using Super
    public GroceryItem(String n, float p, float w) {
        name = n;
        price = p;
        weight = w;
    }

    // Get and set methods
    public String getName() {

        return name;
    }
    public float getPrice() {

        return price;
    }
    public float getWeight() {

        return weight;
    }
    public String getContents() {

        return "";
    }
    public String getDescription() {

        return name;
    }


}
