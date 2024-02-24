package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.MembreGimnas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresGimnasosRepository extends JpaRepository<MembreGimnas, Long> {

}
