package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Llicencia;
import com.example.ConnectaGym.Repositories.LlicenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LlicenciesService {

    @Autowired
    LlicenciesRepository llicenciesRepository;

    public List<Llicencia> getLlicencies() {
        return this.llicenciesRepository.findAll();
    }

    public List<Llicencia> getLlicenciesActives() {
        return this.llicenciesRepository.findByActivaTrue();
    }

    public List<Llicencia> getLlicenciesInactives() {
        return this.llicenciesRepository.findByActivaFalse();
    }

    public Llicencia getLlicenciaById(Long id) {
        Optional<Llicencia> optionalLlicencia = this.llicenciesRepository.findById(id);
        return optionalLlicencia.orElseGet(Llicencia::new);
    }

    public Llicencia afegirLlicencia(Llicencia ll, boolean desactivar) {
        if (ll.getActiva() && llicenciesRepository.existsByPropietariNom(ll.getPropietari().getNom())) {
            throw new RuntimeException("Ja existeix una llicència per aquest propietari.");
        }
        if (ll.getPropietari().getTipus().equals("INDIVIDUAL") && ll.getTipusLlicencia().getTipus().equals("CADENA")) {
            throw new RuntimeException("No pots seleccionar aquest tipus de llicència per aquest propietari.");
        }
        if (ll.getPropietari().getTipus().equals("CADENA") && ll.getTipusLlicencia().getTipus().equals("INDIVIDUAL")) {
            throw new RuntimeException("No pots seleccionar aquest tipus de llicència per aquest propietari.");
        }
        ll.setDataInici(LocalDateTime.now());
        if (!desactivar) {
            if ((Objects.equals(ll.getTipusLlicencia().getDurada(), "Mensual")) || Objects.equals(ll.getTipusLlicencia().getDurada(), "MENSUAL")) ll.setDataVenciment(ll.getDataInici().plusMonths(1));
            if ((Objects.equals(ll.getTipusLlicencia().getDurada(), "Trimestral")) || Objects.equals(ll.getTipusLlicencia().getDurada(), "TRIMESTRAL")) ll.setDataVenciment(ll.getDataInici().plusMonths(3));
            if ((Objects.equals(ll.getTipusLlicencia().getDurada(), "Anual")) || Objects.equals(ll.getTipusLlicencia().getDurada(), "ANUAL")) ll.setDataVenciment(ll.getDataInici().plusMonths(12));
        }
        this.llicenciesRepository.save(ll);
        return ll;
    }

    public void deleteLlicencia(Long id) {
        Optional<Llicencia> optionalLlicencia = this.llicenciesRepository.findById(id);
        if (optionalLlicencia.isPresent()) {
            Llicencia llicencia = optionalLlicencia.get();
            this.llicenciesRepository.deleteById(id);
        }
    }
}
