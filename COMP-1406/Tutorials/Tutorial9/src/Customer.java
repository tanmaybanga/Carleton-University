public class Customer {
    private int         id;
    private String      name;
    private int         age;
    private char        gender;
    private float       money;

    // A simple constructor
    public Customer(String n, int a, char g, float m) {
        name = n;
        age = a;
        gender = g;
        money = m;
        id = -1;
    }

    // Return a String representation of the object
    public String toString() {
        String   result;

        result = "Customer " + name + ": a " + age + " year old ";

        if (gender == 'F')
            result += "fe";

        return result + "male with $" + money;
    }

    public boolean hasMoreMoneyThan(Customer c) {
        return money > c.money;
    }

    // Get methods
    public String getName() { return name; }
    public int getAge() { return age; }
    public char getGender() { return gender; }
    public int getId() { return id; }

    // Set Methods
    public void setId(int newID) {
        id = newID;
    }

}
