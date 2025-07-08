package com.tap.assesmentDb.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

public class DbManager {
         
          public static Connection connection;
          public static Statement smt;
        static{
            try
            {
                String URL = "jdbc:mysql://localhost:3306/assessmentdb";
                String USERNAME = "root";
                String PASSWORD = "root123";
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                smt = (Statement) connection.createStatement();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        };

        
}
