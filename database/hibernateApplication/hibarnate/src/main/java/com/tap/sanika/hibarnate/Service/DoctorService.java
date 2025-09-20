package com.tap.sanika.hibarnate.Service;

import com.tap.sanika.hibarnate.Entity.Doctor;

public interface DoctorService {

    Boolean addDoctor(String firstName, String lastName, String specialization, String phone);

    Doctor getDoctor(int id);

    Boolean updateDoctorPhone(int id, String newPhone);

    Boolean deleteDoctor(int id);
}
