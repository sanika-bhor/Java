package com.tap.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/databaseservice")
public class jdbcdemo extends HttpServlet{

    protected void doGet (HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
        try {
            String url="jdbc:mysql://localhost:3306/tflecommerce";
            String username="root";
            String password="password";
           
            PrintWriter pw=res.getWriter();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,username,password);          
            Statement st=conn.createStatement();  
 
                ResultSet rs = st.executeQuery("SELECT * FROM products");
                while (rs.next()) {
                        pw.println(rs.getInt(1) + "  " + rs.getString(2));
                    }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

