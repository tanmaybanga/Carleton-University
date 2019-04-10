/**
 * Created by Imran on 2017-03-27.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Optional;

public class TaxiServiceDispatchingSystem extends Application {
    ListView<ClientRequest>     incomingList;
    ListView<Taxi>              enRouteList;
    ListView<Taxi>[]            areaLists;
    Button                      dispatchButton;

    // The model
    private DispatchCenter              dispatchCenter;
    private ArrayList<ClientRequest>    incomingQueue;
    private Timeline                    incomingClientTimer;
    private Timeline                    updateTimer;
    private int                         clientsPerSecond;

    public void start(Stage primaryStage) {
        // Create a dispatch center for the model
        dispatchCenter = new DispatchCenter();
        incomingQueue = new ArrayList<ClientRequest>();

        VBox aPane = new VBox();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Add some labels
        Label label = new Label("Incoming");
        grid.setHalignment(label, HPos.LEFT);
        grid.add(label, 0, 0, 1, 1);
        for (int i=0; i<DispatchCenter.AREA_NAMES.length; i++) {
            label = new Label(DispatchCenter.AREA_NAMES[i]);
            grid.add(label, 2+i, 0, 1, 1);
            label.setMinHeight(20);
            label.setMinWidth(50);
        }

        // Add the Dispatch button
        dispatchButton = new Button("Dispatch");
        grid.add(dispatchButton, 0, 3, 1, 1);
        dispatchButton.setMinHeight(30);
        dispatchButton.setMinWidth(100);
        dispatchButton.setPrefWidth(100);
        dispatchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                handleTaxiDispatch();
            }});

        // Add the ListViews
        incomingList = new ListView();
        incomingList.setPrefHeight(400);
        incomingList.setMinWidth(150);
        incomingList.setPrefWidth(Integer.MAX_VALUE);
        grid.add(incomingList, 0, 1, 1, 1);

        areaLists = new ListView[6];
        for (int i=0; i<areaLists.length; i++) {
            areaLists[i] = new ListView();
            areaLists[i].setPrefHeight(400);
            areaLists[i].setMinWidth(100);
            areaLists[i].setPrefWidth(Integer.MAX_VALUE);
            grid.add(areaLists[i], 2+i, 1, 1, 1);
        }


        // Create the Simulation menu
        Menu simMenu = new Menu("Simula_tion");
        MenuItem  start = new MenuItem("Start Clients Coming");
        MenuItem  stop = new MenuItem("Stop Clients From Coming");
        simMenu.getItems().addAll(start, stop);


        // Create the timer for causing new clients to appear
        clientsPerSecond = 2;  /// Default is to have them come twice per second
        incomingClientTimer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // Pick a random area that the client will need a taxi from and add to the queue
                incomingQueue.add(new ClientRequest(DispatchCenter.AREA_NAMES[(int)(Math.random()*6)],DispatchCenter.AREA_NAMES[(int)(Math.random()*6)]));
                update();
            }
        }));
        incomingClientTimer.setCycleCount(Timeline.INDEFINITE);
        incomingClientTimer.setRate(clientsPerSecond);

        start.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                incomingClientTimer.play();
            }});
        stop.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                incomingClientTimer.stop();
            }});

        // Create the timer for causing updates in the ListViews (updating at 10 times per second)
        updateTimer = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // Update all busy taxis by decreasing their estimate time (do this once every second)
                for (Taxi x: dispatchCenter.getBusyTaxis()) {
                    x.decreaseEstimatedTimeToDest();
                    if (x.getEstimatedTimeToDest() == 0)
                        x.setAvailable(true);
                }
                update();
            }
        }));
        updateTimer.setCycleCount(Timeline.INDEFINITE);
        updateTimer.play();

        // Create the Settings menu
        Menu settingsMenu = new Menu("_Settings");
        MenuItem  arrivalRate = new MenuItem("Simulation Rate ...");
        settingsMenu.getItems().addAll(arrivalRate);
        arrivalRate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int input = 0;
                try {
                    // Bring up a TextInputDialog box
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Input Required");
                    dialog.setHeaderText(null);
                    dialog.setContentText("Iterations Per Second (1 to 20)");
                    dialog.setResult("" + clientsPerSecond);
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        System.out.println(dialog.getResult());
                        input = Integer.parseInt(dialog.getResult());
                        if ((input > 0) && (input <= 20)) {
                            clientsPerSecond = input;
                            incomingClientTimer.setRate(clientsPerSecond);
                        } else {System.out.println("ERROR");
                            throw new Exception();
                        }
                    }
                } catch(Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please choose a number from 1 to 20");
                    alert.showAndWait();
                }
            }});

        // Create the Admin menu
        Menu adminMenu = new Menu("_Admin");
        MenuItem  stats = new MenuItem("Statistics");
        adminMenu.getItems().addAll(stats);
        stats.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new DispatchStatsDialog(null, dispatchCenter.getStats()).showAndWait();
            }});

        // Add the menubar
        MenuBar menuBar = new MenuBar();
        aPane.getChildren().addAll(menuBar, grid);
        menuBar.getMenus().addAll(simMenu, settingsMenu, adminMenu);

        // Set the window size
        primaryStage.setTitle("Taxi Service Dispatching System");
        primaryStage.setScene(new Scene(aPane, 850,400));
        primaryStage.show();

        update();
    }


    // Update the look of the components
    private void update() {
        for (int i=0; i<areaLists.length; i++) {
            areaLists[i].setItems(FXCollections.observableArrayList(new ArrayList<Taxi>(dispatchCenter.getAreas().get(DispatchCenter.AREA_NAMES[i]))));
            areaLists[i].refresh();
        }
        incomingList.setItems(FXCollections.observableArrayList(new ArrayList<ClientRequest>(incomingQueue)));
        incomingList.refresh();
    }

    // Handle a dispatch
    private void handleTaxiDispatch() {
        // Get the next client, unless there are no more
        if (incomingQueue.isEmpty())
            return;
        ClientRequest c = incomingQueue.get(0);

        // Send a taxi for this request, if there is one available
        Taxi t = dispatchCenter.sendTaxiForRequest(c);
        if (t != null) {
            incomingQueue.remove(0);
        }
        update();
    }

    public static void main(String[] args) {
        launch(args);
    }
}