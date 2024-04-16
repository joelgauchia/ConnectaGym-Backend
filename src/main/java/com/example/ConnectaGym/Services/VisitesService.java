package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Visita;
import com.example.ConnectaGym.Repositories.VisitesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitesService {

    private final static Logger logger = LoggerFactory.getLogger(VisitesService.class);

    @Autowired
    private VisitesRepository visitesRepository;

    public List<Visita> getVisites() {
        return this.visitesRepository.findAll();
    }

    public List<Visita> getVisitesByGimnasNom(String nomGimnas) { return this.visitesRepository.findByGimnas_Nom(nomGimnas); }

    public Visita getVisitaById(Long id) {
        Optional<Visita> visitaOptional = this.visitesRepository.findById(id);
        return visitaOptional.orElse(null);
    }

    public void afegirVisita(Visita visita) {
        this.visitesRepository.save(visita);
    }
}