/**
 * Created by Imran on 2017-01-17.
 */

public static
    public class Customer {

    public float computeFee () {
        if (age > 18f && age <= 64f)
            return 12.75f;
        else if (age <= 3f)
            return 0f;
        else if (age >= 65f)
            return 6.375f;
        else if (age >= 4f && age <= 17f)
            return 8.50f;
        else
            return 0;


    }


    public Customer (String n) {
        name = n;
        age = 0;
        gender= 'M';
        money = 0.0f;
    }

    public Customer (String n, int a, char g) {
        name = n;
        age = a;
        gender= g;
        money = 0.0f;
    }

    public Customer (String n, int a, char g, float m) {
        name = n;
        age = a;
        gender = g;
        money = m;
    }

    public Customer () {

    }



    String name;
    float age;
    float money;
    char gender;

}

