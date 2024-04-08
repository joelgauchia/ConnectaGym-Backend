package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Entities.Propietari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GimnasosRepository extends JpaRepository<Gimnas, Long> {
    boolean existsByNom(String nom);
    boolean existsByEmail(String email);
    boolean existsByTelefon(String telefon);

    List<Gimnas> findByPropietariId(Long propietariId);

    @Query("SELECT g FROM Gimnas g WHERE g.creador.actiu = true")
    List<Gimnas> findAllByCreadorActiu();
}
