package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Propietari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarisRepository extends JpaRepository<Propietari, Long> {
    boolean existsByEmail(String email);
}

