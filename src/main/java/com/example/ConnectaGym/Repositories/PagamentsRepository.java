package com.example.ConnectaGym.Repositories;

import com.example.ConnectaGym.Entities.Pagament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PagamentsRepository extends JpaRepository<Pagament, Long> {
    List<Pagament> findByGimnasId(Long gimnasId);
    boolean existsByMembreIdAndDataFinalAfter(Long membreId, LocalDateTime dataFinal);
    Optional<Pagament> findByMembreIdAndDataFinalAfter(Long membreId, LocalDateTime dataFinal);
    List<Pagament> findByMembreIdAndDataFinalBefore(Long membreId, LocalDateTime dataFinal);
}