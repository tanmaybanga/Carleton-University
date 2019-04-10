/**
 * Created by Imran on 2017-02-05.
 */

public class GroceryBagTestProgram {
    public static void main(String args[]) {
        GroceryItem g1, g2, g3, g4, g5, g6;
        GroceryBag b1, b2;

        g1 = new GroceryItem("Jumbo Cherries", 6.59f, 1.0f);
        g2 = new GroceryItem("Smart-Ones Frozen Entrees", 1.99f, 0.311f, true);
        g3 = new GroceryItem("SnackPack Pudding", 0.99f, 0.396f);
        g4 = new GroceryItem("Nabob Coffee", 3.99f, 0.326f);
        g5 = new GroceryItem("Fresh Salmon", 4.99f, 0.413f, true);
        g6 = new GroceryItem("Coca-Cola 12-pack", 3.49f, 5);

        b1 = new GroceryBag();
        b2 = new GroceryBag();

        b1.addItem(g1);
        b1.addItem(g2);
        b1.addItem(g3);
        b1.addItem(g4);
        b1.addItem(g5);
        b1.addItem(g5);
        b1.addItem(g5);

        System.out.println("BAG 1: " + b1);
        for(int i=0; i<b1.getNumitems(); i++)
            System.out.println(" " + b1.getItems()[i]);
        System.out.println("BAG 2: " + b2);
        System.out.println("\nHeaviest item in BAG 2: " + b2.heaviestItem());

        b1.addItem(g6);
        b2.addItem(g6);

        System.out.println("\nBAG 1: " + b1);
        System.out.println("BAG 2: " + b2);

        System.out.println("\nBAG 1 contains Nabob Coffee: " + b1.has(g4));
        System.out.println("BAG 1 contains a case of coke: " + b1.has(g6));
        System.out.println("BAG 2 contains a case of coke: " + b2.has(g6));
        System.out.println("\nHeaviest item in BAG 1: " + b1.heaviestItem());
        System.out.println("Heaviest item in BAG 2: " + b2.heaviestItem());
    }
}