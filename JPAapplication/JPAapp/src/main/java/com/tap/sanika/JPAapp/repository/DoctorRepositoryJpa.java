package com.tap.sanika.JPAapp.repository;

import com.tap.sanika.JPAapp.entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DoctorRepositoryJpa implements DoctorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean addDoctor(String firstName, String lastName, String specialization, String phone) {
        try {
            Doctor doctor = new Doctor(firstName, lastName, specialization, phone);
            entityManager.persist(doctor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Doctor getDoctor(int id) {
        return entityManager.find(Doctor.class, id);
    }

    @Override
    public Boolean updateDoctorPhone(int id, String newPhone) {
        try {
            Doctor doctor = entityManager.find(Doctor.class, id);
            if (doctor != null) {
                doctor.setPhone(newPhone); 
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteDoctor(int id) {
        try {
            Doctor doctor = entityManager.find(Doctor.class, id);
            if (doctor != null) {
                entityManager.remove(doctor);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
