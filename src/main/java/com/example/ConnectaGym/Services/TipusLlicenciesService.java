package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.TipusLlicencia;
import com.example.ConnectaGym.Repositories.TipusLlicenciesRepository;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public TipusLlicencia getTipusLlicenciaById(Long id) {
        Optional<TipusLlicencia> optionalTipusLlicencia = this.tipusLlicenciesRepository.findById(id);
        return optionalTipusLlicencia.orElseGet(TipusLlicencia::new);
    }

    public TipusLlicencia afegirTipusLlicencia(TipusLlicencia tl) {

        if(tipusLlicenciesRepository.existsByNom(tl.getNom())) {
            throw new RuntimeException("Ja existeix un tipus de llicència amb aquest nom");
        }

        String nomUsuariCreador = tl.getCreador().getNomUsuari();

        List<Usuari> usuarisCreador = usuarisRepository.findByNomUsuari(nomUsuariCreador);

        if (!usuarisCreador.isEmpty()) {
            Usuari usuariCreador = usuarisCreador.get(0);
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
            tipusLlicencia.setTipus(tl.getTipus());
            tipusLlicencia.setMesos(tl.getMesos());
            tipusLlicencia.setDataCreacio(tl.getDataCreacio());
            tipusLlicencia.setDataModificacio(LocalDateTime.now());
            this.tipusLlicenciesRepository.save(tipusLlicencia);
            return tl;
        } else throw new RuntimeException("No s'ha trobat el tipus de llicència");
    }

    public TipusLlicencia deleteTipusLlicencia(Long id) {
        Optional<TipusLlicencia> optionalTipusLlicencia = this.tipusLlicenciesRepository.findById(id);
        if (optionalTipusLlicencia.isPresent()) {
            TipusLlicencia tipusLlicencia = optionalTipusLlicencia.get();
            this.tipusLlicenciesRepository.deleteById(id);
            return tipusLlicencia;
        } else return null;
    }
}