package miniproject.guifiles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import miniproject.databasefiles.getMenu;

import java.sql.SQLException;
import java.util.ArrayList;

public class MenuGUI extends Application {
    String selectedRestName;
    String[] dishesToDisplay;
    int[]  pricesToDisplay;
    ArrayList <String> cartDishes= new ArrayList<>();
    ArrayList <Integer> cartPrices= new ArrayList<>();
    int cartCount=0;


    MenuGUI(String selectedRestName) throws SQLException, ClassNotFoundException {
        this.selectedRestName=selectedRestName;
        getMenu g= new getMenu();
        g.getMenuFromtable(selectedRestName);
        dishesToDisplay=g.getDishNames();
        pricesToDisplay=g.getDishPrices();
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setX(100);
        primaryStage.setY(100);

        HBox welcome= new HBox();
        //Label restInfo= new Label(selectedRestName);
        Label itemsInCart= new Label("Items in cart "+cartCount);
        //welcome.getChildren().add(restInfo);
        Label dishTitle= new Label("DISHES");
        Label priceTitle= new Label("PRICES");

        GridPane gridPane= new GridPane();
        gridPane.setHgap(50);

        VBox dishBox= new VBox();
        VBox priceBox= new VBox();

        Button[]dishButton=new Button[dishesToDisplay.length];
        Button[]priceButton= new Button[pricesToDisplay.length];
        Button goToCart=new Button("Go to cart");

        for (int i=0;i<dishesToDisplay.length;i++){
            dishButton[i]= new Button(dishesToDisplay[i]);
            priceButton[i]= new Button(""+pricesToDisplay[i]);
        }

        for (int i=0;i<dishesToDisplay.length;i++){
            dishBox.getChildren().add(dishButton[i]);
            priceBox.getChildren().add(priceButton[i]);
        }

        gridPane.add(welcome,0,0);
        gridPane.add(dishTitle,0,1);
        gridPane.add(priceTitle,1,1);
        gridPane.add(dishBox,0,2);
        gridPane.add(priceBox,1,2);

        VBox ultimateBox= new VBox();
        ultimateBox.setSpacing(10);
        ultimateBox.getChildren().add(gridPane);
        ultimateBox.getChildren().add(itemsInCart);
        ultimateBox.getChildren().add(goToCart);

        for(int i=0;i<dishButton.length;i++){
            String tempName= dishButton[i].getText();
            int tempPrice=Integer.parseInt(priceButton[i].getText());
            dishButton[i].setOnMouseClicked(event -> {
                cartDishes.add(tempName);
                cartPrices.add(tempPrice);
                itemsInCart.setText("Items in cart "+(++cartCount));
            });
        }
        goToCart.setOnMouseClicked(event -> {
            new Cart(cartDishes,cartPrices);
        });
        ScrollPane sc= new ScrollPane();
        sc.setContent(ultimateBox);

        Scene scene= new Scene(sc,500,300);
        primaryStage.setTitle(selectedRestName);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}