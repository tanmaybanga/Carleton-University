/**
 * Created by Imran on 2017-01-14.
 */

//This Imports The Java Scanner
import java.util.Scanner;

//Public Class
public class WaterLevelProgram {
    public static void main(String[] args) {

        //Initalizing The Varibles
        double waterLevel, waterCurrent;

        //Enables The Keys
        Scanner keyboard = new Scanner(System.in);

        //Printing The Inital question
        System.out.print("Please Enter The Current Water Level In Units MM: ");
        waterLevel = keyboard.nextDouble();

        //The Created "For Loop"
        for (int counter=1; counter<3; counter++) {
            waterCurrent = waterLevel;

            //Re-Printing The Original Question
            System.out.print("Please Enter The Current Water Level In Units MM: ");
            waterLevel = keyboard.nextDouble();

            //Showing The Answer
            // Added In The <= that way it knows not to equal all same showing Subsizing
            if (waterCurrent<=waterLevel) {
                //Set The Counter To 0
                counter = 0;
            }
        }

        //Statement Showing The Water Level Is Going Down
        System.out.print("The Current Water Level Is Subsizing");
    }
}