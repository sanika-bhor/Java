package com.tap.sanika.JPAapp.repository;

import com.tap.sanika.JPAapp.entity.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepositoryHbl implements DoctorRepository {

    @Override
    public Boolean addDoctor(String firstName, String lastName, String specialization, String phone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDoctor'");
    }

    @Override
    public Doctor getDoctor(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDoctor'");
    }

    @Override
    public Boolean updateDoctorPhone(int id, String newPhone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDoctorPhone'");
    }

    @Override
    public Boolean deleteDoctor(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDoctor'");
    }

    
   

}
