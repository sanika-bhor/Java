package com.tap.sanika.JPAapp.repository;

import com.tap.sanika.JPAapp.entity.Doctor;

public interface DoctorRepository {

    Boolean addDoctor(String firstName, String lastName, String specialization, String phone);

    Doctor getDoctor(int id);

    Boolean updateDoctorPhone(int id, String newPhone);

    Boolean deleteDoctor(int id);
}
