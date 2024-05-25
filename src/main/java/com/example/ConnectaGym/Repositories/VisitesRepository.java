package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitesRepository extends JpaRepository<Visita, Long> {
    List<Visita> findByGimnas_Nom(String nomGimnas);
}