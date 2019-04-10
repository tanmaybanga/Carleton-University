/**
 * Created by Imran on 2017-01-24.
 */
public class CellPhone {

    //Listing The Model And Information Given In Assingment Spec
    private String model;
    private String manufacturer;
    private int monthsWarranty;
    private float price;

    //Setting Our Inital Strings and the coresponding Letters that Attach
    public CellPhone (String m, String a, int w, float p) {
        model = m;
        manufacturer = a;
        monthsWarranty = w;
        price = p;
    }

    //Inserting A Blank Statement
    public CellPhone () {
        model = "UNKNOWN";
        manufacturer = "UNKNOWN";
        monthsWarranty = 0;
        price = 0;
    }

    //Get and Set Methods
    public String getModel() {return this.model;}
    public String getManufacturer() {return this.manufacturer; }
    public int getMonthsWarranty() {return  this.monthsWarranty;}
    public float getPrice() {return this.price;}

    //Get and Set Methods
    public void setModel (String m) { this.model = m;}
    public void setManufacturer (String a) {this.manufacturer = a;}
    public void setMonthsWarranty (int w) {this.monthsWarranty = w;}
    public void setPrice (float p) {this.price = p;}


}
