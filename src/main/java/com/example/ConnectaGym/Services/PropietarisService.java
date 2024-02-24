package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Repositories.PropietarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarisService {

    @Autowired
    private PropietarisRepository propietarisRepository;

    public List<Propietari> getPropietaris() {
        return this.propietarisRepository.findAll();
    }

    public Propietari getPropietariById(Long id) {
        Optional<Propietari> propietariOptional = this.propietarisRepository.findById(id);
        return propietariOptional.orElse(null);
    }

    public Propietari afegirPropietari(Propietari p) {
        return this.propietarisRepository.save(p);
    }

    public Propietari editarPropietari(Propietari p) {
        return this.propietarisRepository.save(p);
    }

    public Propietari esborrarPropietari(Long id) {
        Optional<Propietari> propietariOptional = this.propietarisRepository.findById(id);
        if (propietariOptional.isPresent()) {
            Propietari propietari = propietariOptional.get();
            this.propietarisRepository.deleteById(id);
            return propietari;
        } else {
            return null;
        }
    }
}