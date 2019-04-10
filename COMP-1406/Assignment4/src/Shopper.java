/**
 * Created by Imran on 2017-02-15.
 */

public class Shopper {

    public static final int MAX_CART_ITEMS = 100;  // max # items allowed

    private Carryable[] cart;       // items to be purchased
    private int numItems;   // #items to be purchased

    public Shopper() {
        cart = new Carryable[MAX_CART_ITEMS];
        numItems = 0;
    }

    public Carryable[] getCart() {
        return cart;
    }

    public int getNumItems() {
        return numItems;
    }

    public String toString() {
        return "Shopper with shopping cart containing " + numItems + " items";
    }

    // Add an item to the shopper's shopping cart
    public void addItem(Carryable g) {
        cart[numItems] = g;
        numItems++;
    }

    // Removes the given item from the shopping cart
    public void removeItem(GroceryItem g) {
        for (int i = 0; i < numItems; i++) {
            if (cart[i] == g) {
                cart[i] = cart[numItems - 1];
                cart[numItems - 1] = null;
                numItems -= 1;
                break;
            }
        }
    }

    public void packBags() {
        //Make first grocery bag in packedBags (at position 0) and initialize bagCount variable
        Carryable[] packedBags = new GroceryBag[numItems];
        int bagCount = 0;

        //Make new grocery bag instance for the current bag we are filling with groceries
        GroceryBag currentBag = new GroceryBag();
        //Loop through the grocery items in the cart
        for (int i = 0; i < numItems; i++) {
            GroceryItem item = (GroceryItem) cart[i];
            //Check if the weight of the current item exceeds the maximum weight of a bag
            if (item.getWeight() <= GroceryBag.MAX_WEIGHT) {
                //If it doesn't, check to see if the bag has space for the current item
                if (!currentBag.canHold(item)) {
                    //If it does not have space increase the bagCount by one and add the current bag to the array of packedBags
                    // and create a new grocery bag
                    packedBags[bagCount++] = currentBag;
                    currentBag = new GroceryBag();
                }
                //Else, add the item to the current bag and remove it from the cart
                currentBag.addItem(item);
                removeItem(item);
                i--;
            }
        }
        //Check to see if a bag is empty
        if (currentBag.getWeight() > 0)
            packedBags[bagCount++] = currentBag;

        //Adding all the fully packed bags back to the cart
        for (int i = 0; i < bagCount; i++) {
            addItem(packedBags[i]);
        }
    }

    //Displays the contents of the cart
    public void displayCartContents() {
        for (int item = 0; item < numItems; item++) {
            System.out.println(cart[item].getDescription());
            System.out.println(cart[item].getContents());
        }
    }


    public PerishableItem[] removePerishables() {
        //Initialize new array for perishables
        PerishableItem[] removedPerishables = new PerishableItem[0];
        //Loop through cart to find instances of perishable items
        for (int i = 0; i < numItems;) {
            if (cart[i] instanceof PerishableItem) {

                //Once it finds an instance of a perishable item, it adds the item to a temporary array
                //and once everything is accounted for, adds the temporary array to the removed items array
                //and then removes the item from the cart
                PerishableItem[] perishableItems = removedPerishables;
                removedPerishables = new PerishableItem[removedPerishables.length + 1];
                for (int j = 0; j < perishableItems.length; j++) {
                    removedPerishables[j] = perishableItems[j];
                }
                removedPerishables[removedPerishables.length - 1] = (PerishableItem) cart[i];
                removeItem((GroceryItem) cart[i]);
            }

            //Else if it finds an instance of a grocery bag, it calls the unpackPerishables method on it and puts them in an array
            //Then loops through that array and puts them in a temporary perishableItems array
            // and then puts them all in the removed perishable array
            else if (cart[i] instanceof GroceryBag) {
                PerishableItem[] unpackedPerishables = ((GroceryBag) cart[i]).unpackPerishables();
                for (int x = 0; x < unpackedPerishables.length; x++) {
                    PerishableItem[] perishableItems = removedPerishables;
                    removedPerishables = new PerishableItem[removedPerishables.length + 1];
                    for (int y = 0; y < perishableItems.length; y++) {
                        removedPerishables[y] = perishableItems[y];
                    }
                    removedPerishables[removedPerishables.length - 1] = unpackedPerishables[x];
                }
                //Add 1 to the counter to proceed to the next item
                i++;
            }
            //If it is not a perishable item, add 1 to the counter to proceed to the next item
            else {
                i++;
            }
        }
        return removedPerishables;
    }

    // This WIll Give Us The Total Bill Of Items
    public float computeTotalCost() {
        float valuedCost = 0;
        for (int a = 0; a < numItems; a++) {
            valuedCost += cart[a].getPrice();
        }
        return valuedCost;
    }


    // This Will Give us The Bill OF Freezer Items Cost
    // Stating Our Inital Bill of 0 and Then Moving Forward From there
    public float computeFreezerItemCost() {
        float freezerValuedCost = 0;
        for (int i = 0; i < numItems; i++) {
            if (cart[i] instanceof FreezerItem) {
                freezerValuedCost += cart[i].getPrice();
            }
            else if (cart[i] instanceof GroceryBag){
                for (int a = 0; a < ((GroceryBag)cart[i]).getNumItems(); a++) {
                    if (((GroceryBag)cart[i]).getItems()[a] instanceof FreezerItem) {
                        freezerValuedCost += ((GroceryBag)cart[i]).getItems()[a].getPrice();
                    }
                }

            }
        }
        return freezerValuedCost;
    }


}


