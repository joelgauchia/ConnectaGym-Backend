package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.MembreGimnas;
import com.example.ConnectaGym.Repositories.MembresGimnasosRepository;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MembresGimnasosService {

    @Autowired
    private MembresGimnasosRepository membresGimnasosRepository;

    @Autowired
    UsuarisRepository usuarisRepository;

    public List<MembreGimnas> getMembresGimnasos() {
        return this.membresGimnasosRepository.findAll();
    }

    public MembreGimnas getMembreGimnasById(Long id) {
        Optional<MembreGimnas> membreGimnasOptional = this.membresGimnasosRepository.findById(id);
        return membreGimnasOptional.orElse(null);
    }

    public MembreGimnas afegirMembreGimnas(MembreGimnas m) {
        if (membresGimnasosRepository.existsByNom(m.getNom())) {
            throw new RuntimeException("Ja existeix un membre amb aquest nom");
        }
        if (membresGimnasosRepository.existsByEmail(m.getEmail())) {
            throw new RuntimeException("Ja existeix un membre amb aquest e-mail");
        }
        if (membresGimnasosRepository.existsByTelefon(m.getTelefon())) {
            throw new RuntimeException("Ja existeix un membre amb aquest telèfon");
        }

        String nomUsuariCreador = m.getCreador().getNomUsuari();
        List<Usuari> usuarisCreador = usuarisRepository.findByNomUsuari(nomUsuariCreador);

        if (!usuarisCreador.isEmpty()) {
            Usuari usuariCreador = usuarisCreador.get(0);
            m.setCreador(usuariCreador);
            m.setEstat("SENSE");
            m.setDataCreacio(LocalDateTime.now());
            m.setDataModificacio(LocalDateTime.now());
            return this.membresGimnasosRepository.save(m);
        } else {
            throw new RuntimeException("No s'ha trobat cap usuari creador amb el nom d'usuari proporcionat");
        }
    }

    public MembreGimnas editarMembreGimnas(MembreGimnas m) {
        return this.membresGimnasosRepository.save(m);
    }

    public void esborrarMembreGimnas(Long id) {
        Optional<MembreGimnas> membreGimnasOptional = this.membresGimnasosRepository.findById(id);
        if (membreGimnasOptional.isPresent()) {
            MembreGimnas membreGimnas = membreGimnasOptional.get();
            this.membresGimnasosRepository.deleteById(id);
        } else {
            throw new RuntimeException("No s'ha trobat el gimnàs");
        }
    }
}