import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Imran on 2017-03-20.
 */

public class FloorBuilderApp extends Application  {
    private VBox aPane;
    private FloorBuilderView   view;
    private Building           model;
    private int                currentFloor;    // Index of the floor being displayed
    private int                currentColor;    // Index of the current room color
    public int getCurrentFloor() {return currentFloor;}

    public void start(Stage primaryStage) {
        aPane = new VBox();
        model = Building.example();
        currentFloor = 0;
        currentColor = 0;

        VBox aPane = new VBox();
        view = new FloorBuilderView(model);
        view.setPrefWidth(Integer.MAX_VALUE);
        view.setPrefHeight(Integer.MAX_VALUE);


        Menu dropDownMenu = new Menu("_Select Floor");
        MenuBar menuBar = new MenuBar();

        // Adding Floors to the drop down menu
        MenuItem mainFloorDropDownMenu = new MenuItem(model.getFloorPlan(0).getName());
        MenuItem secondFloorDropDownMenu = new MenuItem(model.getFloorPlan(1).getName());
        MenuItem thirdFloorDropDownMenu = new MenuItem(model.getFloorPlan(2).getName());
        MenuItem fourthFloorDropDownMenu = new MenuItem(model.getFloorPlan(3).getName());
        MenuItem basementFloorDropDownMenu = new MenuItem(model.getFloorPlan(4).getName());

        menuBar.getMenus().addAll(dropDownMenu);
        aPane.getChildren().add(menuBar);

        dropDownMenu.getItems().addAll(fourthFloorDropDownMenu, thirdFloorDropDownMenu, secondFloorDropDownMenu, mainFloorDropDownMenu, new SeparatorMenuItem(), basementFloorDropDownMenu);

        mainFloorDropDownMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                currentFloor = 0;
                view.update(currentFloor, currentColor);
            }});

        secondFloorDropDownMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                currentFloor = 1;
                view.update(currentFloor, currentColor);
            }});


        thirdFloorDropDownMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                currentFloor = 2;
                view.update(currentFloor, currentColor);
            }});


       fourthFloorDropDownMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                currentFloor = 3;
                view.update(currentFloor, currentColor);
            }});

        basementFloorDropDownMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                currentFloor = 4;
                view.update(currentFloor, currentColor);
            }});


        aPane.getChildren().add(view);
        primaryStage.setTitle("Floor Plan Builder");
        primaryStage.setScene(new Scene(aPane, 370,340));
        primaryStage.show();

        // Plug in the floor panel event handlers:
        for (int r=0; r<model.getFloorPlan(0).size(); r++) {
            for (int c=0; c<model.getFloorPlan(0).size(); c++) {
                view.getFloorTileButton(r, c).setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        handleTileSelection(event);
                    }});
            }
        }


        // Plug in the radioButton event handlers
        view.getEditWallsButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                view.update(currentFloor, currentColor);
            }});
        view.getSelectExitsButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                view.update(currentFloor, currentColor);
            }});
        view.getEditRoomsButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                view.update(currentFloor, currentColor);
            }});
        view.getDefineRoomsButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                view.update(currentFloor, currentColor);
            }});

        // Plug in the office color button
        view.getRoomColorButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                currentColor = (currentColor + 1)%view.ROOM_COLORS.length;
                view.update(currentFloor, currentColor);
            }});

        view.getBuildingOverviewButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BuildingDialog buildingInfoDialogBox = new BuildingDialog();
                buildingInfoDialogBox.display(model, model.getFloorPlans().length, model.getExits().length, currentFloor, model.getFloorPlan(currentFloor));
                view.update(currentFloor,currentColor);
            }
        });

        view.update(currentFloor, currentColor);

    }


    // Handle a Floor Tile Selection
    private void handleTileSelection(ActionEvent e) {
        // Determine which row and column was selected
        int r=0, c=0;
        OUTER:
        for (r=0; r<model.getFloorPlan(0).size(); r++) {
            for (c=0; c<model.getFloorPlan(0).size(); c++) {
                if (e.getSource() == view.getFloorTileButton(r, c))
                    break OUTER;
            }
        }

        // Check if we are in edit wall mode, then toggle the wall
        if (view.getEditWallsButton().isSelected()) {
            model.getFloorPlan(currentFloor).setWallAt(r, c, !model.getFloorPlan(currentFloor).wallAt(r, c));
            // Remove this tile from the room if it is on one, because it is now a wall
            Room room = model.getFloorPlan(currentFloor).roomAt(r, c);
            if (room != null)
                room.removeTile(r, c);
        }

        // Otherwise check if we are in edit exits mode
        else if (view.getSelectExitsButton().isSelected()) {
            if (model.exitAt(r, c) != null)
                model.removeExit(r, c);
            else {
                model.addExit(r, c);
                // Remove this tile from the room if it is on one, because it is now an exit
                Room off = model.getFloorPlan(currentFloor).roomAt(r, c);
                if (off != null)
                    off.removeTile(r, c);
            }
        }

        // Otherwise check if we are selecting a room tile
        else if (view.getEditRoomsButton().isSelected()) {
            if (!model.getFloorPlan(currentFloor).wallAt(r, c) && !model.hasExitAt(r, c)) {
                Room room = model.getFloorPlan(currentFloor).roomAt(r, c);
                if (room != null) {
                    room.removeTile(r, c);
                    if (room.getNumberOfTiles() == 0)
                        model.getFloorPlan(currentFloor).removeRoom(room);
                }
                else {
                    room = model.getFloorPlan(currentFloor).roomWithColor(currentColor);
                    if (room == null) {
                        room = model.getFloorPlan(currentFloor).addRoomAt(r, c);
                        room.setColorIndex(currentColor);
                    }
                    else {
                        room.addTile(r, c);
                    }
                }
            }
        }

        else if (view.getDefineRoomsButton().isSelected()) {
            Room room = model.getFloorPlan(currentFloor).roomAt(r, c);
            Alert alertMessage = new Alert(Alert.AlertType.ERROR);
            alertMessage.setTitle("Invalid Selection");
            alertMessage.setHeaderText(null);
            alertMessage.setContentText("You must select a tile that belongs to a room");

            if (room == null) {
                alertMessage.show();
            } else {
                RoomInfoDialog roomInfoMessageBox = new RoomInfoDialog();
                roomInfoMessageBox.display(model, currentFloor, r, c, currentColor, model.getFloorPlan(currentFloor), model.getFloorPlan(currentFloor).roomAt(r, c).getColorIndex()
                );

            }
        }

        // Otherwise Do Nothing
        else {
        }

        view.update(currentFloor, currentColor);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
