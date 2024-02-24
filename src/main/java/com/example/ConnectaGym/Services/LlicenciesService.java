package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Llicencia;
import com.example.ConnectaGym.Repositories.LlicenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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

    public Llicencia afegirLlicencia(Llicencia ll) {
        this.llicenciesRepository.save(ll);
        return ll;
    }

    public Llicencia deleteLlicencia(Long id) {
        Optional<Llicencia> optionalLlicencia = this.llicenciesRepository.findById(id);
        if (optionalLlicencia.isPresent()) {
            Llicencia llicencia = optionalLlicencia.get();
            this.llicenciesRepository.deleteById(id);
            return llicencia;
        } else return null;
    }
}
