import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AddDVDDialog extends Dialog {
    public AddDVDDialog(Stage owner, String title, DVD d) {
        setTitle(title);

        // Set the button types
        ButtonType okButtonType = new ButtonType("OK",
                ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        // Create the labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        TextField titleField = new TextField(d.getTitle());
        titleField.setPromptText("Name of movie/documentary/event/etc.");
        titleField.setMinWidth(300);
        TextField yearField = new TextField();
        if (d.getYear() > 0)
            yearField.setText("" + d.getYear());
        yearField.setPromptText("Year DVD was released");
        yearField.setMinWidth(300);
        TextField lengthField = new TextField();
        if (d.getDuration() > 0)
            lengthField.setText("" + d.getDuration());
        lengthField.setPromptText("Length (in minutes) of movie/documentary/event/etc.");
        lengthField.setMinWidth(300);
        Label l1 = new Label("Title:");
        Label l2 = new Label("Year:");
        Label l3 = new Label("Length:");

        grid.add(l1, 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(l2, 0, 1);
        grid.add(yearField, 1, 1);
        grid.add(l3, 0, 2);
        grid.add(lengthField, 1, 2);
        getDialogPane().setContent(grid); // Puts the stuff on the window

        // Enable/Disable OK button depending on whether DVD data was entered.
        Node okButton = getDialogPane().lookupButton(okButtonType);
        okButton.setDisable(true); // Disable upon start
        titleField.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue,
                                Object newValue) {
                okButton.setDisable(titleField.getText().trim().isEmpty() ||
                        yearField.getText().trim().isEmpty() ||
                        lengthField.getText().trim().isEmpty());
            }
        });
        yearField.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue,
                                Object newValue) {
                okButton.setDisable(titleField.getText().trim().isEmpty() ||
                        yearField.getText().trim().isEmpty() ||
                        lengthField.getText().trim().isEmpty());
            }
        });
        lengthField.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue,
                                Object newValue) {
                okButton.setDisable(titleField.getText().trim().isEmpty() ||
                        yearField.getText().trim().isEmpty() ||
                        lengthField.getText().trim().isEmpty());
            }
        });

        // Convert the result to a DVD
        setResultConverter(new Callback<ButtonType, DVD>() {
            public DVD call(ButtonType b) {
                if (b == okButtonType) {
                    d.setTitle(titleField.getText());
                    d.setYear(Integer.parseInt(yearField.getText()));
                    d.setDuration(Integer.parseInt(lengthField.getText()));
                    return d;
                }
                return null;
            }
        });

    }
}
