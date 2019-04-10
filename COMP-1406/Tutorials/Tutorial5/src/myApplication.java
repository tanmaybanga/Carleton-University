/**
 * Created by Imran on 2017-02-07.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class myApplication extends Application{
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Pane(), 300, 100);

        primaryStage.setTitle("My Window");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
