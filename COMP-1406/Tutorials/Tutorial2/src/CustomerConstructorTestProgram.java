
public class CustomerConstructorTestProgram {
    public static void main(String args[]) {
        Customer c1, c2, c3, c4;

        c1 = new Customer("Bob", 17, 'M');
        c2 = new Customer("Dottie", 3, 'F', 10);
        c3 = new Customer("Jane");
        c4 = new Customer();

        System.out.println("====================================");
        System.out.println("Bob Looks Like This: " + c1.name + ", " + c1.age + ", " + c1.gender + ", " + c1.money + ", ");
        System.out.println("Dottie Looks Like This: " + c2.name + ", " + c2.age + ", " + c2.gender + ", " + c2.money + ", ");
        System.out.println("Jane Looks Like This: " + c3.name + ", " + c3.age + ", " + c3.gender + ", " + c3.money + ", ");
        System.out.println("Customer 4 Looks Like This: " + c4.name + ", " + c4.age + ", " + c4.gender + ", " + c4.money + ", ");
        System.out.println("====================================");
        System.out.println("Bob's Fee is $" + c1.computeFee());
        System.out.println("Dottie's Fee is $" + c2.computeFee());
        c3.age = 23;
        System.out.println("Janes Fee is $" + c3.computeFee());
        c4.age = 67;
        System.out.println("No Name's Fee is $" + c4.computeFee());
        System.out.println("====================================");


    }

}