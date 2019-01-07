package tools.mysql;

import com.mysql.jdbc.Driver;

import java.sql.*;


public class MySQLTest {


    public static void main(String[] args) {

        Driver driver;
        Connection connection;
        Statement statement;
        ResultSet set;

        try {
            driver = new Driver();
             DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/idm", "root", "root");
            statement = connection.createStatement();
            set = statement.executeQuery("select * from ss_user");
            while (set.next()) {
                System.out.println(set.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
