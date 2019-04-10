import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Optional;

public class MazeCreator extends Application {
    private Button[][]      buttons; // This will store all the Buttons
    private Maze            model;
    private VBox            aPane;
    
    public void start(Stage primaryStage) {
        model = new Maze(12, 12);
        model.carve();
        
        aPane = new VBox();
        Menu mazeMenu = new Menu("Maze");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(mazeMenu);
        MenuItem[]  mazeMenuItems = new MenuItem[4];
        mazeMenuItems[0] = new MenuItem("Create");
        mazeMenuItems[1] = new MenuItem("Change Dimensions");
        mazeMenuItems[2] = new MenuItem("Longest Path From (1,1)");
        mazeMenuItems[3] = new MenuItem("Longest Path");
        mazeMenu.getItems().addAll(mazeMenuItems[0],mazeMenuItems[1], new SeparatorMenuItem(),
                                   mazeMenuItems[2], mazeMenuItems[3]);
        
        GridPane gridPane = new GridPane();
        createButtons(gridPane);
        
        // Add the "Create" event handler
        mazeMenuItems[0].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                model = new Maze(model.getRows(),model.getColumns());
                model.carve();
                updateButtons();
            }});
        
        // Add the "Change Dimensions" event handler
        mazeMenuItems[1].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Optional<Pair<Integer,Integer>> result = new DimensionsDialog(primaryStage, model.getRows(), model.getColumns()).showAndWait();
                if (result.isPresent()) {
                    model = new Maze(result.get().getKey(), result.get().getValue());
                    model.carve();
                    gridPane.getChildren().clear();
                    createButtons(gridPane);
                    primaryStage.setWidth(model.getColumns()*25);
                    primaryStage.setHeight(model.getRows()*25+30);
                    updateButtons();
                }}});
        
        // Add the "Longest Path From (1,1)" event handler
        mazeMenuItems[2].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ArrayList<Point2D> path = model.longestPathFrom(1,1);
                System.out.println("Path length: " + path.size());
                for (int i=0; i<path.size(); i++)
                    model.placeVisitAt((int)path.get(i).getX(), (int)path.get(i).getY());
                updateButtons();
                for (int i=0; i<path.size(); i++)
                    model.removeVisitAt((int)path.get(i).getX(), (int)path.get(i).getY());
            }});
        
        // Add the "Longest Path" event handler
        mazeMenuItems[3].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ArrayList<Point2D> path = model.longestPath();
                System.out.println("Path length: " + path.size());
                for (int i=0; i<path.size(); i++)
                    model.placeVisitAt((int)path.get(i).getX(), (int)path.get(i).getY());
                updateButtons();
                for (int i=0; i<path.size(); i++)
                    model.removeVisitAt((int)path.get(i).getX(), (int)path.get(i).getY());
            }});
        
        aPane.getChildren().addAll(menuBar, gridPane);
        primaryStage.setTitle("Maze Creator");
        primaryStage.setScene(new Scene(aPane));
        primaryStage.setWidth(model.getColumns()*25);
        primaryStage.setHeight(model.getRows()*25+30);
        primaryStage.show();
        
        updateButtons();
    }
    
    private void createButtons(GridPane gridPane) {
        buttons = new Button[model.getRows()][model.getColumns()];
        for(int row=0; row<model.getRows(); row++) {
            for (int col=0; col<model.getColumns(); col++) {
                buttons[row][col] = new Button();
                buttons[row][col].setPrefWidth(200);
                buttons[row][col].setPrefHeight(200);
                buttons[row][col].setMinHeight(10);
                buttons[row][col].setMinWidth(10);
                gridPane.add(buttons[row][col], col, row);
            }
        }
    }
    
    private void updateButtons() {
        for(int row=0; row<model.getRows(); row++) {
            for (int col = 0; col < model.getColumns(); col++) {
                // Set the color of each button to match the maze
                if (model.wallAt(row, col))
                    buttons[row][col].setStyle("-fx-base: rgb(0,0,0);");
                else {
                    if (model.visitedAt(row, col))
                        buttons[row][col].setStyle("-fx-base: rgb(255,0,0);");
                    else
                        buttons[row][col].setStyle("-fx-base: rgb(255,255,255);");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}