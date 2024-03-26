package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Repositories.GimnasosRepository;
import com.example.ConnectaGym.Repositories.PropietarisRepository;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GimnasosService {

    @Autowired
    GimnasosRepository gimnasosRepository;

    @Autowired
    UsuarisRepository usuarisRepository;

    @Autowired
    PropietarisRepository propietarisRepository;

    public List<Gimnas> getGimnasos() {
        return this.gimnasosRepository.findAll();
    }

    public Gimnas getGimnasById(Long id) {
        Optional<Gimnas> gimnasosOptional = this.gimnasosRepository.findById(id);
        return gimnasosOptional.orElse(null);
    }

    public Gimnas afegirGimnas(Gimnas g) {
        String nomGimnas = g.getNom();
        String emailGimnas = g.getEmail();
        String telefonGimnas = g.getTelefon();

        if (g.getPropietari().getTipus().equals("INDIVIDUAL")) {
            Optional<Propietari> optPropietari = this.propietarisRepository.findById(g.getPropietari().getId());
            if (optPropietari.isPresent()) {
                Propietari propietari = optPropietari.get();
                if (!propietari.getGimnasos().isEmpty())
                    throw new RuntimeException("El propietari seleccionat ja té un gimnas associat");
            }
        }
        if (gimnasosRepository.existsByNom(nomGimnas)) {
            throw new RuntimeException("Ja existeix un gimnàs amb aquest nom");
        }
        if (gimnasosRepository.existsByEmail(emailGimnas)) {
            throw new RuntimeException("Ja existeix un gimnàs amb aquest e-mail");
        }
        if (gimnasosRepository.existsByTelefon(telefonGimnas)) {
            throw new RuntimeException("Ja existeix un gimnàs amb aquest telèfon");
        }
        String nomUsuariCreador = g.getCreador().getNomUsuari();
        List<Usuari> usuarisCreador = usuarisRepository.findByNomUsuari(nomUsuariCreador);

        if (!usuarisCreador.isEmpty()) {
            Usuari usuariCreador = usuarisCreador.get(0);
            g.setAdmin(usuariCreador);
            g.setDataCreacio(LocalDateTime.now());
            g.setDataModificacio(LocalDateTime.now());

            Gimnas gimnasGuardat = this.gimnasosRepository.save(g);

            Propietari propietari = gimnasGuardat.getPropietari();
            propietari.setGimnas(gimnasGuardat);
            this.propietarisRepository.save(propietari);
            return gimnasGuardat;
        } else {
            throw new RuntimeException("No s'ha trobat cap usuari creador amb el nom d'usuari proporcionat");
        }
    }

    public Gimnas editarGimnas(Long id, Gimnas g) {
        Optional<Gimnas> gimnasos = gimnasosRepository.findById(id);
        if (gimnasos.isPresent()) {
            Gimnas gimnas = gimnasos.get();;
            gimnas.setNom(g.getNom());
            gimnas.setAdreca(g.getAdreca());
            gimnas.setEmail(g.getEmail());
            gimnas.setTelefon(g.getTelefon());
            gimnas.setDataCreacio(g.getDataCreacio());
            gimnas.setDataModificacio(LocalDateTime.now());
            return gimnasosRepository.save(gimnas);
        } else {
            throw new RuntimeException("No s'ha trobat el gimnàs");
        }
    }

    public void deleteGimnas(Long id) {
        try {
            Optional<Gimnas> optionalGimnasos = this.gimnasosRepository.findById(id);
            if (optionalGimnasos.isPresent()) {
                this.gimnasosRepository.deleteById(id);
            } else {
                throw new RuntimeException("No s'ha trobat cap gimnàs amb l'id proporcionat");
            }
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es pot esborrar el gimnàs ja que té quotes o membres associats");
        }
    }
}
