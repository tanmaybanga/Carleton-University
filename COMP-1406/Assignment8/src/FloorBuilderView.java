import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;

/**
 * Created by Imran on 2017-03-20.
 */

public class FloorBuilderView extends GridPane {
    public static final String[]    ROOM_COLORS = {"ORANGE", "YELLOW", "LIGHTGREEN", "DARKGREEN",
                                                   "LIGHTBLUE", "BLUE", "CYAN", "DARKCYAN",
                                                     "PINK", "DARKRED", "PURPLE", "GRAY"};

    // These are the tiles and buttons
    private GridPane        tiles;
    private Button[][]      buttons;
    private RadioButton     editWallsButton;
    private RadioButton     selectExitsButton;
    private RadioButton     editRoomsButton;
    private RadioButton     defineRoomsButton;
    private Button          colorButton;
    private Button          overviewButton;
    private TextField       summaryField;

    public Button getFloorTileButton(int r, int c) { return buttons[c][r]; }
    public Pane getTilePanel() { return tiles; }
    public RadioButton getEditWallsButton() { return editWallsButton; }
    public RadioButton getSelectExitsButton() { return selectExitsButton; }
    public RadioButton getEditRoomsButton() { return editRoomsButton; }
    public RadioButton getDefineRoomsButton() { return defineRoomsButton; }
    public Button getRoomColorButton() { return colorButton; }
    public Button getBuildingOverviewButton() { return overviewButton; }
    public TextField getSummaryField() { return summaryField; }

    private MenuItem firstFloor;
    private MenuItem secondFloor;
    private MenuItem thirdFloor;
    private MenuItem fourthFloor;
    private MenuItem basement;


    public MenuItem getFirstFloor() {return firstFloor;}
    public MenuItem getSecondFloor() {return secondFloor;}
    public MenuItem getThirdFloor() {return thirdFloor;}
    public MenuItem getFourthFloor() {return fourthFloor;}
    public MenuItem getBasement() {return basement;}
    // Get and Set Methods for each classs


    private Building       model;

    public FloorBuilderView(Building m) {
        model = m;

        // Setup the pane with the floor plan buttons
        buttons = new Button[model.getFloorPlan(0).size()][model.getFloorPlan(0).size()];
        tiles = new GridPane();
        tiles.setPadding(new Insets(0, 0, 0, 10));
        for (int r=0; r<model.getFloorPlan(0).size(); r++) {
            for (int c=0; c<model.getFloorPlan(0).size(); c++) {
                buttons[r][c] = new Button();
                buttons[r][c].setPrefWidth(200);
                buttons[r][c].setPrefHeight(200);
                buttons[r][c].setMinHeight(10);
                buttons[r][c].setMinWidth(10);
                tiles.add(buttons[r][c], r, c);
            }
        }
        add(tiles, 0, 2, 1, 6);

        // Add the labels
        Label label = new Label("FLOOR LAYOUT");
        add(label,0,1,1,1);
        label.setMinHeight(30);
        label.setMinWidth(100);
        setMargin(label, new Insets(0, 0, 0, 10));

        label = new Label("SELECT/EDIT:");
        add(label,1,1,1,1);
        label.setMinHeight(30);
        label.setMinWidth(100);
        setMargin(label, new Insets(0, 0, 0, 0));

        label = new Label("FLOOR SUMMARY:");
        add(label,0,8,1,1);
        label.setMinHeight(30);
        label.setMinWidth(100);
        setMargin(label, new Insets(0, 0, 0, 10));

        // Add the Editting buttons
        ToggleGroup operations = new ToggleGroup();
        editWallsButton = new RadioButton("Walls");
        editWallsButton.setToggleGroup(operations);
        editWallsButton.setSelected(true);
        add(editWallsButton,1,2,2,1);
        editWallsButton.setMinHeight(30);
        editWallsButton.setMinWidth(70);
        setMargin(editWallsButton, new Insets(0, 0, 0, 20));

        selectExitsButton = new RadioButton("Exits");
        selectExitsButton.setToggleGroup(operations);
        add(selectExitsButton,1,3,2,1);
        selectExitsButton.setMinHeight(30);
        selectExitsButton.setMinWidth(70);
        setMargin(selectExitsButton, new Insets(0, 0, 0, 20));

        editRoomsButton = new RadioButton("Room Tiles");
        editRoomsButton.setToggleGroup(operations);
        add(editRoomsButton,1,4,1,1);
        editRoomsButton.setMinHeight(30);
        editRoomsButton.setMinWidth(80);
        setMargin(editRoomsButton, new Insets(0, 20, 0, 20));

        defineRoomsButton = new RadioButton("Select Room");
        defineRoomsButton.setToggleGroup(operations);
        add(defineRoomsButton,1,5,2,1);
        defineRoomsButton.setMinHeight(30);
        defineRoomsButton.setMinWidth(80);
        setMargin(defineRoomsButton, new Insets(0, 20, 0, 20));

        // Add the room color label
        colorButton = new Button();
        add(colorButton,2,4,1,1);
        colorButton.setMinHeight(30);
        colorButton.setMinWidth(30);
        colorButton.setPrefWidth(30);
        colorButton.setStyle("-fx-base: WHITE;");
        setMargin(colorButton, new Insets(0, 10, 0, 0));

        // Add the Building Overview button
        overviewButton = new Button("Building Overview");
        add(overviewButton,1,6,2,1);
        overviewButton.setMinHeight(30);
        overviewButton.setMinWidth(140);
        overviewButton.setPrefWidth(140);
        setMargin(overviewButton, new Insets(20, 0, 0, 10));
        setValignment(overviewButton, VPos.TOP);
        setHalignment(overviewButton, HPos.LEFT);

        // Add the summary Field
        summaryField = new TextField("");
        add(summaryField,0,9,3,1);
        summaryField.setMinHeight(30);
        summaryField.setMinWidth(300);
        summaryField.setEditable(false);
        setMargin(summaryField, new Insets(0, 10, 10, 10));
    }

    public void update(int currentFloor, int currentColor) {
        int dimension = model.getFloorPlan(currentFloor).size();

        // Update the Room Color Button
        colorButton.setDisable(!editRoomsButton.isSelected());
        colorButton.setStyle("-fx-base: " + ROOM_COLORS[currentColor] + ";");

        // Update the walls, exits and room colors
        for (int r=0; r<dimension; r++) {
            for (int c=0; c<dimension; c++) {
                if (model.exitAt(c,r) != null) {
                    buttons[r][c].setText("EXIT");
                    buttons[r][c].setStyle("-fx-base: RED; -fx-text-fill: WHITE;");
                }
                else if (model.getFloorPlan(currentFloor).wallAt(c,r)) {
                    buttons[r][c].setText("");
                    buttons[r][c].setStyle("-fx-base: BLACK;");
                }
                else if (model.getFloorPlan(currentFloor).roomAt(c,r) != null) {
                    Room off = model.getFloorPlan(currentFloor).roomAt(c,r);
                    buttons[r][c].setText("");
                    buttons[r][c].setStyle("-fx-base: " + ROOM_COLORS[off.getColorIndex()]  + ";");
                }
                else {
                    buttons[r][c].setText("");
                    buttons[r][c].setStyle("-fx-base: WHITE;");
                }
            }
        }

        // Update the summary field
        summaryField.setText(model.getFloorPlan(currentFloor).getName() + " with " +  model.getFloorPlan(currentFloor).getNumberOfRooms() + " rooms.");
    }
}