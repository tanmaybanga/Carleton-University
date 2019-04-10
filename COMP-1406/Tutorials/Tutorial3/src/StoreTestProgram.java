public class StoreTestProgram {
    public static void main(String args[]) {
        Customer[]    result;
        Store walmart;
        walmart = new Store("Walmart off Innes");
        walmart.addCustomer(new Customer("Amie", 14, 'F', 100));
        walmart.addCustomer(new Customer("Brad", 15, 'M', 0));
        walmart.addCustomer(new Customer("Cory", 10, 'M', 100));
        walmart.addCustomer(new Customer("Dave", 5,'M', 48));
        walmart.addCustomer(new Customer("Earl", 21, 'M', 500));
        walmart.addCustomer(new Customer("Flem", 18, 'M', 1));
        walmart.addCustomer(new Customer("Gary", 8, 'M', 20));
        walmart.addCustomer(new Customer("Hugh", 65, 'M', 30));
        walmart.addCustomer(new Customer("Iggy", 43, 'M', 74));
        walmart.addCustomer(new Customer("Joan", 55, 'F', 32));
        walmart.addCustomer(new Customer("Kyle", 16, 'M', 88));
        walmart.addCustomer(new Customer("Lore", 12, 'F', 1000));
        walmart.addCustomer(new Customer("Mary", 17, 'F', 6));
        walmart.addCustomer(new Customer("Nick", 13, 'M', 2));
        walmart.addCustomer(new Customer("Omar", 18, 'M', 24));
        walmart.addCustomer(new Customer("Patt", 24, 'F', 45));
        walmart.addCustomer(new Customer("Quin", 42, 'M', 355));
        walmart.addCustomer(new Customer("Ruth", 45, 'F', 119));
        walmart.addCustomer(new Customer("Snow", 74, 'F', 20));
        walmart.addCustomer(new Customer("Tamy", 88, 'F', 25));
        walmart.addCustomer(new Customer("Ulsa", 2, 'F', 75));
        walmart.addCustomer(new Customer("Vern", 9, 'M', 90));
        walmart.addCustomer(new Customer("Will", 11, 'M', 220));
        walmart.addCustomer(new Customer("Xeon", 17, 'F', 453));
        walmart.addCustomer(new Customer("Ying", 19, 'F', 76));
        walmart.addCustomer(new Customer("Zack", 22, 'M', 35));
        System.out.println("Here Is The List Of Customers:\n");
        walmart.listCustomers();

        System.out.println("\nThe Average Customer Age Is: " + walmart.averageCustomerAge());

        System.out.println("\nThe Most Popular Gender Is: " + walmart.mostPopularGender());

        System.out.println("\nThe Richest Customer Is: " + walmart.richestCustomer());

    }
}
