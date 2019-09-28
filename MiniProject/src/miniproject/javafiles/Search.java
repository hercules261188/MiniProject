package miniproject.javafiles;
import java.util.Random;

public class Search {
    String [][]restData=new String[RestMap.restNo][2];
    float [][]deliveryData=new float[RestMap.restNo][2];
    void search(RestMap []rs,BlockMap bm,User u){
        String temp1;double temp2;
        restData=new String[RestMap.restNo][2];
        double []distance= new double[RestMap.restNo];

        for (int i=0;i<RestMap.restNo;i++) {//INSERT
            restData[i][0]=rs[i].name;
            restData[i][1]=rs[i].street;
        }
        for (int i=0;i<RestMap.restNo;i++){
            distance[i]=Math.sqrt(Math.pow(((bm.getX(restData[i][1]))-u.x),2)+Math.pow(((bm.getY(restData[i][1]))-u.y),2));
        }

        for (int i=0;i<RestMap.restNo;i++){//SORT
            for (int j=0;j<RestMap.restNo-1-i;j++){
                if (distance[j]>distance[j+1]){
                    temp2=distance[j];
                    distance[j]=distance[j+1];
                    distance[j+1]=temp2;
                    for (int k=0;k<2;k++){
                        temp1=restData[j][k];
                        restData[j][k]=restData[j+1][k];
                        restData[j+1][k]=temp1;
                    }
                }
            }
        }
        Random random=new Random();
        for (int i=0;i<RestMap.restNo;i++){
            deliveryData[i][0]=(float)distance[i];
            deliveryData[i][1]=(float) Math.floor(distance[i]*13)+11+random.nextInt(((5-1)+1)+1);
        }

    }
    String [][] getRestData(){
        return restData;
    }
    float[][] getDeliveryData(){
        return deliveryData;
    }
}
