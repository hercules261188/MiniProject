package miniproject.guifiles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import miniproject.javafiles.JavaMain;
import miniproject.javafiles.RestMap;


public class AfterLogin extends Application {
    JavaMain j;
    AfterLogin(JavaMain user){
        j=user;
        start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10));

        Label[] restNames=new Label[RestMap.restNo];
        Label [] restStreets=new Label[RestMap.restNo];
        Label [] restDistance=new Label[RestMap.restNo];
        Label [] restDeliveryTime=new Label[RestMap.restNo];

        for (int i=0;i<RestMap.restNo;i++){
            restNames[i]=new Label(j.restData[i][0]);
            restStreets[i]=new Label( j.restData[i][1]);
            restDistance[i]=new Label(Float.toString(j.deliveryData[i][0]));
            restDeliveryTime[i]=new Label(Float.toString(j.deliveryData[i][1]));
        }
        for (int i=0;i<RestMap.restNo;i++){
            gridPane.add(restNames[i],0,i);
            gridPane.add(restStreets[i],1,i);
            gridPane.add(restDistance[i],2,i);
            gridPane.add(restDeliveryTime[i],31,i);
        }

        Scene scene=new Scene(gridPane);
        primaryStage.setTitle("After Search");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
