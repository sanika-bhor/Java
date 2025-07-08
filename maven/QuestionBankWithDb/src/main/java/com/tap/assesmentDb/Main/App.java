package com.tap.assesmentDb.Main;

import java.sql.*;
import java.util.ArrayList;

import com.tap.assesmentDb.Entity.Question;
import com.tap.assesmentDb.Repository.DbManager;

public class App {
    public static void main(String[] args) throws Exception {
       
       ArrayList<Question> questions=new ArrayList<Question>();
       questions= DbManager.getAll();
       for(Question q:questions)
       {
        System.out.println(q);
       }
    }
}
