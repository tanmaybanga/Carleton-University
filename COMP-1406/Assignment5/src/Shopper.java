public class Shopper {
    public static final int   MAX_CART_ITEMS = 100;  // max # items allowed

    private Carryable[]   cart;       // items to be purchased
    private int           numItems;   // #items to be purchased

    public Shopper() {
        cart = new Carryable[MAX_CART_ITEMS];
        numItems = 0;
    }

    public Carryable[] getCart() { return cart; }
    public int getNumItems() { return numItems; }

    public String toString() {
        return "Shopper with shopping cart containing " + numItems + " items";
    }

    // Return the total cost of the items in the cart
    public float totalCost() {
        float total = 0;
        for (int i=0; i<numItems; i++) {
            total += cart[i].getPrice();
        }
        return total;
    }

    // Add an item to the shopper's shopping cart
    public void addItem(Carryable g) {
        if (numItems < MAX_CART_ITEMS)
            cart[numItems++] = g;
    }

    // Removes the given item from the shopping cart
    public void removeItem(Carryable g) {
        for (int i=0; i<numItems; i++) {
            if (cart[i] == g) {
                cart[i] = cart[numItems - 1];
                numItems -= 1;
                return;
            }
        }
    }

    // Go through the shopping cart and pack all packable items into bags
    public void packBags() {
        GroceryBag[] packedBags = new GroceryBag[numItems];
        int   bagCount = 0;

        GroceryBag currentBag = new GroceryBag();
        for (int i=0; i<numItems; i++) {
            GroceryItem item = (GroceryItem)cart[i];
            if (item.getWeight() <= GroceryBag.MAX_WEIGHT) {
                if (!currentBag.canHold(item)) {
                    packedBags[bagCount++] = currentBag;
                    currentBag = new GroceryBag();
                }
                currentBag.addItem(item);
                removeItem(item);
                i--;
            }
        }
        // Check this in case there were no bagged items
        if (currentBag.getWeight() > 0)
            packedBags[bagCount++] = currentBag;

        // Now add the bags to the cart
        for (int i=0; i<bagCount; i++)
            addItem(packedBags[i]);
    }

    // Display the contents of the cart
    public void displayCartContents() {
        for (int i=0; i<numItems; i++) {
            System.out.println(cart[i].getDescription());
            System.out.print(cart[i].getContents());
        }
    }

    // Remoce and return all PerishableItems from the Shopping Cart
    public PerishableItem[] removePerishables() {
        PerishableItem[] pItems = new PerishableItem[MAX_CART_ITEMS];
        int pItemCount = 0;
        PerishableItem[] perishables;
        for (int i=0; i<numItems; i++) {
            if (cart[i] instanceof GroceryBag) {
                perishables = ((GroceryBag) cart[i]).unpackPerishables();
                for (int j=0; j<perishables.length; j++) {
                    pItems[pItemCount++] = perishables[j];
                }
            }
            else {
                if (cart[i] instanceof PerishableItem) {
                    pItems[pItemCount++] = (PerishableItem) cart[i];
                    removeItem(cart[i]);
                    i--;
                }
            }
        }

        // Now create the proper size array
        PerishableItem[] result = new PerishableItem[pItemCount];
        for (int i=0; i<pItemCount; i++)
            result[i] = pItems[i];
        return result;
    }

    // Return the amount of money that would be lost if the freezer breaks down
    public float computeFreezerItemCost() {
        float total = 0;
        for (int i=0; i<numItems; i++) {
            if (cart[i] instanceof GroceryBag) {
                GroceryItem[] itemsInBag = ((GroceryBag)cart[i]).getItems();
                for (GroceryItem item: itemsInBag) {
                    if (item instanceof FreezerItem)
                        total += item.getPrice();
                }
            }
            if (cart[i] instanceof FreezerItem)
                total += cart[i].getPrice();
        }
        return total;
    }

    // Return the total cost of all items in the packed cart
    public float computeTotalCost() {
        float total = 0;
        for (int i=0; i<numItems; i++)
            total += cart[i].getPrice();
        return total;
    }
}

