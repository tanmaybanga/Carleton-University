/**
 * Created by Imran on 2017-01-25.
 */

//Customer Test Program, That Test's The Customer Class

public class CustomerTestProgram {
    public static void main(String args[]) {
        //As You Can See Our Varibles Match The Criteria
        CellPhone iPhone = new CellPhone("iPhone 6Plus", "Apple", 12, 400.00f);
        CellPhone galaxy = new CellPhone("Galaxy S7", "Samsung", 18, 200.00f);
        CellPhone priv = new CellPhone("PRIV", "BlackBerry", 24, 210.00f);

        //Print Statements, Printing The Correct Information
        System.out.println(new Customer("Rob Banks", iPhone, new PhonePlan(200, 2500000, false)));
        System.out.println(new Customer("Rita Book", priv, new PhonePlan(100, 500000, false)));
        System.out.println(new Customer("Sue Permann", iPhone, new PhonePlan(60, 2500000, false)));
        System.out.println(new Customer("Tim Bur", iPhone, new PhonePlan(30, 0, true)));
        System.out.println(new Customer("April Rain", galaxy, new PhonePlan(200, 1000000, true)));
    }
}
