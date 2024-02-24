package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Pagament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentsRepository extends JpaRepository<Pagament, Long> {
}