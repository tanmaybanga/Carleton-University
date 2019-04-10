import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

public class DimensionsDialog extends Dialog {
    private Slider  rowsSlider, colsSlider;
    
    public DimensionsDialog(Stage owner, int r, int c) {
        setTitle("Maze Dimensions");
        
        // Set the button types
        ButtonType okButtonType = new ButtonType("OK",
                                                 ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);
        
        // Create the rows and columns sliders
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(new Label("Rows:"), 0, 0, 1, 1);
        grid.add(new Label("Columns:"), 0, 1, 1, 1);
        
        rowsSlider = new Slider(5, 50, r);
        rowsSlider.setMaxWidth(120);
        rowsSlider.setShowTickLabels(true);
        rowsSlider.setShowTickMarks(true);
        rowsSlider.setMajorTickUnit(50);
        rowsSlider.setMinorTickCount(5);
        rowsSlider.setBlockIncrement(10);
        grid.add(rowsSlider, 1, 0, 1, 1);
        
        colsSlider = new Slider(5, 50, c);
        colsSlider.setMaxWidth(120);
        colsSlider.setShowTickLabels(true);
        colsSlider.setShowTickMarks(true);
        colsSlider.setMajorTickUnit(50);
        colsSlider.setMinorTickCount(5);
        colsSlider.setBlockIncrement(10);
        grid.add(colsSlider, 1, 1, 1, 1);
        
        getDialogPane().setMaxSize(250,200);
        getDialogPane().setContent(grid); // Puts the stuff on the window
        
        // Convert the result to a Pair containing the rows and columns
        setResultConverter(
                           new Callback<ButtonType, Pair<Integer, Integer>>() {
            public Pair<Integer, Integer> call(ButtonType b) {
                if (b == okButtonType)
                    return new Pair<Integer, Integer>((int)rowsSlider.getValue(), (int)colsSlider.getValue());
                return null;
            }
        }
        );
    }
}