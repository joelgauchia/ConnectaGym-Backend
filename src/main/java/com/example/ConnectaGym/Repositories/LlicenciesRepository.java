package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Llicencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LlicenciesRepository extends JpaRepository<Llicencia, Long> {
    List<Llicencia> findByActivaTrue();

    List<Llicencia> findByActivaFalse();
}
