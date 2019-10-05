package miniproject.guifiles;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.ImageCursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import miniproject.javafiles.JavaMain;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Collections;


public class LoginPage extends Application {
    JavaMain j;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setX(100);
        primaryStage.setY(100);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 50, 50, 50));

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 30));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        ObservableList<String> allStreets= FXCollections.observableArrayList();
        allStreets.addAll("Cama Road","Patel Road","Gilbert Hill Road","Juhu Lane","CHS Lane","Kripa Lane","Irla Road","Dhobi Ghat Road","Dadabhai Road","Lajpatrai Road","Sarojini Road","Church Road","VP Road","St. Braz Road","Kutir Road","Janki Lane","Birla Road","Tukaram Road","Saibaba Road","Dattataray Road","Bhargav Road","Patil Road","Talmaki Road","Tilak Road","Chapel Lane");

        ComboBox cb=new ComboBox(allStreets);

        Label labelUsername = new Label("Username");
        final TextField textUsername = new TextField();

        Label labelStreet= new Label("Street");

        Button buttonLogin = new Button("Login");
        final Label labelMessage = new Label();

        gridPane.add(labelUsername, 0, 0);
        gridPane.add(textUsername, 1, 0);
        gridPane.add(labelStreet, 0, 1);
        gridPane.add(cb, 1, 1);
        gridPane.add(buttonLogin, 1, 2);
        gridPane.add(labelMessage, 1, 3);


        buttonLogin.setOnAction(e -> {
            primaryStage.close();
            try {
                j=new JavaMain(textUsername.getText().toString(),cb.getValue().toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                new AfterLogin(j,textUsername.getText());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        });

        borderPane.setTop(hBox);
        borderPane.setCenter(gridPane);
        FileInputStream fs = new FileInputStream("C:\\Users\\Darshan\\Desktop\\MINIMINI-master\\MiniProject\\src\\miniproject\\guifiles\\1.jpg");
        Image i= new Image(fs);
        borderPane.setBackground(new Background(new BackgroundImage(i,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("LoginWindow");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}