package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Repositories.GimnasosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GimnasosService {

    @Autowired
    GimnasosRepository gimnasosRepository;

    public List<Gimnas> getGimnasos() {
        return this.gimnasosRepository.findAll();
    }

    public Gimnas getGimnasById(Long id) {
        Optional<Gimnas> gimnasosOptional = this.gimnasosRepository.findById(id);
        return gimnasosOptional.orElse(null);
    }
    public Gimnas afegirGimnas(Gimnas g) {
        return this.gimnasosRepository.save(g);
    }

    public Gimnas editarGimnas(Gimnas g) {
        return this.gimnasosRepository.save(g);
    }

    public Gimnas deleteGimnas(Long id) {
        Optional<Gimnas> optionalGimnasos = this.gimnasosRepository.findById(id);
        if (optionalGimnasos.isPresent()) {
            Gimnas gimnasos = optionalGimnasos.get();
            this.gimnasosRepository.deleteById(id);
            return gimnasos;
        }
        else return null;
    }
}
