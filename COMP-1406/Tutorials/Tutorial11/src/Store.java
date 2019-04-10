public class Store {
    public static final int MAX_CUSTOMERS = 500;
    public static int LATEST_ID = 1000000;

    private String      name;
    private Customer[]  customers;
    private int         customerCount;

    public Store(String n) {
        name = n;
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
    }

    public void addCustomer(Customer c) {
        if (customerCount < MAX_CUSTOMERS) {
            customers[customerCount++] = c;
            c.setId(LATEST_ID++);
        }
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void listCustomers() {
        for (int i=0; i<customerCount; i++)
            System.out.println(customers[i]);
    }

    public int averageCustomerAge() {
        int avg = 0;
        for (int i=0; i<customerCount; i++) {
            avg += customers[i].getAge();
        }
        return avg / customerCount;
    }

    public char mostPopularGender() {
        int mCount = 0, fCount = 0;

        for (int i=0; i<customerCount; i++) {
            if (customers[i].getGender() == 'M')
                mCount++;
            else
                fCount++;
        }
        if (mCount > fCount)
            return 'M';
        return 'F';
    }

    public Customer richestCustomer() {
        Customer richest = customers[0];
        for (int i=1; i<customerCount; i++) {
            if (customers[i].hasMoreMoneyThan(richest))
                richest = customers[i];
        }
        return richest;
    }

    public Customer[] getCustomersWithGender(char g) {
        int matchCount = 0;

        // Count them first
        for (int i=0; i<customerCount; i++) {
            if (customers[i].getGender() == g)
                matchCount++;
        }
        // Now make the array
        Customer[]  matches = new Customer[matchCount];
        matchCount = 0;
        for (int i=0; i<customerCount; i++) {
            if (customers[i].getGender() == g)
                matches[matchCount++] = customers[i];
        }
        return matches;
    }

    public Customer[] friendsFor(Customer lonelyCustomer) {
        int friendCount = 0;

        // Count them first
        for (int i=0; i<customerCount; i++) {
            if ((customers[i] != lonelyCustomer) &&
                    (customers[i].getGender() == lonelyCustomer.getGender()) &&
                    (Math.abs(customers[i].getAge() - lonelyCustomer.getAge()) <= 3)) {
                friendCount++;
            }
        }
        // Now make the array
        Customer[]  friends = new Customer[friendCount];
        friendCount = 0;
        for (int i=0; i<customerCount; i++) {
            if ((customers[i] != lonelyCustomer) &&
                    (customers[i].getGender() == lonelyCustomer.getGender()) &&
                    (Math.abs(customers[i].getAge() - lonelyCustomer.getAge()) <= 3)) {
                friends[friendCount++] = customers[i];
            }
        }
        return friends;
    }
}
