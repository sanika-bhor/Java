import java.sql.*;

public class jdbcConnection {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/college";
        String USERNAME = "root";
        String PASSWORD = "root123";
        Connection connection = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully...!!!");

            // Establish connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection established successfully...");

        } catch (Exception e) {
            e.printStackTrace();
         }
    }
}