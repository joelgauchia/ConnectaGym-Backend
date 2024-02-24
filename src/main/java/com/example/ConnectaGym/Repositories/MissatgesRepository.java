package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Missatge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissatgesRepository extends JpaRepository<Missatge, Long> {
}