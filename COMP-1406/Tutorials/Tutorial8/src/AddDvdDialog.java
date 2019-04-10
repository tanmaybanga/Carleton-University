/**
 * Created by Imran on 2017-03-07.
 */

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class AddDvdDialog extends Dialog {
    public AddDvdDialog(Stage owner, String title, DVD d) {
        setTitle(title);

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        //Set the button type
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        //Creating The Lables and Fields
        TextField titleField = new TextField();
        TextField yearField = new TextField();
        TextField lengthField = new TextField();

        Label l1 = new Label("Title");
        Label l2 = new Label("Year:");
        Label l3 = new Label("Length:");

        // Add the lables and text fields to the grid
        titleField.setPromptText("Name of movie/documentry/event/ect.");
        yearField.setPromptText("Year DVD was relased");
        lengthField.setPromptText("Length (in minutes) of movie/documetry/event/ect.");

        d.setDuration(new Integer(lengthField.getText()));
        d.setTitle(new String(titleField.getText()));
        d.setYear(new Integer(yearField.getText()));

        grid.add(l1,0,0);
        grid.add(l2,0,1);
        grid.add(l3,0,2);
        grid.add(titleField,1,0);
        grid.add(yearField,1,1);
        grid.add(lengthField,1,2);

        getDialogPane().setContent(grid); // This will place everything in the window

        //Enable and or Disable the "Okay" Button on weather DVD Data was entered
        Node okButton = getDialogPane().lookupButton(okButtonType);
        okButton.setDisable(true); // Disables Once Starting
    }

}
