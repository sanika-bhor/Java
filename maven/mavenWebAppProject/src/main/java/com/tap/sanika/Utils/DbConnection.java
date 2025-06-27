package com.tap.sanika.Utils;

import java.sql.*;

public class DbConnection {
    
    private String URL = "jdbc:mysql://localhost:3306/tflmentoringdb";
    private String USERNAME = "root";
    private String PASSWORD = "root123";
    private Connection conn = null;

   public Connection getConnectionDb() throws Exception
    {
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }
}
