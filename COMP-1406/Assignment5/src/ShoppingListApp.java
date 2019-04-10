/**
 * Created by Imran on 2017-02-24.
 */

// Importing Variious Items Into The Project
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;

// Extending Our Application
public class ShoppingListApp extends Application {
    
    
    //Imported from the previous assingment
    // All the items that will show up
    GroceryItem[] products = {
    new FreezerItem("Smart-Ones Frozen Entrees", 1.99f, 0.311f),
    new GroceryItem("SnackPack Pudding", 0.99f, 0.396f),
    new FreezerItem("Breyers Chocolate Icecream",2.99f,2.27f),
    new GroceryItem("Nabob Coffee", 3.99f, 0.326f),
    new GroceryItem("Gold Seal Salmon", 1.99f, 0.213f),
    new GroceryItem("Ocean Spray Cranberry Cocktail",2.99f,2.26f),
    new GroceryItem("Heinz Beans Original", 0.79f, 0.477f),
    new RefrigeratorItem("Lean Ground Beef", 4.94f, 0.75f),
    new FreezerItem("5-Alive Frozen Juice",0.75f,0.426f),
    new GroceryItem("Coca-Cola 12-pack", 3.49f, 5.112f),
    new GroceryItem("Toilet Paper - 48 pack", 40.96f, 10.89f),
    new RefrigeratorItem("2L Sealtest Milk",2.99f,2.06f),
    new RefrigeratorItem("Extra-Large Eggs",1.79f,0.77f),
    new RefrigeratorItem("Yoplait Yogurt 6-pack",4.74f,1.02f),
    new FreezerItem("Mega-Sized Chocolate Icecream",67.93f,15.03f)};
    
    
    // This is my shopper class
    Shopper shopper = new Shopper();
    ArrayList<String> inCart = new ArrayList<>();
    
    // Buttons that work in our display
    Button buyButton = new Button("Buy");
    Button returnButton = new Button("Return");
    Button checkoutButton = new Button("Checkout");
    
    // here we have lables for: Buy Return and Checkout
    Label totalPriceLabel = new Label("Total Price:");
    Label productsLabel = new Label("Products:");
    Label shoppingCartLabel = new Label("Shopping Cart:");
    Label contentsLabel = new Label("Contents:");

    //Our Total Price Field
    // $0.00 to make the inital price
    TextField totalField = new TextField("$0.00");

    // here we have listView's that where used: productList, ShoppingCartList, and ContentList
    ListView<GroceryItem> productList = new ListView<GroceryItem>();
    ListView<String> shoppingCartList = new ListView<String>();
    ListView<String> contentsList = new ListView<String>();

    // Making Our New Stage, Creating Our Pane, Making The Window Unable to be resiable
    public void start(Stage primaryStage) {

        Pane aPane = new Pane();
        primaryStage.setResizable(false);

        // Here Are All The setDisable, as required when the program boots up
        buyButton.setDisable(true);
        returnButton.setDisable(true);
        checkoutButton.setDisable(true);

        // Here Are All The Relocations
        buyButton.relocate(10,355);
        returnButton.relocate(220,355);
        checkoutButton.relocate(430,355);
        totalPriceLabel.relocate(565,355);
        productsLabel.relocate(10,10);
        shoppingCartLabel.relocate(220,10);
        contentsLabel.relocate(430,10);
        totalField.relocate(630,355);
        productList.relocate(10,45);
        shoppingCartList.relocate(220,45);
        contentsList.relocate(430,45);
        
        // Addition to Product List
        productList.setItems(FXCollections.observableArrayList(products));

        // Here Are All The setPrefSize
        buyButton.setPrefSize(200, 25);
        returnButton.setPrefSize(200, 25);
        checkoutButton.setPrefSize(120, 25);
        totalPriceLabel.setPrefSize(65,25);
        productsLabel.setPrefSize(200,35);
        shoppingCartLabel.setPrefSize(200,35);
        contentsLabel.setPrefSize(120,35);
        totalField.setPrefSize(100,25);
        productList.setPrefSize(200,300);
        shoppingCartList.setPrefSize(200,300);
        contentsList.setPrefSize(300,300);

        // FIXING ALL STUPID COSMETIC ERRORS CUZ #MACLIFE #NEEDED THIS SORRY #FMLIDKWHY I USE MAC
        totalField.setAlignment(Pos.CENTER_RIGHT);
        totalPriceLabel.setAlignment(Pos.CENTER_LEFT);
        totalPriceLabel.setStyle("-fx-font: 12 arial;");

        // Making everything Appear
        // using update function
        // Sizing Of Our Whole Window
        primaryStage.setTitle("Grocery Store Application");
        primaryStage.setScene(new Scene(aPane, 740, 390));
        primaryStage.show();
        updateBox();
        
        // Making Everything Needed appear in the Pane
        aPane.getChildren().addAll(buyButton, returnButton, checkoutButton,
        totalPriceLabel, productsLabel, shoppingCartLabel, contentsLabel,
        totalField, shoppingCartList, productList, contentsList);

    }



