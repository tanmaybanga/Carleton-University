import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * Created by Imran on 2017-03-20.
 */

public class BuildingDialog extends GridPane {
    Dialog buildingOverviewBox = new Dialog();
    GridPane aPane = new GridPane();

    TextField numberOfFloorsTextfield = new TextField();
    TextField numberOfExitsTextfield = new TextField();
    TextField numberOfRoomsTextfield = new TextField();
    TextField totalSizeTextfield = new TextField();

    Button directoryListingButton = new Button();
    ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);

    int amountOfRoomsPresent;
    int totalSquareFootage;

    public void display(Building model, int floorNumber, int exitNumber, int currentFloor, FloorPlan plan) {
        buildingOverviewBox.setTitle("Building Overview");
        buildingOverviewBox.setHeaderText(null);
        buildingOverviewBox.getDialogPane().getButtonTypes().addAll(okButtonType);

        aPane.setHgap(10);
        aPane.setVgap(10);
        aPane.setPadding(new Insets(10));

        aPane.add(new Label("Number of Floors:"), 0, 0);
        numberOfFloorsTextfield.setText("" + floorNumber);
        numberOfFloorsTextfield.setDisable(false);
        aPane.add(numberOfFloorsTextfield, 1, 0);

        aPane.add(new Label("Num Exits:"), 0,1);
        numberOfExitsTextfield.setText("" + exitNumber);
        numberOfExitsTextfield.setEditable(false);
        aPane.add(numberOfExitsTextfield,1,1);

        aPane.add(new Label("Num Rooms:"),0,2);
        FloorPlan[] masterFloorPlan = model.getFloorPlans();
        for (int a = 0; a < masterFloorPlan.length; a++) {
            int numRoomsOnFloor = masterFloorPlan[a].getNumberOfRooms();
            amountOfRoomsPresent += numRoomsOnFloor;
        }

        numberOfRoomsTextfield.setText("" + amountOfRoomsPresent);
        numberOfRoomsTextfield.setEditable(false);
        aPane.add(numberOfRoomsTextfield,1,2);


        aPane.add(new Label("Total Size:"),0,3);
        for(int x = 0; x < floorNumber; x++) {
            for (int r = 0; r < model.getFloorPlan(x).size(); r++) {
                for (int c = 0; c < model.getFloorPlan(x).size(); c++) {
                    if (!model.getFloorPlan(x).wallAt(r, c)) {
                        totalSquareFootage = totalSquareFootage + 1;
                    }
                }
            }
        }        totalSizeTextfield.setText("" + totalSquareFootage + " Sq. ft.");
        totalSizeTextfield.setEditable(false);
        aPane.add(totalSizeTextfield,1,3);

        buildingOverviewBox.getDialogPane().setContent(aPane);
        buildingOverviewBox.showAndWait();


    }
}
