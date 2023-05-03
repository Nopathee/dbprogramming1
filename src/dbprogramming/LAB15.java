package dbprogramming;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class LAB15 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://127.0.0.1:3306/mydb1";
        String username = "root" ;
        String password = "Moofat123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(URL, username, password);
            Statement statement= connection.createStatement();
            String sql = "SELECT * FROM student" ;
            ResultSet results= statement.executeQuery(sql);
            ResultSetMetaData rsMetaData= results.getMetaData();
            System.out.println(rsMetaData.getColumnCount());

            for (int i =1 ; i <= rsMetaData.getColumnCount() ; i++){
                System.out.println(rsMetaData.getColumnName(i));
            }

        } catch (ClassNotFoundException e) {
            Logger.getLogger(LAB15.class.getName()).log(Level.SEVERE,null,e);
        } catch (SQLException e) {
            Logger.getLogger(LAB15.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
