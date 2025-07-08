package com.tap.assesmentDb.Repository;

import java.sql.*;
import java.util.*;

import com.tap.assesmentDb.Entity.Question;

public class DbManager {

    public static Connection connection;

    static {
        try {
            String URL = "jdbc:mysql://localhost:3306/assessmentdb";
            String USERNAME = "root";
            String PASSWORD = "root123";
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
            System.out.println(e);
        }
    };

    public static ArrayList<Question> getAll() throws SQLException
        {
            ArrayList<Question> questions=new ArrayList<Question>();
            Statement smt = connection.createStatement();
            ResultSet rs = smt.executeQuery("select * from questionbank");

            ResultSetMetaData rmd = rs.getMetaData();
            int columncount = rmd.getColumnCount();
            for (int i = 1; i <= columncount; i++) {
                System.out.print(rmd.getColumnName(i) + "\t");
            }

            while (rs.next()) {
                Question question=new Question(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(1), rs.getInt(2));
                questions.add(question);
            }
           
            return questions;
        }

}
