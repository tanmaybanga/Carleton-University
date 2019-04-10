import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DVDCollectionApp2  extends Application {
    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the labels
        Label label1 = new Label("DVDs");
        Label label2 = new Label("Title");
        Label label3 = new Label("Year");
        Label label4 = new Label("Length");

        // Create the TextFields
        TextField tField = new TextField();
        TextField yField = new TextField();
        TextField lField = new TextField();

        // Create the lists
        ListView<DVD>    tList = new ListView<DVD>();

        // Create the buttons
        DVDButtonPane buttonPane = new DVDButtonPane();

        // Add all the components to the window
        aPane.getChildren().addAll(label1, label2, label3, label4, tField, yField,
                lField, tList, buttonPane);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 548,268));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
