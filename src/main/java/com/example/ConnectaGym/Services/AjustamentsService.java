package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Ajustament;
import com.example.ConnectaGym.Repositories.AjustamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AjustamentsService {

    @Autowired
    private AjustamentsRepository ajustamentsRepository;

    public List<Ajustament> getAjustaments() {
        return this.ajustamentsRepository.findAll();
    }

    public Ajustament getAjustamentById(Long id) {
        Optional<Ajustament> ajustamentOptional = this.ajustamentsRepository.findById(id);
        return ajustamentOptional.orElse(null);
    }

    public Ajustament afegirAjustament(Ajustament a) {
        return this.ajustamentsRepository.save(a);
    }

    public Ajustament editarAjustament(Ajustament a) {
        return this.ajustamentsRepository.save(a);
    }

    public Ajustament esborrarAjustament(Long id) {
        Optional<Ajustament> ajustamentOptional = this.ajustamentsRepository.findById(id);
        if (ajustamentOptional.isPresent()) {
            Ajustament ajustament = ajustamentOptional.get();
            this.ajustamentsRepository.deleteById(id);
            return ajustament;
        } else {
            return null;
        }
    }
}