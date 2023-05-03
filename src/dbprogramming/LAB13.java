package dbprogramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB13 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://127.0.0.1:3306/mydb1";
        String username = "root" ;
        String password = "Moofat123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(URL, username, password);
            String sql = "UPDATE student SET email= ? " +
                    "WHERE studentID = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , "zzzz@gmail.com");
            preparedStatement.setString(2 , "111111");
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            Logger.getLogger(LAB12.class.getName()).log(Level.SEVERE,null,e);
        } catch (SQLException e) {
            Logger.getLogger(LAB12.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
