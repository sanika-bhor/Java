package com.tap.sanika.hibarnate.Repository;

import com.tap.sanika.hibarnate.Entity.Doctor;
import com.tap.sanika.hibarnate.Util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepositoryHbl implements DoctorRepository {

    
    // CREATE
    @Override
    public Boolean addDoctor(String firstName, String lastName, String specialization, String phone) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction(); // Start transaction

            Doctor doctor = new Doctor(firstName, lastName, specialization, phone);
            session.save(doctor);

            session.getTransaction().commit(); // Commit transaction
            System.out.println("Doctor saved successfully!");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ
    @Override
    public Doctor getDoctor(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Doctor.class, id);
        }
    }

    // UPDATE
    @Override
    public Boolean updateDoctorPhone(int id, String newPhone) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction(); // Start transaction

            Doctor doctor = session.get(Doctor.class, id);
            if (doctor != null) {
                doctor.setPhone(newPhone);
                session.update(doctor);
                System.out.println("Doctor phone updated!");
            }

            session.getTransaction().commit(); // Commit transaction
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    @Override
    public Boolean deleteDoctor(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction(); // Start transaction

            Doctor doctor = session.get(Doctor.class, id);
            if (doctor != null) {
                session.delete(doctor);
                System.out.println("Doctor deleted!");
            }

            session.getTransaction().commit(); // Commit transaction
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
