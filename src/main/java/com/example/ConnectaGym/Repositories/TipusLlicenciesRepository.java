package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.TipusLlicencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipusLlicenciesRepository extends JpaRepository<TipusLlicencia, Long> {
    boolean existsByNom(String nom);

    @Query("SELECT tl FROM TipusLlicencia tl WHERE tl.creador.actiu = true")
    List<TipusLlicencia> findAllByCreadorActiu();
}
