import java.sql.Connection;
import java.sql.*;

public class insert_data {
    public static void main(String[] args) {
        // Create a connection to the database4
        String URL = "jdbc:mysql://localhost:3306/college";
        String USERNAME = "root";
        String PASSWORD = "root123";
        String query = "INSERT INTO student VALUES (1,'nikita',19)";
        try{
             Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
             System.out.println("Connection establish successfully");

             Statement smt=conn.createStatement();
             smt.executeUpdate(query);
             System.out.println("Data inserted successfully.......");
             conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
