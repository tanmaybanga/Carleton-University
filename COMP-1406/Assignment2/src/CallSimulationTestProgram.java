/**
 * Created by Imran on 2017-01-24.
 */

//Call Simulation Program That WAs Giveb IN THe Assingment Spec

public class CallSimulationTestProgram {
    public static void main(String args[]) {
        // Create some phone objects
        CellPhone iPhone = new CellPhone("iPhone 6Plus", "Apple", 12, 915.00f);
        CellPhone galaxy = new CellPhone("Galaxy S7", "Samsung", 18, 900.00f);
        CellPhone priv = new CellPhone("PRIV", "BlackBerry", 12, 890.00f);
        // Create some customer objects. Only Tim and April have a "pay-as-you-go" plan
        // (identified by a true Boolean value), the others are on standard monthly plans
        // (identified by a false Boolean value). Realistically, these purchases would
        // occur at different times on different days but we are assuming that all 5
        // Customers purchase at the same time.
        Customer rob = new Customer("Rob Banks", iPhone, new PhonePlan(200, 2500000, false));
        Customer april = new Customer("April Rain", galaxy, new PhonePlan(200, 1000000, true));
        Customer rita = new Customer("Rita Book", priv, new PhonePlan(100, 500000, false));
        Customer sue = new Customer("Sue Permann", iPhone, new PhonePlan(100, 2500000, false));
        Customer tim = new Customer("Tim Bur", iPhone, new PhonePlan(30, 0, true));
        // Show the Customers
        System.out.println("Here are the customers:");
        System.out.println(rob);
        System.out.println(april);
        System.out.println(rita);
        System.out.println(sue);
        System.out.println(tim);
        // Have the customers make some phone calls to other customers
        rob.phone(sue, 12); // a 12 minute call from Rob's phone to Sue's phone
        rita.phone(april, 27);
        rob.phone(tim, 3);
        tim.phone(rita, 19);
        // This line now assumes that Tim's call was cut off after 8 minutes,
        // because his plan only allows 8 more minutes.
        tim.phone(sue, 8);
        // Output to show how the remaining unused minutes on each account
        // have changed
        System.out.println("\nRob's minutes = " + rob.getPlan().getMinutesRemaining());
        System.out.println("April's minutes = "+ april.getPlan().getMinutesRemaining());
        System.out.println("Rita's minutes = " + rita.getPlan().getMinutesRemaining());
        System.out.println("Sue's minutes = " + sue.getPlan().getMinutesRemaining());
        System.out.println("Tim's minutes = " + tim.getPlan().getMinutesRemaining());
        // Try some more calls
        rob.phone(tim, 1); // Should not connect at all
        rob.phone(sue, 1);
        sue.phone(tim, 1); // Should not connect at all
        // Tim gets his phone working again by paying for more minutes
        tim.buyMinutes(100);
        // Output to show how the remaining unused minutes on Tim's account has changed
        System.out.println("\nTim's minutes = " + tim.getPlan().getMinutesRemaining());
        // Tim lets Rob know that his phone is working again.
        // Then Rob tells Sue who then phones Tim to chat.
        tim.phone(rob, 24); // OK now rob.phone(sue, 15);
        sue.phone(tim, 68); // Sue's limit will exceed and she must pay extra
        rita.phone(sue, 65); // Both customers exceed their minutes and must pay extra
        // Output to show how the remaining unused minutes on each account have changed
        System.out.println("\nRob's minutes = " + rob.getPlan().getMinutesRemaining());
        System.out.println("April's minutes = "+ april.getPlan().getMinutesRemaining());
        System.out.println("Rita's minutes = " + rita.getPlan().getMinutesRemaining());
        System.out.println("Sue's minutes = " + sue.getPlan().getMinutesRemaining());
        System.out.println("Tim's minutes = " + tim.getPlan().getMinutesRemaining());
        // Now simulate internet data access
        rob.accessInternet(45600); // used up 45.6MB
        rita.accessInternet(2700000); // use up 2.7GB
        rob.accessInternet(1200000); // use up 1.2GB
        tim.accessInternet(10000); // attempt to use 10MB ... won't work
        sue.accessInternet(2500000); // used up exactly 2.5GB
        april.accessInternet(1900000); // attempt to use 1.9GB, only 1GB used, then stops
        // Output to show how the remaining unused data on each account have changed
        System.out.println("\nRob's data = " + rob.getPlan().getDataRemaining() + "KB");
        System.out.println("April's data = "+ april.getPlan().getDataRemaining() + "KB");
        System.out.println("Rita's data = " + rita.getPlan().getDataRemaining() + "KB");
        System.out.println("Sue's data = " + sue.getPlan().getDataRemaining() + "KB");
        System.out.println("Tim's data = " + tim.getPlan().getDataRemaining() + "KB");
        // Pretend that the month is over and print out all of the billing statements
        rob.printMonthlyStatement();
        april.printMonthlyStatement();
        rita.printMonthlyStatement();
        sue.printMonthlyStatement();
        tim.printMonthlyStatement();
    }
}