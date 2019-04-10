/**
 * Created by Imran Juma on 3/10/2017.
 */

import javafx.application.Application; // Used to import the application
import javafx.scene.Scene; // Allows the scene to work
import javafx.stage.Stage; // Allows the stage to work

// Assignment spec wanted us to extend the Application
// Creating our primary stage
// Setting Our fCount, and eCount - These Represent our Floor Count, and Exit Count
// Assignment Spec didn't specify what size to open the window at, but I felt 650 X 500 was a good value
// Launching Application

public class FloorBuilderApp extends Application {

    //Color Array Was Given In Assingment Spec
    public static final String[] ROOM_COLORS =
            {"ORANGE", "YELLOW", "LIGHTGREEN", "DARKGREEN",
                    "LIGHTBLUE", "BLUE", "CYAN", "DARKCYAN",
                    "PINK", "DARKRED", "PURPLE", "GRAY"
            };

    public void start(Stage primaryStage) {
        Building sampleEnviroment = new Building(5,5);
        primaryStage.setTitle("Floor Plan Builder");
        primaryStage.setScene(new Scene(new FloorBuilderView(sampleEnviroment.example()), 650, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}