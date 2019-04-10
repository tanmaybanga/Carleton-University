//Imrans Version

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class BorderPaneExampleApp extends Application {
    private DVDCollection       model;
    private ListView<String>    tList;
    private ListView<Integer>   yList, lList;

    public BorderPaneExampleApp() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        BorderPane  aBorderPane = new BorderPane();
        aBorderPane.setPadding(new Insets(10));

        // Create the labels
        Label label1 = new Label("Title");
        label1.relocate(10, 10);
        label1.setPrefSize(Integer.MAX_VALUE,20);
    
        Label label2 = new Label("Year");
        label2.relocate(220, 10);
        label2.setPrefSize(60,20);
        label2.setMinSize(60,20);
        
        Label label3 = new Label("Length");
        label3.relocate(290, 10);
        label3.setPrefSize(60,20);
        label3.setMinSize(60,20);

        // Create the lists
        tList = new ListView<String>();
       // tList.relocate(10, 40);
        tList.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);

        yList = new ListView<Integer>();
        //yList.relocate(220, 40);
        yList.setPrefSize(60,Integer.MAX_VALUE);
        yList.setMinSize(60, 100);

        lList = new ListView<Integer>();
        //lList.relocate(290, 40);
        lList.setPrefSize(60,Integer.MAX_VALUE);
        lList.setMinSize(60, 100);



        // Create the button pane
        Pane buttonPane = new Pane();

        // Create the buttons
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); -fx-text-fill: rgb(255,255,255);");
        addButton.relocate(0, 0);
        addButton.setPrefSize(90,30);

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(200,0,0); -fx-text-fill: rgb(255,255,255);");
        deleteButton.relocate(95, 0);
        deleteButton.setPrefSize(90,30);

        Button statsButton = new Button("Stats");
        statsButton.setStyle("-fx-font: 12 arial;");
        statsButton.relocate(210, 0);
        statsButton.setPrefSize(90,30);

        // Add all three buttons to the pane
        buttonPane.getChildren().addAll(addButton, deleteButton, statsButton);
        buttonPane.relocate(30, 200);
        buttonPane.setPrefSize(305,30);

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

        // Add all the components to the Pane
        aBorderPane.getChildren().addAll(label1, label2, label3, tList, yList, lList, buttonPane);
        aBorderPane.setPrefSize(348, 228);

        HBox componentorPane1 = new HBox();
        GridPane componentorPane2 = new GridPane();
        HBox componentorPane3 = new HBox();
        
        componentorPane1.getChildren().addAll(label1,label2,label3);
        componentorPane1.setSpacing(10);
        
        componentorPane2.add(tList,0,0);
        componentorPane2.add(yList,1,0);
        componentorPane2.add(lList,2,0);
        componentorPane2.setHgap(10);
        componentorPane2.setPadding(new Insets(0,0,10,0));

        aBorderPane.setPadding(new Insets(10));
        
        componentorPane3.getChildren().addAll(buttonPane);
        componentorPane3.setSpacing(10);




        aBorderPane.setTop(componentorPane1);
        aBorderPane.setCenter(componentorPane2);
        aBorderPane.setBottom(componentorPane3);

        primaryStage.setTitle("My DVD Collection");
        //primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aBorderPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
