/**
 * Created by Imran on 2017-02-05.
 */

/*
public class ShopperTestProgram {
    public static void main(String args[]) {
        GroceryItem g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11;

        g1 = new GroceryItem("Smart-Ones Frozen Entrees", 1.99f, 0.311f, true);
        g2 = new GroceryItem("SnackPack Pudding", 0.99f, 0.396f);
        g3 = new GroceryItem("Breyers Chocolate Icecream", 2.99f, 2.27f, true);
        g4 = new GroceryItem("Nabob Coffee", 3.99f, 0.326f);
        g5 = new GroceryItem("Gold Seal Salmon", 1.99f, 0.213f);
        g6 = new GroceryItem("Ocean Spray Cranberry Cocktail", 2.99f, 2.26f);
        g7 = new GroceryItem("Heinz Beans Original", 0.79f, 0.477f);
        g8 = new GroceryItem("Lean Ground Beef", 4.94f, 0.75f, true);
        g9 = new GroceryItem("5-Alive Frozen Juice", 0.75f, 0.426f, true);
        g10 = new GroceryItem("Coca-Cola 12-pack", 3.49f, 5.112f);
        g11 = new GroceryItem("Toilet Paper - 48 pack", 40.96f, 10.89f);

        // Make a new customer and add some items to his/her shopping cart
        Shopper c = new Shopper();
        c.addItem(g1);
        c.addItem(g2);
        c.addItem(g3);
        c.addItem(g4);
        c.addItem(g5);
        c.addItem(g6);
        c.addItem(g7);
        c.addItem(g8);
        c.addItem(g9);
        c.addItem(g10);
        c.addItem(g1);
        c.addItem(g6);
        c.addItem(g2);
        c.addItem(g2);
        c.addItem(g3);
        c.addItem(g3);
        c.addItem(g3);
        c.addItem(g3);
        c.addItem(g3);
        c.addItem(g10);
        c.addItem(g11);
        c.addItem(g9);
        c.addItem(g5);
        c.addItem(g6);
        c.addItem(g7);
        c.addItem(g8);
        c.addItem(g8);
        c.addItem(g8);
        c.addItem(g5);

        System.out.println("\nINITIAL CART CONTENTS:");
        for (int i = 0; i < c.getNumItems(); i++) {
            System.out.println(" " + c.getCart()[i]);
        }

        // Pack the bags and show the contents
        GroceryBag[] packedBags = c.packedBags();
        for (int i = 0; i < packedBags.length; i++) {
            System.out.println("\nBAG " + (i + 1) + " (Total Weight = " + packedBags[i].getWeight() + "kg) CONTENTS:");
            for (int j = 0; j < packedBags[i].getNumitems(); j++) {
                System.out.println(" " + packedBags[i].getItems()[j]);
            }
        }

        System.out.println("\nREMAINING CART CONTENTS:");
        for (int i = 0; i < c.getNumItems(); i++) {
            System.out.println(" " + c.getCart()[i]);
        }
    }
}

*/