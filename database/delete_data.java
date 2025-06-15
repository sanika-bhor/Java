import java.sql.Connection;
import java.util.Scanner;
import java.sql.*;

public class delete_data {
    public static void main(String[] args) {
        // Create a connection to the database4
        String URL = "jdbc:mysql://localhost:3306/college";
        String USERNAME = "root";
        String PASSWORD = "root123";
        String query = "delete from student where id=?";

        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection establish successfully");

            Scanner sc=new Scanner(System.in);
            System.out.println("enter id that you want to delete");
            int id=sc.nextInt();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully.......");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
