package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Repositories.PropietarisRepository;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PropietarisService {

    @Autowired
    private PropietarisRepository propietarisRepository;

    @Autowired
    private UsuarisRepository usuarisRepository;

    public List<Propietari> getPropietaris() {
        return this.propietarisRepository.findAll();
    }

    public Propietari getPropietariById(Long id) {
        Optional<Propietari> propietariOptional = this.propietarisRepository.findById(id);
        return propietariOptional.orElse(null);
    }

    public Propietari afegirPropietari(Propietari p) {
        String emailPropietari = p.getEmail();

        if (propietarisRepository.existsByEmail(emailPropietari)) {
            throw new RuntimeException("Ja existeix un propietari amb aquest correu electrònic");
        }

        String nomUsuariCreador = p.getCreador().getNomUsuari();
        List<Usuari> usuarisCreador = usuarisRepository.findByNomUsuari(nomUsuariCreador);

        if (!usuarisCreador.isEmpty()) {
            Usuari usuariCreador = usuarisCreador.get(0);
            p.setCreador(usuariCreador);
            p.setDataCreacio(LocalDateTime.now());
            p.setDataModificacio(LocalDateTime.now());
            return this.propietarisRepository.save(p);
        } else {
            throw new RuntimeException("No s'ha trobat cap usuari creador amb el nom d'usuari proporcionat");
        }
    }

    public Propietari editarPropietari(Long id, Propietari p) {
        Optional<Propietari> propietaris = propietarisRepository.findById(id);
        if (propietaris.isPresent()) {
            Propietari propietari = propietaris.get();;
            propietari.setNom(p.getNom());
            propietari.setEmail(p.getEmail());
            propietari.setTelefon(p.getTelefon());
            propietari.setAdreca(p.getAdreca());
            propietari.setTipus(p.getTipus());
            propietari.setDataNaixement(p.getDataNaixement());
            propietari.setGenere(p.getGenere());
            propietari.setDataCreacio(p.getDataCreacio());
            propietari.setDataModificacio(LocalDateTime.now());
            return propietarisRepository.save(propietari);
        } else {
            throw new RuntimeException("No s'ha trobat el propietari");
        }
    }

    public void esborrarPropietari(Long id) {
        Optional<Propietari> propietariOptional = this.propietarisRepository.findById(id);
        if (propietariOptional.isPresent()) {
            Propietari propietari = propietariOptional.get();
            this.propietarisRepository.deleteById(id);
        } else {
            throw new RuntimeException("No s'ha trobat cap propietari amb l'id proporcionat");
        }
    }
}