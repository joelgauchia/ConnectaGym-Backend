package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Missatge;
import com.example.ConnectaGym.Repositories.MissatgesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissatgesService {

    @Autowired
    private MissatgesRepository missatgesRepository;

    public List<Missatge> getMissatges() {
        return this.missatgesRepository.findAll();
    }

    public Missatge getMissatgeById(Long id) {
        Optional<Missatge> missatgeOptional = this.missatgesRepository.findById(id);
        return missatgeOptional.orElse(null);
    }

    public Missatge afegirMissatge(Missatge missatge) {
        return this.missatgesRepository.save(missatge);
    }

    public Missatge editarMissatge(Missatge missatge) {
        return this.missatgesRepository.save(missatge);
    }

    public Missatge esborrarMissatge(Long id) {
        Optional<Missatge> missatgeOptional = this.missatgesRepository.findById(id);
        if (missatgeOptional.isPresent()) {
            Missatge missatge = missatgeOptional.get();
            this.missatgesRepository.deleteById(id);
            return missatge;
        } else {
            return null;
        }
    }
}