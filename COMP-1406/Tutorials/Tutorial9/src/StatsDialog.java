import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StatsDialog extends Dialog {
    public StatsDialog(Stage owner, DVDCollection c) {
        setTitle("DVD Statistics");

        // Set the button types
        ButtonType okButtonType = new ButtonType("OK",
                ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType);

        // Create the labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));


        Label l1 = new Label("Total:");
        Label l2 = new Label("Oldest:");
        Label l3 = new Label("Newest:");
        Label l4 = new Label("Shortest Duration:");
        Label l5 = new Label("Longest Duration:");
        Label l6 = new Label(""+c.getDvds().size());
        Label l7 = new Label(""+c.oldestDVD());
        Label l8 = new Label(""+c.newestDVD());
        Label l9 = new Label(""+c.shortestDVD());
        Label l10 = new Label(""+c.longestDVD());
        l1.setStyle("-fx-font: 12 arial; -fx-text-fill: NAVY;");
        l2.setStyle("-fx-font: 12 arial; -fx-text-fill: NAVY;");
        l3.setStyle("-fx-font: 12 arial; -fx-text-fill: NAVY;");
        l4.setStyle("-fx-font: 12 arial; -fx-text-fill: NAVY;");
        l5.setStyle("-fx-font: 12 arial; -fx-text-fill: NAVY;");

        grid.add(l1, 0, 0);
        grid.add(l2, 0, 1);
        grid.add(l3, 0, 2);
        grid.add(l4, 0, 3);
        grid.add(l5, 0, 4);
        grid.add(l6, 1, 0);
        grid.add(l7, 1, 1);
        grid.add(l8, 1, 2);
        grid.add(l9, 1, 3);
        grid.add(l10, 1, 4);
        getDialogPane().setContent(grid); // Puts the stuff on the window
    }
}
