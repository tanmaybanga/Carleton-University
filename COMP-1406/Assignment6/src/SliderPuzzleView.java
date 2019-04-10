/**
 * Created by Imran Juma on 2017-03-06.
 */


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SliderPuzzleView extends Pane {
    public static final int GRID_UNIT_SIZE = 40;

    private Button[][]     gridSections;
    private Button         startButton, nextBoardButton;
    private TextField      numMovesField;

    private SliderPuzzleGame    model;

    public SliderPuzzleView(SliderPuzzleGame m) {
        model = m;

        gridSections = new Button[GameBoard.WIDTH+2][GameBoard.HEIGHT+2];

        // Create the wall (i.e., non-pressable) buttons
        for (int i=0; i<8; i++) {
            gridSections[i][0] = new Button();
            gridSections[i][0].setDisable(true);
            gridSections[i][0].relocate(i * GRID_UNIT_SIZE, 0);
            gridSections[i][0].setPrefSize(GRID_UNIT_SIZE, GRID_UNIT_SIZE);
            gridSections[i][0].setStyle("-fx-base: BLACK");
            gridSections[i][7] = new Button();
            gridSections[i][7].setDisable(true);
            gridSections[i][7].relocate(i * GRID_UNIT_SIZE, 7 * GRID_UNIT_SIZE);
            gridSections[i][7].setPrefSize(GRID_UNIT_SIZE, GRID_UNIT_SIZE);
            gridSections[i][7].setStyle("-fx-base: BLACK");
        }
        for (int i=1; i<7; i++) {
            gridSections[0][i] = new Button();
            gridSections[0][i].setDisable(true);
            gridSections[0][i].relocate(0, i * GRID_UNIT_SIZE);
            gridSections[0][i].setPrefSize(GRID_UNIT_SIZE, GRID_UNIT_SIZE);
            gridSections[0][i].setStyle("-fx-base: BLACK");

            gridSections[7][i] = new Button();
            gridSections[7][i].setDisable(true);
            gridSections[7][i].relocate(7 * GRID_UNIT_SIZE, i * GRID_UNIT_SIZE);
            gridSections[7][i].setPrefSize(GRID_UNIT_SIZE, GRID_UNIT_SIZE);


            if (i != 3) {
                gridSections[7][i].setStyle("-fx-base: BLACK");
            }
            else {
                gridSections[7][i].setStyle("-fx-base: WHITE");
                gridSections[7][i].setText("EXIT");
            }
        }

        // Create the inner "pressable" Buttons
        for (int w=1; w<7; w++) {
            for (int h=1; h<7; h++) {
                gridSections[w][h] = new Button();
                gridSections[w][h].relocate(w * GRID_UNIT_SIZE, h * GRID_UNIT_SIZE);
                gridSections[w][h].setPrefSize(GRID_UNIT_SIZE, GRID_UNIT_SIZE);
                gridSections[w][h].setStyle("-fx-base: WHITE; -fx-text-fill: RED;");
                gridSections[w][h].setFocusTraversable(false);
            }
        }

        // Add all the buttons to the window
        for (int w=0; w<8; w++) {
            for (int h=0; h<8; h++) {
                //if (!((h == 3) && (w == 7)))
                    getChildren().add(gridSections[w][h]);
            }
        }
        // Add the Start and NextBoard buttons
        startButton = new Button("Start");
        // ADD MORE CODE HERE
        startButton.relocate(10,340);
        startButton.setPrefSize(100,25);
        startButton.setPadding(new Insets(10));

        nextBoardButton = new Button("Next Board");
        // ADD MORE CODE HERE
        nextBoardButton.relocate(120,340);
        nextBoardButton.setPadding(new Insets(10));
        nextBoardButton.setPrefSize(100,25);

        // Add the Num Moves Field
        numMovesField = new TextField("");
        // ADD MORE CODE HERE
        numMovesField.setPadding(new Insets(10));
        numMovesField.setPrefSize(50,25);
        numMovesField.relocate(260,340);

        getChildren().addAll(startButton, nextBoardButton, numMovesField);

        update(); // Update with no board
    }

    public Button getGridSection(int w, int h) {
        return gridSections[w][h];
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getNextBoardButton() {
        return nextBoardButton;
    }

    // Allowing the function to update, however this is where we are having problems with the program 
    public void update() {

        // This function will reset all of of our colors back down to white
        for (int x = 0; x < GameBoard.WIDTH; x++){
            for (int y = 0; y < GameBoard.HEIGHT; y++){
                gridSections[x+1][y+1].setStyle("-fx-base: WHITE");
            }
        }

        // Howver this function willl update to the coorect filled color
        for (int x = 0; x < GameBoard.WIDTH; x++){
            for (int y = 0; y < GameBoard.HEIGHT; y++){
                gridSections[x+1][y+1].setStyle("-fx-base: #" + model.getCurrentBoard().pieceAt(x,y).getColor().toString().substring(2,8));
            }
        }

        // Update the Start and NextBoard buttons (Uncompleted)
        // Disable all the board buttons unless we are in progress of playing a board (Uncompleted)
        // Update the number of moves field (Uncompleted)
    }
}
