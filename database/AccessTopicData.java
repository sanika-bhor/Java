import java.sql.*;

public class AccessTopicData {
    public static void main(String[] args) throws Exception {
        String URL = "jdbc:mysql://localhost:3306/tflmentoringdb";
        String USERNAME = "root";
        String PASSWORD = "root123";
        Connection connection = null;

        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connection established successfully...");

        System.out.println();
        System.out.println();
        System.out.println();
        Statement smt = connection.createStatement();
        ResultSet rs = smt.executeQuery("select * from topics");

        // ResultSetMetaData rmd = rs.getMetaData();
        // int columncount = rmd.getColumnCount();
        // System.out.println("Topics");
        // for (int i = 1; i <= columncount; i++) {
        //     System.out.print(rmd.getColumnName(i) + "\t");
        // }
        
        
        System.out.println("\n***********************");
        while (rs.next()) {
            System.out.println(" { "+"id: "+rs.getInt(1) + " , SubjectId: " + rs.getString(2) + " , Question: " + rs.getString(3)+" , Option A: "+rs.getString(4)+ " , Option B: " + rs.getString(4) + " , Option A: " + rs.getString(4) + " , Option A: "
                    + rs.getString(4));
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("topics display successfully....");
        connection.close();
    }
}
