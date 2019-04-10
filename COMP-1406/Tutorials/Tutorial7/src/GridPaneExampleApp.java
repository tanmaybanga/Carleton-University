import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class GridPaneExampleApp extends Application {
    private DVDCollection       model;
    private ListView<DVD>       tList;
    private TextField tField, yField, lField;

    public GridPaneExampleApp() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the labels
        Label label1 = new Label("DVDs");
        label1.relocate(10, 10);
        Label label2 = new Label("Title");
        label2.relocate(10, 202);
        Label label3 = new Label("Year");
        label3.relocate(10, 242);
        Label label4 = new Label("Length");
        label4.relocate(120, 242);

        // Create the TextFields
        tField = new TextField();
        tField.relocate(50, 200);
        tField.setPrefSize(500,30);
        yField = new TextField();
        yField.relocate(50, 240);
        yField.setPrefSize(55,30);
        lField = new TextField();
        lField.relocate(180, 240);
        lField.setPrefSize(45,30);

        // Create the list
        tList = new ListView<DVD>();
        tList.relocate(10, 40);
        tList.setPrefSize(540,150);

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
        buttonPane.relocate(250, 240);
        buttonPane.setPrefSize(305,30);

        // Populate the lists
        DVD[]   theList = model.getDVDList();
        tList.setItems(FXCollections.observableArrayList(theList));

        // Add all the components to the Pane
        aPane.getChildren().addAll(label1, label2, label3, label4, tField, yField, lField, tList, buttonPane);
        aPane.setPrefSize(548, 268);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
