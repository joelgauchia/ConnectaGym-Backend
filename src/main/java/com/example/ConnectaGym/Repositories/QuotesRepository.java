package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Quota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotesRepository extends JpaRepository<Quota, Long> {
    List<Quota> findByGimnas_Nom(String nomGimnas);
    boolean existsByNom(String nom);

    @Query("SELECT q FROM Quota q WHERE q.creador.actiu = true")
    List<Quota> findAllByCreadorActiu();
}