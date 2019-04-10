/**
 * Created by Imran on 2017-03-27.
 */


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DispatchStatsDialog extends Dialog {
    TextField[][] statsFields;

    public DispatchStatsDialog(Stage owner, int[][] stats) {
        setTitle("Dispatch Statistics");

        // Set the button types
        getDialogPane().getButtonTypes().add(ButtonType.OK);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        statsFields = new TextField[DispatchCenter.AREA_NAMES.length][DispatchCenter.AREA_NAMES.length];

        grid.add(new Label("FROM \\ TO"), 0, 0);
        for (int i=0; i<DispatchCenter.AREA_NAMES.length; i++) {
            Label aLabel = new Label(DispatchCenter.AREA_NAMES[i]);
            aLabel.setAlignment(Pos.CENTER);
            grid.add(aLabel, i+1, 0, 1, 1);
            aLabel = new Label(DispatchCenter.AREA_NAMES[i]);
            aLabel.setAlignment(Pos.CENTER);
            grid.add(aLabel, 0, i+1, 1, 1);
        }
        for (int i=0; i<DispatchCenter.AREA_NAMES.length; i++) {
            for (int j=0; j<DispatchCenter.AREA_NAMES.length; j++) {
                statsFields[i][j] = new TextField("" + stats[i][j]);
                statsFields[i][j].setAlignment(Pos.CENTER_RIGHT);
                statsFields[i][j].setEditable(false);
                statsFields[i][j].setMaxWidth(50);
                grid.add(statsFields[i][j], i+1, j+1, 1, 1);
            }
        }

        // Find the highest number and make it GREEN, the lowest make RED
        int   max=-1, min=9999999;
        TextField maxF=null, minF=null;

        for (int i=0; i<DispatchCenter.AREA_NAMES.length; i++) {
            for (int j=0; j<DispatchCenter.AREA_NAMES.length; j++) {
                if (stats[i][j] > max) {
                    max = stats[i][j];
                    maxF = statsFields[i][j];
                }
                else if (stats[i][j] < min) {
                    min = stats[i][j];
                    minF = statsFields[i][j];
                }
            }
        }

        maxF.setStyle("-fx-base: rgb(0,150,0); -fx-text-fill: rgb(255,255,255);");
        minF.setStyle("-fx-base: rgb(200, 0,0); -fx-text-fill: rgb(255,255,255);");

        // Set the window size
        getDialogPane().setMaxSize(640,640);
        getDialogPane().setContent(grid); // Puts the stuff on the window
    }
}