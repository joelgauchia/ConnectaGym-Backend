package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolsRepository extends JpaRepository<Rol, Long> {

}
