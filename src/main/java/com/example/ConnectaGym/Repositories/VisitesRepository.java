package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitesRepository extends JpaRepository<Visita, Long> {
}