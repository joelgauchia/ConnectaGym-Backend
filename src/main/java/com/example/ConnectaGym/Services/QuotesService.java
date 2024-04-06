package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Quota;
import com.example.ConnectaGym.Repositories.QuotesRepository;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuotesService {

    @Autowired
    private QuotesRepository quotesRepository;

    @Autowired
    private UsuarisRepository usuarisRepository;

    public List<Quota> getQuotes() {
        return this.quotesRepository.findAll();
    }

    public List<Quota> getQuotesWithActiveCreator() {
        return this.quotesRepository.findAllByCreadorActiu();
    }

    public List<Quota> getQuotesByGimnasNom(String nomGimnas) {
        return quotesRepository.findByGimnas_Nom(nomGimnas);
    }

    public Quota getQuoteById(Long id) {
        Optional<Quota> quotaOptional = this.quotesRepository.findById(id);
        return quotaOptional.orElse(null);
    }

    public Quota afegirQuote(Quota q) {
        if (quotesRepository.existsByNom(q.getNom())) {
            throw new RuntimeException("Ja existeix una quota amb aquest nom");
        }

        String nomUsuariCreador = q.getCreador().getNomUsuari();
        List<Usuari> usuarisCreador = usuarisRepository.findByNomUsuari(nomUsuariCreador);

        if (!usuarisCreador.isEmpty()) {
            Usuari usuariCreador = usuarisCreador.get(0);
            q.setCreador(usuariCreador);
            q.setDataCreacio(LocalDateTime.now());
            q.setDataModificacio(LocalDateTime.now());
            return this.quotesRepository.save(q);
        } else {
            throw new RuntimeException("No s'ha trobat cap usuari creador amb el nom d'usuari proporcionat");
        }
    }

    public Quota editarQuote(Long id, Quota q) {
        Optional<Quota> quotaOptional = quotesRepository.findById(id);
        if (quotaOptional.isPresent()) {
            Quota quota = quotaOptional.get();
            quota.setNom(q.getNom());
            quota.setPreu(q.getPreu());
            quota.setDataModificacio(LocalDateTime.now());
            return quotesRepository.save(quota);
        } else {
            throw new RuntimeException("No s'ha trobat la quota");
        }
    }

    public void esborrarQuote(Long id) {
        try {
            Optional<Quota> quotaOptional = this.quotesRepository.findById(id);
            if (quotaOptional.isPresent()) {
                this.quotesRepository.deleteById(id);
            } else {
                throw new RuntimeException("No s'ha trobat cap quota amb l'id proporcionat");
            }
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es pot esborrar la quota ja que té un pagament actiu.");
        }
    }
}