package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.MembreGimnas;
import com.example.ConnectaGym.Repositories.MembresGimnasosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembresGimnasosService {

    @Autowired
    private MembresGimnasosRepository membresGimnasosRepository;

    public List<MembreGimnas> getMembresGimnasos() {
        return this.membresGimnasosRepository.findAll();
    }

    public MembreGimnas getMembreGimnasById(Long id) {
        Optional<MembreGimnas> membreGimnasOptional = this.membresGimnasosRepository.findById(id);
        return membreGimnasOptional.orElse(null);
    }

    public MembreGimnas afegirMembreGimnas(MembreGimnas m) {
        return this.membresGimnasosRepository.save(m);
    }

    public MembreGimnas editarMembreGimnas(MembreGimnas m) {
        return this.membresGimnasosRepository.save(m);
    }

    public MembreGimnas esborrarMembreGimnas(Long id) {
        Optional<MembreGimnas> membreGimnasOptional = this.membresGimnasosRepository.findById(id);
        if (membreGimnasOptional.isPresent()) {
            MembreGimnas membreGimnas = membreGimnasOptional.get();
            this.membresGimnasosRepository.deleteById(id);
            return membreGimnas;
        } else {
            return null;
        }
    }
}