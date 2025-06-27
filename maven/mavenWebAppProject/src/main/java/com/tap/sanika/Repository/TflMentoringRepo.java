package com.tap.sanika.Repository;

import java.sql.*;

import com.tap.sanika.Repository.Interface.*;
import com.tap.sanika.Utils.DbConnection;

public class TflMentoringRepo implements ITflMentoringRepo {

    public void getAll() {
        try {
            DbConnection dbconn = new DbConnection();
            Connection conn = dbconn.getConnectionDb();
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("select * from student");
            ResultSetMetaData rmd = rs.getMetaData();
            int columncount = rmd.getColumnCount();
            System.out.println("Topics");
            for (int i = 1; i <= columncount; i++) {
                System.out.print(rmd.getColumnName(i) + "\t");
            }
            System.out.println("\n*");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) );
                System.out.println();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
