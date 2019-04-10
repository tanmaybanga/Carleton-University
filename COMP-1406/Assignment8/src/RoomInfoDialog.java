import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

/**
 * Created by Imran on 2017-03-20.
 */

public class RoomInfoDialog extends GridPane {

    public static final String[]    ROOM_COLORS = {"ORANGE", "YELLOW", "LIGHTGREEN", "DARKGREEN",
            "LIGHTBLUE", "BLUE", "CYAN", "DARKCYAN",
            "PINK", "DARKRED", "PURPLE", "GRAY"};


    public void display(Building model, int floorNumber, int r, int c, int currentColor, FloorPlan currentFloor, int colourIndex) {

        Room room = model.getFloorPlan(floorNumber).roomAt(r, c);

        Dialog roomInforDialogBox = new Dialog();
        roomInforDialogBox.setTitle("Room Details");
        roomInforDialogBox.setHeaderText(null);

        ButtonType myOkayButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        roomInforDialogBox.getDialogPane().getButtonTypes().addAll(myOkayButton, ButtonType.CANCEL);

        GridPane aPane = new GridPane();
        aPane.setHgap(10);
        aPane.setVgap(10);
        aPane.setPadding(new Insets(10, 10, 10, 10));

        TextField occupant = new TextField();
        occupant.setPromptText("Person who occupies this room");
        aPane.add(new Label("Occupant:"), 0, 0, 1, 1);
        aPane.add(occupant, 1, 0, 2, 1);

        TextField position = new TextField();
        position.setPromptText("Job position/title of this person");
        TextField number = new TextField();
        aPane.add(new Label("Position:"), 0, 1, 1, 1);
        aPane.add(position, 1, 1, 2, 1);

        number.setPromptText("The room number");
        TextField floor = new TextField();
        floor.setText(model.getFloorPlan(floorNumber).getName()); //change to value
        floor.setEditable(false);
        aPane.add(new Label("Number:"),0, 2,1,1);
        aPane.add(number, 1, 2,1,1);

        TextField size = new TextField();
        size.setText(String.valueOf(model.getFloorPlan(floorNumber).roomAt(r, c).getNumberOfTiles()) + " Sq. Ft.");
        size.setEditable(false);
        aPane.add(new Label("Size:"), 0, 4,1,1);
        aPane.add(size, 1, 4,2,1);

        Button colorButton = new Button();
        colorButton.setPrefWidth(175);
        colorButton.setStyle("-fx-base: " + ROOM_COLORS[currentColor] + ";");

        aPane.add(colorButton, 2,2,1,1);
        aPane.add(new Label("Floor:"), 0, 3,1,1);
        aPane.add(floor, 1, 3,2,1);

        occupant.setText(currentFloor.roomWithColor(colourIndex).getOccupant());
        position.setText(currentFloor.roomWithColor(colourIndex).getPosition());
        number.setText(currentFloor.roomWithColor(colourIndex).getNumber());

        roomInforDialogBox.getDialogPane().setContent(aPane);
        Optional result = roomInforDialogBox.showAndWait();

        if(result.isPresent() && result.get() == myOkayButton){
            currentFloor.roomWithColor(colourIndex).setOccupant(occupant.getText());
            currentFloor.roomWithColor(colourIndex).setPosition(position.getText());
            currentFloor.roomWithColor(colourIndex).setNumber(number.getText());
        }
    }

}

