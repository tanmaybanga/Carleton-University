/**
 * Created by Imran on 2017-01-24.
 */
public class Customer {
    private String name;
    private int age;
    private char gender;
    private float money;
    private int id;

    //A Simple Constructor
    public Customer(String n, int a, char g, float m) {
        name = n;
        age = a;
        gender = g;
        money = m;

    }

    //Returning A String Reprentation of The Object
    public String toString() {
        String result;
        result = "Customer " + name + ": a " + age + " Year old ";

        if (gender == 'F')
            result += "fe";

        return result + "male with $" + money;

    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getId() { return id; }
    public char getGender() { return gender; }

    public boolean hasMoreMoneyThan(Customer c) {
        if (this.money > c.money) {
            return true;

        }
        else
            return false;

    }

    public void setId(int newID) {
        id = newID;
    }
}


