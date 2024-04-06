package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.MembreGimnas;
import com.example.ConnectaGym.Entities.Propietari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembresGimnasosRepository extends JpaRepository<MembreGimnas, Long> {
    boolean existsByNom(String nom);
    boolean existsByEmail(String email);
    boolean existsByTelefon(String telefon);

    @Query("SELECT m FROM MembreGimnas m WHERE m.creador.actiu = true")
    List<MembreGimnas> findAllByCreadorActiu();
}
