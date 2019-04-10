public class Mall {
    public static final int MAX_STORES = 100;

    private String   name;
    private Store[]  stores;
    private int      storeCount;

    public Mall(String n) {
        name = n;
        stores = new Store[MAX_STORES];
        storeCount = 0;
    }

    public void addStore(Store s) {
        if (storeCount < MAX_STORES) {
            stores[storeCount++] = s;
        }
    }

    public boolean shoppedAtSameStore(Customer c1, Customer c2) {
        // Go through each store
        for (int i=0; i<storeCount; i++) {
            Customer[] customersInStore = stores[i].getCustomers();
            int numInStore = stores[i].getCustomerCount();
            boolean foundC1 = false, foundC2 = false;
            for (int j=0; j<numInStore; j++) {
                if (customersInStore[j] == c1)
                    foundC1 = true;
                if (customersInStore[j] == c2)
                    foundC2 = true;
            }
            if (foundC1 && foundC2)
                return true;
        }
        return false;
    }

    // Determine the total number of unique customers that have visited the mall
    public int uniqueCustomers() {
        // First determine how many customers are in the stores
        int total = 0;
        for (int i=0; i<storeCount; i++) {
            total += stores[i].getCustomerCount();
        }

        // Now go through and add all the customers to an array, as long as they are not already in there
        // Keep track of unique ones
        int unique = 0;
        Customer[]      uniqueCustomers = new Customer[total];

        for (int i=0; i<storeCount; i++) {
            Customer[]   customersInStore = stores[i].getCustomers();
            int          numInStore = stores[i].getCustomerCount();
            for (int j=0; j<numInStore; j++) {
                boolean found = false;
                for(int k=0; k<unique; k++) {
                    if (customersInStore[j] == uniqueCustomers[k])
                        found = true;
                }
                if (!found) {
                    uniqueCustomers[unique] = customersInStore[j];
                    unique++;
                }

            }
        }
        return unique;
    }
}
