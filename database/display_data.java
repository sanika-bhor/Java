import java.sql.*;

public class display_data
{
    public static void main(String[] args)throws Exception 
    {
        String URL = "jdbc:mysql://localhost:3306/college";
        String USERNAME = "root";
        String PASSWORD = "root123";
        Connection connection = null;

        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connection established successfully...");

        System.out.println();
        System.out.println();
        System.out.println();
        Statement smt= connection.createStatement();
        ResultSet rs= smt.executeQuery("select * from student");

        ResultSetMetaData rmd=rs.getMetaData();
        int columncount=rmd.getColumnCount();
        System.out.println("Student Information");
        for(int i=1;i<=columncount;i++)
        {
            System.out.print(rmd.getColumnName(i)+"\t");
        }
        System.out.println("\n***********************");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("record display successfully....");
        connection.close();
    }
}
