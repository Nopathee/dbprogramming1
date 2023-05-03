package dbprogramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB11 {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://127.0.0.1:3306/mydb1";
        String username = "root" ;
        String password = "Moofat123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM student " +
                    "WHERE studentID = '111111'";
            statement.executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE,null,e);
        } catch (SQLException e) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
