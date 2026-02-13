package com.tap.tflassessment.servlet.Repositories;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tap.tflassessment.servlet.Entities.SubjectModel;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;

public class SubjectRepositoryImpl implements SubjectRepository {


    private ObjectMapper mapper=new ObjectMapper();

    public SubjectRepositoryImpl(){}
    // public int serialize(SubjectModel subject){
    //     try{
    //        mapper.writeValue(new File("/src/main/resources/subject.json"), subject);
    //     }catch(Exception e){
    //         e.printStackTrace();
    //     }
    //     return 1;
    // }

    public List<SubjectModel> getAllSubjects(){
        List<SubjectModel> subjectList=new ArrayList<>();
        try{
            InputStream input = getClass().getClassLoader().getResourceAsStream("data/subjects.json");
            subjectList = mapper.readValue(input,new TypeReference<List<SubjectModel>>() {});
        }catch(Exception e){
            e.printStackTrace();
        }
        return subjectList;
    }




    @Override
    public int addSubject(SubjectModel subject) {

        throw new UnsupportedOperationException("Unimplemented method 'addSubject'");
    }

    @Override
    public int deleteSubject(int subjectId) {

        throw new UnsupportedOperationException("Unimplemented method 'deleteSubject'");
    }

    @Override
    public List<SubjectModel> getSubjectByEmployeeId(int smeId) {
        throw new UnsupportedOperationException("Unimplemented method 'getSubjectByEmployeeId'");
    }

}
