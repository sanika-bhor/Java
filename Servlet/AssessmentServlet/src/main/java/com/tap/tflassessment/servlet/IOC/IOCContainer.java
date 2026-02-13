package com.tap.tflassessment.servlet.IOC;

import java.util.HashMap;
import java.util.Map;

//-----------------Simple IOC Container without Annotations -----------------
import com.tap.tflassessment.servlet.Services.SubjectService;

import com.tap.tflassessment.servlet.Services.SubjectServiceImpl;

public class IOCContainer  {
    private static Map<Class<?>,Object> beans=new HashMap<>();

    static{
        beans.put(SubjectService.class,new SubjectServiceImpl());
    }

    public static<T> T getBean(Class<T> clazz)
    {
        return clazz.cast(beans.get(clazz));
    }

}
