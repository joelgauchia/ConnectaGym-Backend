package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Ajustament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AjustamentsRepository extends JpaRepository<Ajustament, Long> {
}