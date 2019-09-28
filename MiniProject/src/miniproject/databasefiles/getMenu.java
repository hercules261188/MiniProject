package miniproject.databasefiles;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class getMenu {
    public ArrayList getMenuFromtable() throws ClassNotFoundException, SQLException {

        ArrayList <ArrayList> a = new ArrayList();
        ArrayList <String>a1 = new ArrayList();
        ArrayList <Integer> a2 = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/project", "root", "");
        if(connection==null)
        {
            System.out.println("Entered");
        }
        System.out.println("Enter restaurant name");
        Scanner sc = new Scanner(System.in);
        String rest_name = sc.nextLine();
        if (connection != null) {

            String query = "SELECT * FROM "+rest_name+"";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                String menu_item = rs.getObject(1).toString();
                int price = rs.getInt(2);
                a1.add(menu_item);
                a2.add(price);
            }

            a.add(a1);
            a.add(a2);
        }
        return a;
    }
}