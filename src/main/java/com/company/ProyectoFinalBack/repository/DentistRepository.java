package com.company.ProyectoFinalBack.repository;


import com.company.ProyectoFinalBack.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {


}
