public class StoreTestProgram {
    public static void main(String args[]) {
        Customer[]   result;
        Store        walmart;

        walmart = new Store("Walmart off Innes");
        walmart.addCustomer(new Customer("Amie", 14, 'F', 100));
        walmart.addCustomer(new Customer("Brad", 15, 'M', 0));
        walmart.addCustomer(new Customer("Cory", 10, 'M', 100));
        walmart.addCustomer(new Customer("Dave", 5, 'M', 48));
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
        System.out.println("Here are the customers:\n");
        walmart.listCustomers();

        // Find average Customer age
        System.out.println("\nAverage age of customers: " + walmart.averageCustomerAge());

        // Find most popular gender
        System.out.println("\nMost popular gender is: " + walmart.mostPopularGender());

        // Find richest customer
        System.out.println("\nRichest customer is: " + walmart.richestCustomer());

        // Find male customers
        System.out.println("\n\nHere are all the male customers:");
        result = walmart.getCustomersWithGender('M');
        for (Customer c:  result)
            System.out.println(c);

        // Find female customers
        System.out.println("\n\nHere are all the female customers:");
        result = walmart.getCustomersWithGender('F');
        for (Customer c:  result)
            System.out.println(c);

        // Find friends for Amie
        System.out.println("\n\nFriends for 14 year old female Amie:");
        result = walmart.friendsFor(walmart.getCustomers()[0]);
        for (Customer c:  result) System.out.println(c);

        // Find friends for Brad
        System.out.println("\n\nFriends for 15 year old male Brad:");
        result = walmart.friendsFor(walmart.getCustomers()[1]);
        for (Customer c:  result) System.out.println(c);

    }
}