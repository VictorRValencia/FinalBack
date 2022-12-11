package com.company.ProyectoFinalBack.repository;

import com.company.ProyectoFinalBack.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Integer> {
}
