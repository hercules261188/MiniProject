package miniproject.databasefiles;

import java.sql.*;
import java.util.ArrayList;

public class getMenu {
    String[] dishNames;
    int [] dishPrices;
    ArrayList <String>a1 = new ArrayList();
    ArrayList <Integer> a2 = new ArrayList();

    public void getMenuFromtable(String s) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/project", "root", "");
        String rest_name= s.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        if (connection != null) {

            String query = "SELECT * FROM "+rest_name+"";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String menu_item = rs.getObject(1).toString();
                int price = rs.getInt(2);
                a1.add(menu_item);
                a2.add(price);
            }
            dishNames = new String[a1.size()];
            dishPrices = new int[a2.size()];

            for (int i = 0; i < a1.size(); i++) {
                dishPrices[i] = a2.get(i);
                dishNames[i] = a1.get(i).toString();
            }
        }
    }

    public int[] getDishPrices()
    {
        return dishPrices;
    }
    public String [] getDishNames()
    {
        return dishNames;
    }
}