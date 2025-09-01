package com.tap.sanika.JPAapp.service;

import org.springframework.stereotype.Service;

import com.tap.sanika.JPAapp.entity.Doctor;
import com.tap.sanika.JPAapp.repository.DoctorRepository;

@Service
public class DoctorServiceJpa implements DoctorService {

    private final DoctorRepository doctorRepository;

    // Constructor injection (we use Hibernate implementation here)
    public DoctorServiceJpa(DoctorRepository repo) {
        this.doctorRepository =repo;
    }

    @Override
    public Boolean addDoctor(String firstName, String lastName, String specialization, String phone) {
        return doctorRepository.addDoctor(firstName, lastName, specialization, phone);
    }

    @Override
    public Doctor getDoctor(int id) {
        return doctorRepository.getDoctor(id);
    }

    @Override
    public Boolean updateDoctorPhone(int id, String newPhone) {
        return doctorRepository.updateDoctorPhone(id, newPhone);
    }

    @Override
    public Boolean deleteDoctor(int id) {
        return doctorRepository.deleteDoctor(id);
    }
}
