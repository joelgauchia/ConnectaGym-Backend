package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.TipusLlicencia;
import com.example.ConnectaGym.Repositories.TipusLlicenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipusLlicenciesService {

    @Autowired
    private TipusLlicenciesRepository tipusLlicenciesRepository;

    public List<TipusLlicencia> getTipusLlicencia() {
        return this.tipusLlicenciesRepository.findAll();
    }

    public TipusLlicencia getTipusLlicenciaById(Long id) {
        Optional<TipusLlicencia> optionalTipusLlicencia = this.tipusLlicenciesRepository.findById(id);
        return optionalTipusLlicencia.orElseGet(TipusLlicencia::new);
    }

    public TipusLlicencia afegirTipusLlicencia(TipusLlicencia tl) {
        this.tipusLlicenciesRepository.save(tl);
        return tl;
    }

    public TipusLlicencia editarTipusLlicencia(TipusLlicencia tl) {
        Optional<TipusLlicencia> optionalTipusLlicencia = this.tipusLlicenciesRepository.findById(tl.getId());
        if (optionalTipusLlicencia.isPresent()) {
            this.tipusLlicenciesRepository.save(tl);
            return tl;
        } else return null;
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