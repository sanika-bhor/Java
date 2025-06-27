package com.tap.sanika.Repository.Interface;

public interface ITflMentoringRepo {

    void getAll();
    
    boolean insert(int id,String title,String Url,int repoid);

    boolean update(int id,String title,String Url,int repoid);
    
    boolean delete(int id);
}