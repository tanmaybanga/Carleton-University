/**
 * Created by Imran on 2017-01-15.
 */

// Stating The Name Of The Created Class That We Have Built
public class HospitalBuilderProgram {

    //Displaying The Array For The Map
    private static byte[][][] maps = {

            // Map Cordiantes That Where Given In The Assingment Spec
            {{2, 2}, {2, 8}, {5, 15}, {19, 1}, {17, 17}},
            {{1, 1}, {7, 19}, {13, 19}, {19, 7}, {19, 13}},
            {{0, 19}, {2, 19}, {4, 19}, {6, 19}, {18, 19}},
            {{7, 19}, {13, 19}, {19, 19}, {19, 13}, {19, 7}}
    };

    //Introduction To Program
    public static void main(String[] args) {

        // 1/4 For Loop Of The Program
        // maps.length is our primary Function
        // Primary For Loop That goes though 4 times
        for (int r = 0; r < maps.length; r++) {

            //Initalizing our first function
            // Initalizing X and Y Points
            // Creating The Furthest Distance
            double smallest_distance_travaled = 1000;
            int perfect_x_point = 0, perfect_y_point = 0;
            int far_x_point = 0, far_y_point = 0;

            //Our Second For Loop
            //Value of "20" Was used, Because We Are Working With A 20x20 Grid
            for (int a2 = 0; a2 < 20; a2++) {

                //Our Third For Loop
                //Value of "20" Was used, Because We Are Working With A 20x20 Grid
                for (int b2 = 0; b2 < 20; b2++) {

                    //Initalizing 2 new functions, the current_Location and largest_traveled_Distance
                    double current_Location = 0, largest_travaled_Distance = 0;

                    //Our Fourth And Final For Loop
                    //Goves Over The Map Each Time The Program Sees
                    for (int p = 0; p < maps[r].length; p++) {


                        // This Will Calculate From Each Cordiantes From Each Hospital Town
                        int c1 = maps[r][p][0];
                        int d1 = maps[r][p][1];

                        //This is the equation that will determine our hospital distances given in the assignment spec
                        current_Location = Math.sqrt (Math.pow ( (a2-c1), 2) + Math.pow ( (b2-d1), 2) );

                        // If Statements Depicting what is the most Ideal Hospital To Go To By Distance
                        // After Determining, Storing The Needed Values
                        if (current_Location > largest_travaled_Distance) {
                            largest_travaled_Distance = current_Location;
                            far_x_point = a2;
                            far_y_point = b2;

                        }
                    }

                    //Creating and Finding the Biggest and Smallest Distance
                    // Then Finding Those X and Y Points
                    if (largest_travaled_Distance < smallest_distance_travaled) {
                        smallest_distance_travaled = largest_travaled_Distance;

                        //Determining Perfect Points
                        perfect_x_point = far_x_point;
                        perfect_y_point = far_y_point;

                    }
                }
            }

            //Giving Out The Result In A Printed Form
            System.out.println("The Hospital For Map " + (r + 1) + " Should Be Placed At: " + perfect_x_point + ", " + perfect_y_point);

        }
    }
}