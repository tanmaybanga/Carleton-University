
/**
 * Created by Imran on 2017-01-17.
 */

public class CustomerTestProgram {
    public static void main(String args[]) {
        Customer c;
        c = new Customer("Bob");
        c.name = "Bob";
        c.age = 17;
        c.money = 10;
        c.gender = 'M';

        System.out.println(c.name);
        System.out.println(c.age);
        System.out.println(c.money);
        System.out.println(c.gender);
    }
}