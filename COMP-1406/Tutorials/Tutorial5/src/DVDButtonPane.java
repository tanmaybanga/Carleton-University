
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.Color;

public class DVDButtonPane extends Pane {
    public void start(Stage primaryStage) {

        // Creatng New Pane
        Pane aPane = new Pane();

        // Setting Pane Size
        primaryStage.setScene(new Scene(aPane, 300, 30 ));

        // Creating Buttons
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button stats = new Button("Stats");

        // Making Them Appear In The Window
        aPane.getChildren().add(add);
        aPane.getChildren().add(delete);
        aPane.getChildren().add(stats);

        // Setting The Location Of The Buttons
        add.relocate(10, 180);
        delete.relocate(10, 180);
        stats.relocate(10, 180);

        // Setting The Size To Each Button
        add.setPrefSize(90, 30);
        delete.setPrefSize(90, 30);
        stats.setPrefSize(90, 30);

        // Setting The Colour To Each Button



    }
}
