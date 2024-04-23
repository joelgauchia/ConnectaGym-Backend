package com.example.ConnectaGym.Security.repository;

import com.example.ConnectaGym.Security.entity.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarisRepository extends JpaRepository<Usuari, Long> {
    Usuari findByNomUsuari(String nomUsuari);
    Usuari findByEmail(String email);
    Optional<Usuari> findByNomUsuariOrEmail(String nomUsuari, String email);
    boolean existsByNomUsuari(String nomUsuari);
    boolean existsByEmail(String email);
    Usuari findByNomUsuariAndActiuIsTrue(String nomUsuari);
}