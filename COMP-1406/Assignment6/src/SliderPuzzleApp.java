/**
 * Created by Imran Juma on 2017-03-06.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SliderPuzzleApp extends Application {
    private SliderPuzzleGame    model;
    private SliderPuzzleView    view;

    private GamePiece           selectedPiece;
    private boolean             justGrabbed;
    private int                 lastX;
    private int                 lastY;

    public void start(Stage primaryStage) {
        model = new SliderPuzzleGame();
        view = new SliderPuzzleView(model);

        // Add event handlers to the inner game board buttons
        for (int w=1; w<=(GameBoard.WIDTH); w++) {
            for (int h=1; h<=(GameBoard.HEIGHT); h++) {
                view.getGridSection(w, h).setOnMousePressed(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent mouseEvent) {
                        handleGridSectionSelection(mouseEvent);
                    }
                });
                view.getGridSection(w, h).setOnMouseDragged(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent mouseEvent) {
                        handleGridSectionMove(mouseEvent);
                    }
                });
            }
        }

        // Plug in the Start button and NeaxtBoard button event handlers
        view.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.startBoard();
                view.update();
            }
        });
        view.getNextBoardButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.moveToNextBoard();
                view.update();
            }
        });

        primaryStage.setTitle("Slide Puzzle Application");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(view, -10+SliderPuzzleView.GRID_UNIT_SIZE*(GameBoard.WIDTH+2) + 10,45+SliderPuzzleView.GRID_UNIT_SIZE*(GameBoard.HEIGHT+2)+20));
        primaryStage.show();

        // Update the view upon startup
        view.update();
    }


    private void handleGridSectionSelection(MouseEvent mouseEvent) {
        // FILL IN YOUR CODE
    }
    private void handleGridSectionMove(MouseEvent mouseEvent) {
        int currentGridX = (int)mouseEvent.getX();
        int currentGridY = (int)mouseEvent.getY();

        // FILL IN YOUR CODE
    }

    public static void main(String[] args) { launch(args); }
}

