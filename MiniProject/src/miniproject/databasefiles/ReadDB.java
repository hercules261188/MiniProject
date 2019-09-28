package miniproject.databasefiles;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class ReadDB {
   public ArrayList read_db_stname() throws ClassNotFoundException, SQLException {

        ArrayList a = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/project", "root", "");
        if (connection != null) {
            String query = "SELECT * FROM Restaurants";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String stname = rs.getObject(2).toString();
                a.add(stname);
            }
        }
        return a;
    }
   public  ArrayList read_db_name() throws ClassNotFoundException, SQLException {

        ArrayList<String> a = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/project", "root", "");
        if (connection != null) {
            String query = "SELECT * FROM Restaurants";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getObject(1).toString();
                a.add(name);
            }
        }
        return a;
    }

}