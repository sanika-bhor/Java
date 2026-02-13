package com.tap.tflassessment.servlet.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.tap.tflassessment.servlet.Entities.SubjectModel;
import com.tap.tflassessment.servlet.Services.SubjectService;
// import com.tap.tflassessment.servlet.IOC.IOCContainer;
import com.tap.tflassessment.servlet.Services.SubjectServiceImpl;
import com.tap.tflassessment.servlet.IOC.IOCContainer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper; // Add this import

@WebServlet("/api/subjects")
public class SubjectServlets extends HttpServlet {

   private SubjectService srv;

    @Override
    public void init() {
    srv = IOCContainer.getBean(SubjectService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // response.setContentType("application/json");
        // response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

      
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            
            List<SubjectModel> subjects = srv.getAllSubjects();
            // Convert the List directly to a JSON string
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, subjects);

        } catch (Exception e) {
            // response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println(e.getMessage());
        }
    }
}


// package com.tap.tflassessment.servlet.Servlets;

// import java.io.IOException;
// import java.io.PrintWriter;
// import java.rmi.ServerException;
// import java.util.List;
// import com.tap.tflassessment.servlet.Entities.SubjectModel;
// // import com.tap.tflassessment.servlet.IOC.IOCContainer;
// import com.tap.tflassessment.servlet.Services.SubjectService;
// import com.tap.tflassessment.servlet.Services.SubjectServiceImpl;

// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/api/subjects")
// public class SubjectServlets extends HttpServlet {

// // private SubjectService subjectService;
// // @Override
// // public void init()
// // {
// // subjectService=IOCContainer.getBean(SubjectService.class);
// // }

// @Override
// protected void doGet(HttpServletRequest request, HttpServletResponse
// response) throws ServerException, IOException {
// PrintWriter out = response.getWriter();
// SubjectService subjectService=new SubjectServiceImpl();
// try {
// response.setContentType("application/json");
// response.setCharacterEncoding("UTF-8");

// List<SubjectModel> subjects = subjectService.getAllSubjects();

// for (SubjectModel subject : subjects) {
// // out.println("id:" + subject.getId());
// // out.println("Title:" + subject.getTitle());
// out.println(subject);
// }

// } catch (Exception e) {
// out.println(e);
// }
// }

// }
