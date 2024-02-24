package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Usuari;
import com.example.ConnectaGym.Repositories.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarisService {

    @Autowired
    private UsuarisRepository usuarisRepository;

    public List<Usuari> getUsuaris() {
        return this.usuarisRepository.findAll();
    }

    public Usuari getUsuariById(Long id) {
        Optional<Usuari> usuariOptional = this.usuarisRepository.findById(id);
        return usuariOptional.orElse(null);
    }

    public Usuari afegirUsuari(Usuari u) {
        return this.usuarisRepository.save(u);
    }

    public Usuari editarUsuari(Usuari u) {
        return this.usuarisRepository.save(u);
    }

    public Usuari esborrarUsuari(Long id) {
        Optional<Usuari> usuariOptional = this.usuarisRepository.findById(id);
        if (usuariOptional.isPresent()) {
            Usuari usuari = usuariOptional.get();
            this.usuarisRepository.deleteById(id);
            return usuari;
        } else {
            return null;
        }
    }
}