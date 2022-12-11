package com.company.ProyectoFinalBack.repository;


import com.company.ProyectoFinalBack.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("from Patient o where o.dni like %:dni%")
    Patient searchPatientByDni(String dni);

}
