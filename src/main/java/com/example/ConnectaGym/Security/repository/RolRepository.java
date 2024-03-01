package com.example.ConnectaGym.Security.repository;

import com.example.ConnectaGym.Security.entity.Rol;
import com.example.ConnectaGym.Security.enums.RolNom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolNom(RolNom rolNom);
}
