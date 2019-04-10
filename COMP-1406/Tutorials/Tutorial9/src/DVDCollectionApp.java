import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class DVDCollectionApp extends Application {
    private DVDCollection       model;
    private ListView<DVD>       tList;
    private TextField tField, yField, lField;

    public DVDCollectionApp() {
        model = DVDCollection.example2();
    }

    public void start(Stage primaryStage) {
        VBox topPane = new VBox();
        GridPane aPane = new GridPane();
        aPane.setPadding(new Insets(10, 10, 10, 10));

        // Create the labels
        Label label1 = new Label("DVDs");
        aPane.add(label1,0,0,1,1);
        aPane.setMargin(label1, new Insets(0, 0, 5, 0));
        Label label2 = new Label("Title");
        aPane.add(label2,0,2,1,1);
        Label label3 = new Label("Year");
        aPane.add(label3,0,3,1,1);
        Label label4 = new Label("Length");
        aPane.setMargin(label4, new Insets(0, 10, 0, 10));
        aPane.add(label4,2,3,1,1);

        // Create the TextFields
        tField = new TextField();
        aPane.add(tField,1,2,6,1);
        aPane.setMargin(tField, new Insets(10, 0, 10, 0));

        tField.setMinSize(500,30);
        tField.setPrefSize(2000,30);
        yField = new TextField();
        aPane.add(yField,1,3,1,1);
        yField.setPrefSize(55,30);
        lField = new TextField();
        aPane.add(lField,3,3,1,1);
        lField.setPrefSize(45,30);
        aPane.setMargin(lField, new Insets(0, 10, 0, 0));

        // Create the list
        tList = new ListView<DVD>();
        aPane.add(tList,0,1,7,1);
        tList.setMinSize(540,150);
        tList.setPrefSize(2000,2000);

        /// Create the buttons
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); -fx-text-fill: rgb(255,255,255);");
        aPane.add(addButton,4,3,1,1);
        addButton.setPrefSize(90,30);
        aPane.setMargin(addButton, new Insets(0, 5, 0, 5));

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(200,0,0); -fx-text-fill: rgb(255,255,255);");
        aPane.add(deleteButton,5,3,1,1);
        deleteButton.setPrefSize(90,30);
        aPane.setMargin(deleteButton, new Insets(0, 5, 0, 5));

        Button statsButton = new Button("Stats");
        statsButton.setStyle("-fx-font: 12 arial;");
        aPane.add(statsButton,6,3,1,1);
        statsButton.setPrefSize(90,30);
        aPane.setMargin(statsButton, new Insets(0, 0, 0, 5));
        aPane.setHalignment(statsButton, HPos.RIGHT);

        // Populate the lists
        ArrayList<DVD>   theList = model.getDvds();
        tList.setItems(FXCollections.observableArrayList(theList));

        // Add all the components to the Pane
        aPane.setPrefSize(548, 268);

        Menu fileMenu = new Menu("_File");
        MenuItem  exampleItem = new MenuItem("Load Example List");
        fileMenu.getItems().addAll(exampleItem);

        Menu sortMenu = new Menu("_Sort");
        RadioMenuItem  titleItem = new RadioMenuItem("By Title");
        RadioMenuItem  yearItem = new RadioMenuItem("By Year");
        RadioMenuItem  lengthItem = new RadioMenuItem("By Length");
        ToggleGroup settingGroup = new ToggleGroup();
        titleItem.setToggleGroup(settingGroup);
        yearItem.setToggleGroup(settingGroup);
        lengthItem.setToggleGroup(settingGroup);
        sortMenu.getItems().addAll(titleItem, yearItem, lengthItem);

        // Add the menus to a menubar and then add the menubar to the pane
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, sortMenu);
        topPane.getChildren().addAll(menuBar, aPane);

        exampleItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog("1");
                dialog.setTitle("Input Required");
                dialog.setHeaderText(null);
                dialog.setContentText("Enter example list number to load (1, 2, or 3):");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    switch(Integer.parseInt(result.get())) {
                        case 1: model = DVDCollection.example1(); break;
                        case 2: model = DVDCollection.example2(); break;
                        case 3: model = DVDCollection.example3(); break;
                    }
                    ArrayList<DVD> theList = model.getDvds();
                    tList.setItems(FXCollections.observableArrayList(theList));
                }
            }
        });

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                DVD  d = new DVD();

                // Now bring up the dialog box
                Dialog dialog = new AddDVDDialog(primaryStage, "New DVD Details", d);

                Optional<DVD> result = dialog.showAndWait();
                if (result.isPresent()) {
                    model.add(d);    // Add the DVD to the model
                    update(model, model.getDvds().size() - 1);
                }
            }
        });

        statsButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                // Now bring up the dialog box
                Dialog dialog = new StatsDialog(primaryStage, model);
                dialog.showAndWait();
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (tList.getSelectionModel().getSelectedItem() != null) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Please Confirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure that you want to remove this DVD from the collection ?");

                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == ButtonType.OK){
                        model.remove(tList.getSelectionModel().getSelectedItem().getTitle());
                        update(model, -1);
                    }

                    // model.remove(tList.getSelectionModel().getSelectedItem().getTitle());
                    //update(model, tList.getSelectionModel().getSelectedIndex());
                }
            }
        });

        tList.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                model.setSelectedDVD(tList.getSelectionModel().getSelectedIndex());
                update(model, tList.getSelectionModel().getSelectedIndex());
            }
        });

        titleItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                model.sortByTitle();
                ArrayList<DVD>   theList = model.getDvds();
                tList.setItems(FXCollections.observableArrayList(theList));
                update(model, tList.getSelectionModel().getSelectedIndex());
            }
        });

        yearItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                model.sortByYear();
                ArrayList<DVD>   theList = model.getDvds();
                tList.setItems(FXCollections.observableArrayList(theList));
                update(model, tList.getSelectionModel().getSelectedIndex());
            }
        });

        lengthItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                model.sortByLength();
                ArrayList<DVD>   theList = model.getDvds();
                tList.setItems(FXCollections.observableArrayList(theList));
                update(model, tList.getSelectionModel().getSelectedIndex());
            }
        });

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setScene(new Scene(topPane));
        primaryStage.show();
    }

    // Update the view to reflect the model
    public void update(DVDCollection model, int selectedDVD) {
        ArrayList<DVD>   theList = model.getDvds();
        tList.setItems(FXCollections.observableArrayList(theList));

        DVD  d = tList.getSelectionModel().getSelectedItem();
        if (d != null) {
            tField.setText(d.getTitle());
            yField.setText(""+d.getYear());
            lField.setText(""+d.getDuration());
        }
        else {
            tField.setText("");
            yField.setText("");
            lField.setText("");
        }
        tList.getSelectionModel().select(selectedDVD);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
