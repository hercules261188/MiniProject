package miniproject.javafiles;

import miniproject.databasefiles.ReadDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class JavaMain {
    public String  userName,streetName;
    public String [][]restData;
    public float [][]deliveryData;
    public JavaMain(String u,String st) throws SQLException, ClassNotFoundException {
        userName=u;
        streetName=st;
        javaMain();
    }
    public  void javaMain() throws SQLException, ClassNotFoundException {

        BlockMap bm= new BlockMap();
        bm.createMap();
        User u=new User(userName,streetName);
        //System.out.println("Welcome "+userName+"\nThese are some restaurant recommendations near "+streetName+":");
        u.x=bm.getX(u.street);
        u.y=bm.getY(u.street);

        ReadDB rdb = new ReadDB();
        ArrayList<String> a = new ArrayList<String>();
        ArrayList <String>b = new ArrayList<String>();
        b = rdb.read_db_stname();
        a = rdb.read_db_name();

        String []restName= new String[40];
        String []restStreetName= new String[40];

        restName = a.toArray(restName);
        restStreetName= b.toArray(restStreetName);

        RestMap []rs=new RestMap[RestMap.restNo];
        for (int i=0;i<RestMap.restNo;i++){
            rs[i]=new RestMap();
            rs[i].name=restName[i];
            rs[i].street=restStreetName[i];
        }
        Search search= new Search();
        search.search(rs,bm,u);
        restData=new String[2][10];
        restData=search.getRestData();
        deliveryData=new float[2][10];
        deliveryData=search.getDeliveryData();


    }
}
