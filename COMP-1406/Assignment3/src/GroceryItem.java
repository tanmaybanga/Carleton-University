/**
 * Created by Imran on 2017-02-04.
 */

//Assining Our Provate Varibles
public class GroceryItem {
    private String name;
    private boolean perishable;
    private float weight;
    private float price;

    // Assinging Our Public Varibles
    public String getName(){return name;}
    public float getPrice() {return price;}
    public float getWeight() {return weight;}
    public boolean getPerishable() {return perishable;}

    //Zero Peramiter
    public GroceryItem(){
        name = null;
        price = 0.0f;
        weight = 0.0f;
        perishable = false;
    }


    // Stating The New Peramiter
    public GroceryItem(String n, float p, float w){
        name = n;
        price = p;
        weight = w;
        perishable = false;

    }

    // ANother Set Of Peramiters
    public GroceryItem(String n, float p, float w, boolean per){
        name = n;
        price = p;
        weight = w;
        perishable = per;

    }

    //This Iis our toString that prints the statments we see in the test program
    public String toString(){
        return (getName() + " weighing " + getWeight() + "kg with price $" + getPrice());
    }


}
