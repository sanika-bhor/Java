package com.tap.sanika.hibarnate.Repository;

import com.tap.sanika.hibarnate.Entity.Doctor;

public interface DoctorRepository {

    Boolean addDoctor(String firstName, String lastName, String specialization, String phone);

    Doctor getDoctor(int id);

    Boolean updateDoctorPhone(int id, String newPhone);

    Boolean deleteDoctor(int id);
}
