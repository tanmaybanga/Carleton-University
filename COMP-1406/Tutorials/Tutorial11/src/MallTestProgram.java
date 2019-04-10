public class MallTestProgram {
    public static void main(String args[]) {
        // Make the mall
        Mall    trainyards = new Mall("Trainyards");

        // Make some stores
        Store   walmart, dollarama, michaels, farmBoy;
        trainyards.addStore(walmart = new Store("Walmart"));
        trainyards.addStore(dollarama = new Store("Dollarama"));
        trainyards.addStore(michaels = new Store("Michaels"));
        trainyards.addStore(farmBoy = new Store("Farm Boy"));

        // Create the customers
        Customer    c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
        Customer    c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26;
        c1 = new Customer("Amie", 14, 'F', 100);
        c2 = new Customer("Brad", 15, 'M', 0);
        c3 = new Customer("Cory", 10, 'M', 100);
        c4 = new Customer("Dave", 5, 'M', 48);
        c5 = new Customer("Earl", 21, 'M', 500);
        c6 = new Customer("Flem", 18, 'M', 1);
        c7 = new Customer("Gary", 8, 'M', 20);
        c8 = new Customer("Hugh", 65, 'M', 30);
        c9 = new Customer("Iggy", 43, 'M', 74);
        c10 = new Customer("Joan", 55, 'F', 32);
        c11 = new Customer("Kyle", 16, 'M', 88);
        c12 = new Customer("Lore", 12, 'F', 1000);
        c13 = new Customer("Mary", 17, 'F', 6);
        c14 = new Customer("Nick", 13, 'M', 2);
        c15 = new Customer("Omar", 18, 'M', 24);
        c16 = new Customer("Patt", 24, 'F', 45);
        c17 = new Customer("Quin", 42, 'M', 355);
        c18 = new Customer("Ruth", 45, 'F', 119);
        c19 = new Customer("Snow", 74, 'F', 20);
        c20 = new Customer("Tamy", 88, 'F', 25);
        c21 = new Customer("Ulsa", 2, 'F', 75);
        c22 = new Customer("Vern", 9, 'M', 90);
        c23 = new Customer("Will", 11, 'M', 220);
        c24 = new Customer("Xeon", 17, 'F', 453);
        c25 = new Customer("Ying", 19, 'F', 76);
        c26 = new Customer("Zack", 22, 'M', 35);

        // Add the customers to the stores
        walmart.addCustomer(c1);
        walmart.addCustomer(c3);
        walmart.addCustomer(c4);
        walmart.addCustomer(c5);
        walmart.addCustomer(c8);
        walmart.addCustomer(c12);
        walmart.addCustomer(c13);
        walmart.addCustomer(c14);
        walmart.addCustomer(c17);
        walmart.addCustomer(c19);
        walmart.addCustomer(c25);
        dollarama.addCustomer(c2);
        dollarama.addCustomer(c3);
        dollarama.addCustomer(c5);
        dollarama.addCustomer(c6);
        dollarama.addCustomer(c13);
        dollarama.addCustomer(c16);
        dollarama.addCustomer(c18);
        dollarama.addCustomer(c19);
        dollarama.addCustomer(c20);
        michaels.addCustomer(c1);
        michaels.addCustomer(c2);
        michaels.addCustomer(c7);
        michaels.addCustomer(c9);
        michaels.addCustomer(c15);
        michaels.addCustomer(c18);
        michaels.addCustomer(c22);
        michaels.addCustomer(c23);
        michaels.addCustomer(c24);
        michaels.addCustomer(c26);
        farmBoy.addCustomer(c1);
        farmBoy.addCustomer(c2);
        farmBoy.addCustomer(c5);
        farmBoy.addCustomer(c10);
        farmBoy.addCustomer(c11);
        farmBoy.addCustomer(c19);
        farmBoy.addCustomer(c21);
        farmBoy.addCustomer(c24);
        farmBoy.addCustomer(c25);

        // Determine whether or not certain customers shopped at the same store
        System.out.println("Did Amie and Xeon shop at the same store: " +
                trainyards.shoppedAtSameStore(c1, c24));
        System.out.println("Did Brad and Nick shop at the same store: " +
                trainyards.shoppedAtSameStore(c2, c14));

        // Determine the number of unique Customers in the mall
        System.out.println("The number of unique customers in the mall is: " + trainyards.uniqueCustomers());
    }
}