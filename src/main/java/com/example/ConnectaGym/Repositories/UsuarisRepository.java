package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarisRepository extends JpaRepository<Usuari, Long> {
}