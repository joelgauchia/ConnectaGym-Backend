package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Propietari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarisRepository extends JpaRepository<Propietari, Long> {

}

