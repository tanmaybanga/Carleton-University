/**
 * Created by Imran on 2017-01-24.
 */
public class Store {
    public static final int MAX_CUSTOMER = 500;
    public static int LATEST_ID = 100000;

    String name;
    Customer [] customers;
    int customerCount;

    public Store(String n) {
        name = n;
        customers = new Customer[MAX_CUSTOMER];
        customerCount = 0;
    }

    public void addCustomer(Customer c) {
        if (customerCount < MAX_CUSTOMER)
            customers[customerCount++] = c;
            c.setId(LATEST_ID);

    }

    public void listCustomers() {
        for (int i=0; i<customerCount; i++)
    System.out.println(customers[i]);
    }

    public int averageCustomerAge() {
        int sum = 0;
        int average = 0;
        for (int i=0; i<customerCount; i++){
            sum = sum + this.customers[i].getAge();
        }
        average = sum/customerCount;
        return average;
    }

    public char mostPopularGender(){
        char mostPopular;
        int male = 0;
        int female = 0;
        for (int i = 0; i < customerCount; i++){
            if (customers[i].getGender() == 'M'){
                male += 1;
            }
            else{
                female += 1;
            }
        }
        if (male > female){
            mostPopular = 'M';
        }
        else{
            mostPopular = 'F';
        }
        return mostPopular;
    }

    public Customer richestCustomer() {
        Customer temp = customers[0];
        float richest = 0;
        for (int i = 0; i < customerCount; i++) {
            if (!temp.hasMoreMoneyThan(customers[i])) {
                temp = customers[i];
            }
        }
        return temp;
    }



    }
