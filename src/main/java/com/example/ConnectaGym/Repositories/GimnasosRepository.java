package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Gimnas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GimnasosRepository extends JpaRepository<Gimnas, Long> {
}
