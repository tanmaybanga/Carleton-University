/**
 * Created by Imran on 2017-01-10.
 */

import java.util.Scanner;
public class TaxProgram {
    public static void main(String args[]) {
        double income, fedTax, provTax, baseProvtax, totalTax;
        int dependents;

        System.out.print ("Please Enter Your Taxable Income: "); // Askes User To Enter There Taxable Income
        income = new Scanner(System.in) .nextDouble();

        System.out.print ("Please Enter Your Number of Dependents: "); // Asks User How Many Dependednts They Have
        dependents = new Scanner(System.in) .nextInt();

        fedTax = 0.0;
        provTax = 0.0;
        totalTax = fedTax + provTax;

        if (income < 95990) { // Peramiters For Tax
            fedTax = 0.17 * income;
        } else if (income > 29590.01 && income < 59179.99) { // Peramiters For Tax
            fedTax = (0.17 * 29590) + (0.26 * (income - 29590));
        } else if (income >= 59180) {
            fedTax = (0.17 * 29590) + (0.26 * 29590) + (0.29 * (income - 59180)); // Peramiters For Tax
        }

        provTax = (0.425 * fedTax) - (160.50 + (328 * dependents));
        if (provTax < 0) {
            provTax = 0;
        }

        totalTax = (fedTax + provTax);

        System.out.println("Here is your tax breakdown:");
        System.out.println(String.format("%-15s%10.2f","Income", income));
        System.out.println(String.format("%-24s%d","Dependants", dependents));
        System.out.println("-------------------------");
        System.out.println(String.format("%-15s%10.2f","Federal Tax", fedTax));
        System.out.println(String.format("%-15s%10.2f","Provincial Tax", provTax));
        System.out.println("=========================");
        System.out.println(String.format("%-15s%10.2f","Total Tax", totalTax));

// Add Code Here

    }
}
