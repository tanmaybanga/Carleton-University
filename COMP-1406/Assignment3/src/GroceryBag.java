/**
 * Created by Imran on 2017-02-05.
 */
public class GroceryBag {
    //Private Varibles decalred
    private static double MAX_WEIGHT = 5;
    private static int MAX_ITEMS = 25;
    private GroceryItem[] items;
    private int numitems;
    private float weight;
    private float maxWeight;

    //Get Statements
    public int getNumitems() {
        return numitems;
    }
    public float getWeight() {
        return weight;
    }
    public float getMaxWeight() {return maxWeight;}
    public GroceryItem[] getItems(){return items;}

    //Grocery Bag
    public GroceryBag() {
        items = new GroceryItem[MAX_ITEMS];
        numitems = 0;
        weight = 0.0f;
    }

    //To String That Prints During Test Code
    public String toString () {
        if (numitems > 0){
            return ("A " + weight + "kg Grocery Bag with " + numitems + " items");
            
        }
        else {
            return "An empty bag";
        }
    }

    //THe Function To Add Items
    public void addItem (GroceryItem item) {
        if (item.getWeight() + weight <= MAX_WEIGHT) {
            items [numitems] = item;
            numitems++;
            weight += item.getWeight();
        }
    }

    //THe Function To Remove ITems
    public void removeItem(GroceryItem item) {
        for (int i = 0; i < numitems; i++) {
            if (items[i] == item) {
                items[i] = items[numitems - 1];
                items[numitems - 1] = null;
                numitems -= 1;
                break;
            }
        }
    }

    //Finding our what the heaviest item in the basket was
    public GroceryItem heaviestItem() {
        if (numitems > 0) {
            GroceryItem heavy = items[0];
            for (int i = 1; i < numitems; i++) {
                if (items[i].getWeight() > heavy.getWeight()) {
                    heavy = items[i];
                }
            }
            return heavy;
        } else {
            return null;
        }
    }

    //HasGroceryItem Function
    public boolean has(GroceryItem item) {
        boolean result = false;
        for (int i = 0; i<getNumitems(); i++){
            if (item == items[i]) {
                result = true;
            }
        }
        return result;
    }
}

