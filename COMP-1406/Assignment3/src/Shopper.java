/**
 * Created by Imran on 2017-02-05.
 */

//Inital Satatment
//Private Varibles
//100 Is USed Because Maximum Cart Items
public class Shopper {
    private static final int MAX_CART_ITEMS = 100;
    private GroceryItem[] cart;
    private GroceryBag[] bags;
    private int numItems;
    private float weight;


    //Get Statements
    public GroceryItem[] getCart() {
        return cart;
    }

    public int getNumItems() {
        return numItems;
    }

    public float getWeight() {
        return weight;
    }

    public int getMaxCartItems() {
        return MAX_CART_ITEMS;
    }

    //Shopper Class
    public Shopper() {
        cart = new GroceryItem[MAX_CART_ITEMS];
        numItems = 0;
    }


    //Our toString that prints during the test code with the nessesary varibles
    public String toString() {
        return ("Shopper with Shopping cart containing " + getNumItems() + " items");
    }

    //Adding Items function
    public void addItem(GroceryItem item) {
        if (numItems < MAX_CART_ITEMS) {
            cart[numItems] = item;
            numItems++;
        }
    }

    //Removing Items Function
    public void removeItem(GroceryItem item) {
        for (int a = 0; a < numItems; a++) {
            if (cart[a] == item) {
                cart[a] = cart[numItems];
                cart[numItems - 1] = null;
                numItems -= 1;
                break;
            }
        }
    }

}


//Packed Bags Didn't Work Sorry
//Perishable Didn't WOrk Sorry
