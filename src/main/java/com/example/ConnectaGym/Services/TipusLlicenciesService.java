package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.TipusLlicencia;
import com.example.ConnectaGym.Repositories.TipusLlicenciesRepository;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TipusLlicenciesService {

    @Autowired
    private TipusLlicenciesRepository tipusLlicenciesRepository;

    @Autowired
    private UsuarisRepository usuarisRepository;

    public List<TipusLlicencia> getTipusLlicencia() {
        return this.tipusLlicenciesRepository.findAll();
    }

    public List<TipusLlicencia> getTipusLlicenciaAmbCreadorActiu() {
        return this.tipusLlicenciesRepository.findAllByCreadorActiu();
    }

    public TipusLlicencia getTipusLlicenciaById(Long id) {
        Optional<TipusLlicencia> optionalTipusLlicencia = this.tipusLlicenciesRepository.findById(id);
        return optionalTipusLlicencia.orElseGet(TipusLlicencia::new);
    }

    public TipusLlicencia afegirTipusLlicencia(TipusLlicencia tl) {

        if(tipusLlicenciesRepository.existsByNom(tl.getNom())) {
            throw new RuntimeException("Ja existeix un tipus de llicència amb aquest nom");
        }

        String nomUsuariCreador = tl.getCreador().getNomUsuari();

        Usuari usuariCreador = usuarisRepository.findByNomUsuari(nomUsuariCreador);

        if (usuariCreador != null) {
            tl.setCreador(usuariCreador);
            tl.setDataCreacio(LocalDateTime.now());
            tl.setDataModificacio(LocalDateTime.now());
            return this.tipusLlicenciesRepository.save(tl);
        } else {
            throw new RuntimeException("No s'ha trobat cap usuari creador amb el nom d'usuari proporcionat");
        }
    }

    public TipusLlicencia editarTipusLlicencia(TipusLlicencia tl) {
        Optional<TipusLlicencia> optionalTipusLlicencia = this.tipusLlicenciesRepository.findById(tl.getId());
        if (optionalTipusLlicencia.isPresent()) {
            TipusLlicencia tipusLlicencia = optionalTipusLlicencia.get();
            tipusLlicencia.setNom(tl.getNom());
            tipusLlicencia.setPreu(tl.getPreu());
            tipusLlicencia.setDurada(tl.getDurada());
            tipusLlicencia.setMesos(tl.getMesos());
            tipusLlicencia.setTipus(tl.getTipus());
            tipusLlicencia.setDataCreacio(tl.getDataCreacio());
            tipusLlicencia.setDataModificacio(LocalDateTime.now());
            this.tipusLlicenciesRepository.save(tipusLlicencia);
            return tl;
        } else throw new RuntimeException("No s'ha trobat el tipus de llicència");
    }

    public void deleteTipusLlicencia(Long id) {
        try {
            Optional<TipusLlicencia> optionalTipusLlicencia = this.tipusLlicenciesRepository.findById(id);
            if (optionalTipusLlicencia.isPresent()) {
                this.tipusLlicenciesRepository.deleteById(id);
            } else {
                throw new RuntimeException("No s'ha trobat cap tipus de llicència amb l'id proporcionat");
            }
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es pot esborrar el tipus de llicència ja que hi ha una llicència activa amb aquest");
        }
    }
}