    public static void main(String[] args) {
        launch(args);
    }

    // Update function on button press
    // @Overside automatically comes in
    // Changing what is and isnt disabled
    public void updateBox() {
        productList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buyButton.setDisable(false);
                returnButton.setDisable(true);
            }
        });

        // Shopping Cart Mouse Click
        // Changing what is and isnt disabled
        // The handle funciton
        shoppingCartList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                returnButton.setDisable(false);
                buyButton.setDisable(true);
            }
        });

        // Buy Button on mouse click
        // The Handle function creating our float changing the object
        // implementing carryable adding items when bought and putting them into the cart
        // setting disabled making the text appear in the correct position setting the print statement
        buyButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                float totalPrice;
                Carryable object = productList.getSelectionModel().getSelectedItem();
                shopper.addItem(object);
                inCart.add(object.getDescription());
                totalPrice = shopper.totalCost();
                shoppingCartList.setItems(FXCollections.observableArrayList(inCart));
                checkoutButton.setDisable(false);
                totalField.setAlignment(Pos.CENTER_RIGHT);
                totalField.setText("$" + String.valueOf(String.format("%,1.2f",totalPrice)));
            }
        });

        // Return Button on mouse click, using our temporary varible and the override function
        // Implementing Carable, and the totalPrice float
        // We used a loop over to remove the items from the cart
        // Setting the items into the cart
        // Printing our our statement
        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String item = shoppingCartList.getSelectionModel().getSelectedItem();
                Carryable[] i = shopper.getCart();
                float totalPrice;
                for (int b = 0; b < shopper.getNumItems(); b++) {
                    if (item == i[b].getDescription()) {
                        shopper.removeItem(i[b]);
                        inCart.remove(item);
                    }
                }
                totalPrice = shopper.totalCost();
                if (totalPrice == 0) {
                    checkoutButton.setDisable(true);
                }
                shoppingCartList.setItems(FXCollections.observableList(inCart));
                totalField.setText("$" + Float.toString(totalPrice));
            }
        });

        // Checkour Button on mouse click
        // Changing the event of all the buttons and making them blacked out
        // CHanging the font and text sixe
        // Remving them from the class with our for loop
        // usong the ArrayList
        checkoutButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buyButton.setDisable(true);
                returnButton.setDisable(true);
                productList.setDisable(true);
                checkoutButton.setText("Restart Shopping");
                checkoutButton.setStyle("-fx-font: 12 arial;");
                shopper.packBags();
                inCart.removeAll(inCart);

                for (int a=0; a<shopper.getNumItems(); a++) {
                    String item = shopper.getCart()[a].getDescription();
                    inCart.add(a, item);
                }
                shoppingCartList.setItems(FXCollections.observableArrayList(inCart));
            }
        });

        // Theoretically this doesn't work, and should be in the shopping button clicked
        // But I tired putting it here to see if it might work
        // Unsure why this part isn't working

        contentsList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String item = shoppingCartList.getSelectionModel().getSelectedItem();
                if (item.toLowerCase().contains("grocery bag")) {



                }
            }
        });
    }
}
