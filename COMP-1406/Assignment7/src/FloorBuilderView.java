/**
 * Created by Imran Juma on 3/10/2017.
 */

// These Are My Imports For The Application

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

// Assignment spec wanted us to extend the Application
// This Allowed me to have all the Labels all in one creation
// Having All of our RadioButtons all in one section

// All of our lables in program
// BuildingOverview Button Label
// Getting the model
//Peramiter for the building
// These are all the buttons that we used in the program
public class FloorBuilderView extends GridPane {
    RadioButton radioButton_wallSelection, radioButton_exitSelection, radioButton_roomTileSelection, radioButton_roomSelection; // All My Radio Buttons
    Button button_buildingOverview, button_colour; // My Buttons
    TextField TextField_Summary; // My TextField
    Label Label_selectOREdit, Label_floorLayout, Label_summary; // My Lables
    Building building; // My Building
    FloorPlan floorPlan; // My Floorplan


    // Running the view
    public FloorBuilderView(Building building) {

        // Setting the floorplan
        floorPlan = building.getFloorPlan(0);

        //The GridPane that our map is located in
        //Vbox for our Button
        GridPane mapView = new GridPane();
        VBox boxPane = new VBox();
        HBox box2Pane = new HBox();

        // These are the names that where used for our Radio Buttons
        // Naming The Building Overview Button
        // Making it the max value, so that it can exapand as much as possible
        // Naming the labels
        radioButton_wallSelection = new RadioButton("Walls");
        radioButton_exitSelection = new RadioButton("Exits");
        radioButton_roomTileSelection = new RadioButton("Room Tiles");
        radioButton_roomSelection = new RadioButton("Select Room");
        button_buildingOverview = new Button("Building Overview");
        button_buildingOverview.setPrefWidth(Integer.MAX_VALUE);
        button_colour = new Button();
        Label_summary = new Label("FLOOR SUMMARY:");
        TextField_Summary = new TextField();
        TextField_Summary.setPrefWidth(Integer.MAX_VALUE);
        Label_floorLayout = new Label("FLOOR LAYOUT"); // Naming The Label
        Label_selectOREdit = new Label("SELECT/EDIT"); // Naming The Label
        Label_selectOREdit.setMinWidth(100); // Setting How Big The Table is When You Resize The Window

        // Creating The Cube That Highlight Our Color
        box2Pane.getChildren().addAll(radioButton_roomTileSelection, button_colour);

        //This will add all of our Radiobuttons to the window
        boxPane.getChildren().addAll(radioButton_wallSelection, radioButton_exitSelection,
                box2Pane, radioButton_roomSelection, button_buildingOverview);

        // Setting Allingment of the box
        box2Pane.setAlignment(Pos.CENTER_RIGHT); // Making it Always To The Center Right
        box2Pane.setSpacing(12); // Setting Spacing Between Radio Button and box
        button_colour.setPrefWidth(25); // Making the box bigger to make it asthetically pleasing
        button_colour.setPrefHeight(25); // Making it a perfect square
        button_colour.setStyle("-fx-base: ORANGE;");
        boxPane.setPadding(new Insets(10)); // Setting the padding between the map and Radio Buttons
        boxPane.setSpacing(10); // Setting the spacing between the buttons
        boxPane.setMinWidth(150); // Making the button text fit in the indow

        // For Loop, with If and else if statement that assings our map, and colors the buttons in
        for(int a=0; a < floorPlan.size(); a++) {
            for(int b=0; b < floorPlan.size(); b++) {
                Button tyleSquare_presentTyle = new Button();

                if(building.exitAt(b,a) != null) {
                    tyleSquare_presentTyle.setStyle("-fx-base: RED;"); // Making The Red Exit Squares
                    tyleSquare_presentTyle.setText("EXIT"); // Making the Red Boxes Say Exit
                }
                else if(floorPlan.wallAt(a,b)) {
                    tyleSquare_presentTyle.setStyle("-fx-base: BLACK;"); // Setting The Black Sqaures
                }

                tyleSquare_presentTyle.setMinHeight(10); // Creating gap Between the map and window
                tyleSquare_presentTyle.setPrefHeight(Integer.MAX_VALUE); // Setting Max_Value
                tyleSquare_presentTyle.setMinWidth(10); // CreatingButton Width
                tyleSquare_presentTyle.setPrefWidth(Integer.MAX_VALUE); // Setting Max_Value
                mapView.add(tyleSquare_presentTyle, a, b); // Placing the map
                setPadding(new Insets(10)); // Setting Padding Underneath
            }
        }

        // Adding items to the pane
        add(Label_floorLayout,0,0); // Adding the Label to the pane
        add(mapView, 0,1); // Adding the map to the pane
        add(Label_selectOREdit,1,0); // Adding the Label to the pane
        add(boxPane,1,1); // adding the button to the pane
        add(Label_summary,0,2); // Adding Summmary Label to the pane
        add(TextField_Summary,0,3,2,1); // Adding Summmary Field to the pane
    }
}
