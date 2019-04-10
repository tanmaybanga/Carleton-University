import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DVDCollectionApp extends Application {
    private DVDCollection       model;
    private ListView<String>    tList;
    private ListView<Integer>   yList, lList;

    public DVDCollectionApp() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        BorderPane  borderPane = new BorderPane();

        // Create the labels
        HBox    labelPane = new HBox();
        labelPane.setPadding(new Insets(0,0,0,10));
        labelPane.setSpacing(10);
        Label label1 = new Label("Title");
        label1.setMinSize(300,30);
        label1.setPrefSize(2000,30);

        Label label2 = new Label("Year");
        label2.setMinSize(60,30);
        label2.setPrefSize(60,30);

        Label label3 = new Label("Length");
        label3.setMinSize(60,30);
        label3.setPrefSize(60,30);
        labelPane.getChildren().addAll(label1, label2, label3);
        borderPane.setTop(labelPane);



        // Create the lists
        GridPane    listPane = new GridPane();
        listPane.setPadding(new Insets(10));
        listPane.setHgap(10);
        tList = new ListView<String>();
        listPane.add(tList, 0, 0);
        tList.setMinSize(300,60);
        tList.setPrefSize(2000,2000);

        yList = new ListView<Integer>();
        listPane.add(yList, 1, 0);
        yList.setMinSize(60,60);
        yList.setPrefSize(60,500);

        lList = new ListView<Integer>();
        listPane.add(lList, 2, 0);
        lList.setMinSize(60,60);
        lList.setPrefSize(60,500);

        borderPane.setCenter(listPane);



        // Create the button pane
        HBox buttonPane = new HBox();
        buttonPane.setPadding(new Insets(10));
        buttonPane.setSpacing(10);
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); -fx-text-fill: rgb(255,255,255);");
        addButton.setPrefSize(90,30);

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(200,0,0); -fx-text-fill: rgb(255,255,255);");
        deleteButton.setPrefSize(90,30);

        Button statsButton = new Button("Stats");
        statsButton.setStyle("-fx-font: 12 arial;");
        statsButton.setPrefSize(90,30);

        buttonPane.getChildren().addAll(addButton, deleteButton, statsButton);
        borderPane.setBottom(buttonPane);


        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
               /*
                String title = javax.swing.JOptionPane.showInputDialog("Please enter the DVD Title: ");
                String year = javax.swing.JOptionPane.showInputDialog("Please enter the DVD Year: ");
                String length = javax.swing.JOptionPane.showInputDialog("Please enter the DVD Duration: ");
                if ((title != null) && (year != null) && (length != null) && (title.length() > 0) && (year.length() > 0) && (length.length() > 0)) {
                    DVD  d = new DVD(title, Integer.parseInt(year), Integer.parseInt(length));
                    model.add(d);
                    update(model, -1);
                }
                */
               DVD d = new DVD();
               AddDvdDialog dialog = new AddDvdDialog(primaryStage, "New DVD Details", d);
               dialog.showAndWait();
               model.add(d);
               update(model,-1);
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (tList.getSelectionModel().getSelectedItem() != null) {
                    model.remove(tList.getSelectionModel().getSelectedItem());
                    update(model, -1);
                }
            }
        });
        tList.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                model.setSelectedDVD(tList.getSelectionModel().getSelectedIndex());
                update(model, tList.getSelectionModel().getSelectedIndex());
            }
        });
        yList.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                model.setSelectedDVD(yList.getSelectionModel().getSelectedIndex());
                update(model, yList.getSelectionModel().getSelectedIndex());
            }
        });
       lList.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                model.setSelectedDVD(lList.getSelectionModel().getSelectedIndex());
                update(model, lList.getSelectionModel().getSelectedIndex());
            }
        });


        // Populate the lists
        DVD[]   theList = model.getDVDList();
        String[] titles = new String[theList.length];
        Integer[] years = new Integer[theList.length];
        Integer[] lengths = new Integer[theList.length];
        for (int i=0; i<theList.length; i++) {
            titles[i] = theList[i].getTitle();
            years[i] = theList[i].getYear();
            lengths[i] = theList[i].getDuration();
        }
        tList.setItems(FXCollections.observableArrayList(titles));
        yList.setItems(FXCollections.observableArrayList(years));
        lList.setItems(FXCollections.observableArrayList(lengths));

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setScene(new Scene(borderPane, 600, 300));
        primaryStage.show();
    }

    // Update the view to reflect the model
    public void update(DVDCollection model, int selectedDVD) {
        DVD[]   theList = model.getDVDList();
        String[] titles = new String[theList.length];
        Integer[] years = new Integer[theList.length];
        Integer[] lengths = new Integer[theList.length];
        for (int i=0; i<theList.length; i++) {
            titles[i] = theList[i].getTitle();
            years[i] = theList[i].getYear();
            lengths[i] = theList[i].getDuration();
        }
        tList.setItems(FXCollections.observableArrayList(titles));
        yList.setItems(FXCollections.observableArrayList(years));
        lList.setItems(FXCollections.observableArrayList(lengths));

        tList.getSelectionModel().select(selectedDVD);
        yList.getSelectionModel().select(selectedDVD);
        lList.getSelectionModel().select(selectedDVD);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
