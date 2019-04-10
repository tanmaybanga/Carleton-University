/**
 * Created by Imran on 2017-02-15.
 */
// This Is Where Perishable Item Will Extend The Grocery Item Class
public abstract class PerishableItem extends GroceryItem {

    // Empty Constructor
    public PerishableItem() {

    }

    // Here Again, We can Use Super insted of
    // p = price
    // w = weight
    // n = name
    public PerishableItem(String name, float price, float weight) {
        super(name, price, weight);
    }

    public String toString() {
        return super.toString() + " (perishable)";
    }

}
