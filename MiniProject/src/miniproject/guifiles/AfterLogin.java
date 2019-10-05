package miniproject.guifiles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import miniproject.javafiles.JavaMain;
import miniproject.javafiles.RestMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Random;


public class AfterLogin extends Application {
    JavaMain j;
    String uname;
    AfterLogin(JavaMain user,String uname) throws FileNotFoundException {
        j=user;
        this.uname=uname;
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setX(100);
        primaryStage.setY(100);

        /*GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10));
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(gridPane);
        Label [] restNames=new Label[RestMap.restNo];
        Label [] restStreets=new Label[RestMap.restNo];
        Label [] restDistance=new Label[RestMap.restNo];
        Label [] restDeliveryTime=new Label[RestMap.restNo];
        for (int i=0;i<RestMap.restNo;i++){
            restNames[i]=new Label(j.restData[i][0]);
            restStreets[i]=new Label( j.restData[i][1]);
            restDistance[i]=new Label(Float.toString(j.deliveryData[i][0]));
            restDeliveryTime[i]=new Label(Float.toString(j.deliveryData[i][1]));
        }
        for (int i =0; i<RestMap.restNo;i++){
            restNames[i].setFont(new Font("Arial",20));
        }
        for (int i=0;i<RestMap.restNo;i++){
            gridPane.add(restNames[i],0,i);
            gridPane.add(restStreets[i],1,i);
            gridPane.add(restDistance[i],2,i);
            gridPane.add(restDeliveryTime[i],3,i);
        }
         */
        ScrollPane scrollPane= new ScrollPane();
        //scrollPane.setPadding(new Insets(0,50,50,700));


        VBox vBox=new VBox(20);
        //vBox.setAlignment(Pos.TOP_CENTER);
        VBox[]vBoxes=new VBox[RestMap.restNo];
        for(int i=0;i<RestMap.restNo;i++){
            vBoxes[i]=new VBox();
        }

        Label [] restNames=new Label[RestMap.restNo];
        Label [] restStreets=new Label[RestMap.restNo];
        Label [] restDistance=new Label[RestMap.restNo];
        Label [] restDeliveryTime=new Label[RestMap.restNo];

        for (int i=0;i<RestMap.restNo;i++){
            restNames[i]=new Label(j.restData[i][0]);
            restNames[i].setFont(new Font("Arial",20));
            restStreets[i]=new Label( j.restData[i][1]);
            restDistance[i]=new Label(Float.toString(j.deliveryData[i][0]));
            restDeliveryTime[i]=new Label(Float.toString(j.deliveryData[i][1]));
        }
        for(int i=0;i<RestMap.restNo;i++){
            vBoxes[i]=new VBox(restNames[i],restStreets[i],restDeliveryTime[i],restDistance[i]);
        }
        Label labelForMessage= new Label("Welcome, "+(uname)+"");
        labelForMessage.setFont(Font.font("Verdana", FontWeight.BOLD,20));
        labelForMessage.setAlignment(Pos.TOP_RIGHT);
        vBox.getChildren().add(labelForMessage);
        for(int i=0;i<RestMap.restNo;i++){
            vBox.getChildren().add(vBoxes[i]);
        }
        //scrollPane.setHvalue(150);
        scrollPane.setContent(vBox);
        //vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
        //scrollPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));

        for(int i=0;i<RestMap.restNo;i++){
            String temp=restNames[i].getText().toLowerCase().replaceAll(" ","");
            restNames[i].setOnMouseClicked(e -> {
                try {
                    new MenuGUI(temp);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            });
        }

        //FileInputStream fs= new FileInputStream("C:\\Users\\Darshan\\Desktop\\MINIMINI-master\\MiniProject\\src\\miniproject\\guifiles\\1.jpg");
        //Image i= new Image(fs);
        //scrollPane.setBackground(new Background(new BackgroundImage(i, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));

        Scene scene=new Scene(scrollPane,250,500);
        primaryStage.setTitle("Suggestions");
        primaryStage.setScene(scene);
        //primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}