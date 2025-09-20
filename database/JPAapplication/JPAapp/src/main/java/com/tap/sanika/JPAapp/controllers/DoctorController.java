package com.tap.sanika.JPAapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tap.sanika.JPAapp.entity.Doctor;
import com.tap.sanika.JPAapp.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DoctorController {
    
    @Autowired
    private DoctorService srv;

    @GetMapping("/doctors/all/{id}")
    public Doctor getDoctors(@PathVariable("id") int id) {
        return srv.getDoctor(id);
    }
    
    @PostMapping("/doctors/add")
    public String insertDoctors(@RequestBody Doctor newDoctor) {
         Boolean status=srv.addDoctor(newDoctor.getFirstName(), newDoctor.getLastName(), newDoctor.getSpecialization(), newDoctor.getPhone());
         if(status)
         {
         return "data inserted";
         }
         else
         {
         return "data not inserted";
         }
    }

    @PutMapping("/doctors/update/{id}")
    public String updateDoctors(@PathVariable("id") int id, @RequestParam String phno) {
        Boolean status = srv.updateDoctorPhone(id,phno);
        if (status) {
            return "data updated";
        } else {
            return "data not updated";
        }
    }

    @DeleteMapping("/doctors/delete/{id}")
    public String deleteDoctors(@PathVariable("id") int id) {
        Boolean status = srv.deleteDoctor(id);
        if (status) {
            return "data deleted";
        } else {
            return "data not deleted";
        }
    }
}
