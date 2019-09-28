package miniproject.javafiles;

import miniproject.databasefiles.getMenu;

import java.sql.SQLException;
import java.util.ArrayList;

public class RestMenu {
    String []dishNames;
    int [] dishPrices;

    void getMenuFromDB() throws SQLException, ClassNotFoundException {
        getMenu gm = new getMenu();
        ArrayList <ArrayList> al = new ArrayList();
        al = gm.getMenuFromtable();
        ArrayList m = new ArrayList();
        ArrayList<Integer> p = new ArrayList();
        m = al.get(0);
        p = al.get(1);
        dishPrices = new int[p.size()];
        dishNames = new String[m.size()];

        for (int i = 0; i < p.size(); i++) {
            dishPrices[i] = p.get(i);
            dishNames[i] = m.get(i).toString();
        }

    }
    String[] getDishNames(){
        return dishNames;
    }
    int[]getDishPrices(){
        return dishPrices;
    }
}
