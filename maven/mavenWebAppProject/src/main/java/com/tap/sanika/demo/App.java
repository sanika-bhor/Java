package com.tap.sanika.demo;

/**
 * Hello world!
 *
 */
import java.sql.*;

import com.tap.sanika.Repository.TflMentoringRepo;

public class App {
    public static void main(String[] args) throws Exception {
       TflMentoringRepo repo=new TflMentoringRepo();
       repo.getAll();
    }
}