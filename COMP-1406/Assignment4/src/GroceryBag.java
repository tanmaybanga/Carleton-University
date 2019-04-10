/**
 * Created by Imran on 2017-02-15.
 */

// Function Given By assingment Spec
public class GroceryBag implements Carryable {
    public static final float MAX_WEIGHT = 5;  // max weight allowed (kg)
    public static final int   MAX_ITEMS = 25;  // max # items allowed

    // Function Given By assingment Spec
    private GroceryItem[]   items;      // actual GroceryItems in bag
    private int             numItems;   // # of GroceryItems in bag
    private float           weight;     // current weight of bag

    // Function Given By assingment Spec
    public GroceryBag() {
        items = new GroceryItem[MAX_ITEMS];
        numItems = 0;
        weight = 0;
    }
    // Function Given By assingment Spec
    public GroceryItem[] getItems() { return items; }
    public int getNumItems() { return numItems; }
    public float getWeight() { return weight; }
    
 
    
    // Function Given By assingment Spec
    public String toString() {
        if (weight == 0)
            return "An empty grocery bag";
        return ("A " + weight + "kg grocery bag with " + numItems + " items");
    }
   
    // Function Given By assingment Spec
    public boolean canHold(GroceryItem g) {
        return (((weight + g.getWeight()) <= MAX_WEIGHT) && (numItems <= MAX_ITEMS));
    }
    
    // Function Given By assingment Spec
    public void addItem(GroceryItem g) {
        if (canHold(g)) {
            items[numItems] = g;
            weight += g.getWeight();
            numItems++;
        }
    }
  
    // Function Given By assingment Spec
    public void removeItem(GroceryItem item) {
        for (int i = 0; i < numItems; i++) {
            if (items[i] == item) {
                weight -= items[i].getWeight();
                items[i] = items[numItems - 1];
                numItems -= 1;
                return;
            }
        }
    }
    
    // Finds and returns the heaviest item in the shopping cart
    // Function Given By assingment Spec
    public GroceryItem heaviestItem() {
        if (numItems == 0)
            return null;
        GroceryItem heaviest = items[0];
        for (int i=0; i<numItems; i++) {
            if (items[i].getWeight() > heaviest.getWeight()) {
                heaviest = items[i];
            }
        }
        return heaviest;
    }
    
    // Determines whether or not the given item in the shopping cart
    // Function Given By assingment Spec
    public boolean has(GroceryItem item) {
        for (int i = 0; i < numItems; i++) {
            if (items[i] == item) {
                return true;
            }
        }
        return false;
    }

    // Remove all perishables from the bag and return an array of them
    // Some Changes Here Were made For Implementation
    // Changes Including Replacing PerishableItem With GroceryBag
    // Aswell AS Adding InstanceOf Function To Some Peramiters
    public PerishableItem[] unpackPerishables() {
        int perishableCount = 0;
        for (int i=0; i<numItems; i++) {
            if (items[i] instanceof PerishableItem)
                perishableCount++;
        }
        PerishableItem[] perishables = new PerishableItem[perishableCount];
        perishableCount = 0;
        for (int i=0; i<numItems; i++) {
            if (items[i] instanceof PerishableItem) {
                perishables[perishableCount++] = (PerishableItem) items[i];
                removeItem(items[i]);
                i--;
            }
        }
        return perishables;
    }
    
    // THis Function Will Get The Contents From The Bags
    public String getContents() {
        String iteemsInBag = "";
        for (int i = 0; i < numItems; i++) {
            iteemsInBag += "   " + items[i].toString() + "\n";
        }
        return iteemsInBag;
    }

    // Fucntion Provided So That We Could See What is In Each Bag, With A Weight Attribute
    public String getDescription() {
        return "Grocery bag (" + weight + "kg)";
    }

    // This WIll Be Our Get Price Function Collecting The Information on Each Item
    public float getPrice() {
        float totalGoodsValue = 0;
        for (int b = 0; b < numItems; b++) {
            totalGoodsValue += items[b].getPrice();
        }
        return totalGoodsValue;
    }

    // Static Float was used here to correctly implement the MaxWeight Function here
    public static float getMaxWeight() {
        return MAX_WEIGHT;
    }
}



