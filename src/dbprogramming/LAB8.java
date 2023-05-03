package dbprogramming;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB8 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://127.0.0.1:3306/mydb1";
        String username = "root" ;
        String password = "Moofat123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection(URL, username, password);
            System.out.println("Database Connected");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM student" ;
            ResultSet results = statement.executeQuery(sql);

            while (results.next()){
                System.out.println(results.getString(1)+" "+results.getString(2)+" "
                + results.getString(3)+" "+results.getString(4)+" "+results.getString(5));
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}