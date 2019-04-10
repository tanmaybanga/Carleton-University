import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


import javax.swing.*;
import java.awt.*;
import java.time.Year;

public class DVDCollectionApp  extends Application {
    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the labels
        // ... ADD CODE HERE ... //

        // Create the lists
        String[]    titles = {"Star Wars", "Java is cool", "Mary Poppins", "The Green Mile"};
        String[]    years = {"1978", "2002", "1968", "1999"};
        String[]    lengths = {"124", "93", "126", "148"};

        ListView<String> TitleView = new ListView<>();
        TitleView.setItems(FXCollections.observableArrayList(titles));
        TitleView.setPrefSize(200, 150);
        TitleView.relocate(10, 40);

        ListView<String> YearView = new ListView<>();
        YearView.setItems(FXCollections.observableArrayList(years));
        YearView.setPrefSize(60, 150);
        YearView.relocate(220, 40);

        ListView<String> LengthView = new ListView<>();
        LengthView.setItems(FXCollections.observableArrayList(lengths));
        LengthView.setPrefSize(60, 150);
        LengthView.relocate(290, 40);

        //Creating Buttons
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button stats = new Button("Stats");

        add.relocate(10, 180);
        add.setPrefSize(95, 30);
        add.setAlignment(Pos.CENTER);
        add.setText("Add");


        delete.relocate(115, 180);
        delete.setPrefSize(95, 30);
        delete.setAlignment(Pos.CENTER);
        delete.setText("Delete");

        stats.relocate(290, 180);
        stats.setPrefSize(60, 30);
        stats.setAlignment(Pos.CENTER);
        stats.setText("Stats");

        // Lables

        Label lebel_Title = new Label("Title");
        Label lebel_Year = new Label("Year");
        Label lebel_Length = new Label("Length");

        lebel_Title.relocate(10, 20);
        lebel_Year.relocate(230, 20);
        lebel_Length.relocate(290, 20);


        // Making Them Appear In The Window
        aPane.getChildren().add(add);
        aPane.getChildren().add(delete);
        aPane.getChildren().add(stats);
        aPane.getChildren().add(lebel_Title);
        aPane.getChildren().add(lebel_Year);
        aPane.getChildren().add(lebel_Length);
        aPane.getChildren().add(TitleView);
        aPane.getChildren().add(YearView);
        aPane.getChildren().add(LengthView);

        // Don’t forget to add the components to the window, set the title,
        // make it non-resizable, set Scene dimensions and then show the stage
        primaryStage.setScene(new Scene(aPane, 349, 228));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

