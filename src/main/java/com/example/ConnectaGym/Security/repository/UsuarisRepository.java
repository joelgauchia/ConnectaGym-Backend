package com.example.ConnectaGym.Security.repository;

import com.example.ConnectaGym.Security.entity.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarisRepository extends JpaRepository<Usuari, Long> {
    Optional<Usuari> findByNomUsuari(String nomUsuari);
    Optional<Usuari> findByNomUsuariOrEmail(String nomUsuari, String email);
    Optional<Usuari> findByTokenPassword(String tokenPassword);
    boolean existsByNomUsuari(String nomUsuari);
    boolean existsByEmail(String email);
}