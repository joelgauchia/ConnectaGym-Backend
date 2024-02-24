package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Visita;
import com.example.ConnectaGym.Repositories.VisitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitesService {

    @Autowired
    private VisitesRepository visitesRepository;

    public List<Visita> getVisites() {
        return this.visitesRepository.findAll();
    }

    public Visita getVisitaById(Long id) {
        Optional<Visita> visitaOptional = this.visitesRepository.findById(id);
        return visitaOptional.orElse(null);
    }

    public Visita afegirVisita(Visita visita) {
        return this.visitesRepository.save(visita);
    }

    public Visita editarVisita(Visita visita) {
        return this.visitesRepository.save(visita);
    }

    public Visita esborrarVisita(Long id) {
        Optional<Visita> visitaOptional = this.visitesRepository.findById(id);
        if (visitaOptional.isPresent()) {
            Visita visita = visitaOptional.get();
            this.visitesRepository.deleteById(id);
            return visita;
        } else {
            return null;
        }
    }
}