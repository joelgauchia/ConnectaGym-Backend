package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Quota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotesRepository extends JpaRepository<Quota, Long> {
}