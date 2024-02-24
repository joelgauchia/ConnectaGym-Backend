package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.TipusLlicencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipusLlicenciesRepository extends JpaRepository<TipusLlicencia, Long> {
}
