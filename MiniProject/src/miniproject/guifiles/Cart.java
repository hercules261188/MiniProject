package miniproject.guifiles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Cart extends Application {
    ArrayList<String> cartDishes;
    ArrayList<Integer> cartPrices;
    int orderTotal=0;
    Cart(ArrayList a, ArrayList b) {
        cartDishes = a;
        cartPrices=b;
        start(new Stage());
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setX(100);
        primaryStage.setY(100);

        VBox vBox= new VBox();
        vBox.setSpacing(10);
        GridPane gridPane= new GridPane();
        gridPane.setHgap(50);
        Label[]dishLabels= new Label[cartDishes.size()];
        Label[]priceLabels= new Label[cartPrices.size()];
        for (int i=0;i<cartDishes.size();i++){
            dishLabels[i]=new Label(cartDishes.get(i));
            priceLabels[i]=new Label(""+cartPrices.get(i));
        }
        for (int i=0;i<cartDishes.size();i++){
            gridPane.add(dishLabels[i],0,i);
            gridPane.add(priceLabels[i],1,i);
        }
        for (int i=0;i<cartPrices.size();i++){
            orderTotal+=cartPrices.get(i);
        }
        Label cartTitle= new Label("CART");
        Label total= new Label("Order total: "+orderTotal);
        Button closeButton= new Button("Place Order");
        vBox.getChildren().addAll(cartTitle,gridPane,total,closeButton);

        closeButton.setOnMouseClicked(event -> {
            Label temp= new Label("Order placed!");
            vBox.getChildren().add(temp);
            closeButton.setVisible(false);
        });

        Scene scene= new Scene(vBox,300,300);
        primaryStage.setTitle("Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}