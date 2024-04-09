package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.MembreGimnas;
import com.example.ConnectaGym.Entities.Pagament;
import com.example.ConnectaGym.Repositories.PagamentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentsService {

    private final static Logger logger = LoggerFactory.getLogger(PagamentsService.class);

    @Autowired
    private PagamentsRepository pagamentsRepository;

    public List<Pagament> getPagaments() {
        return this.pagamentsRepository.findAll();
    }

    public List<Pagament> getPagamentsFromGimnas(Long gimnasId) {
        return pagamentsRepository.findByGimnasId(gimnasId);
    }

    public List<Pagament> getPagamentsInactiusByMembreId(Long membreId) {
        return pagamentsRepository.findByMembreIdAndDataFinalBefore(membreId, LocalDateTime.now());
    }

    public Pagament getPagamentByMembreId(Long membreId) {
        Optional<Pagament> pagamentOptional = pagamentsRepository.findByMembreIdAndDataFinalAfter(membreId, LocalDateTime.now());
        return pagamentOptional.orElse(null);
    }

    public Pagament afegirPagament(Pagament p) {
        boolean pagamentVigent = existeixPagamentVigentPerMembre(p.getMembre().getId());
        if (pagamentVigent) {
            throw new RuntimeException("Ja existeix un pagament per aquest membre");
        }
        logger.info(p.getDataInici() + " " + p.getDataFinal());
        return this.pagamentsRepository.save(p);
    }

    public Pagament editarPagament(Long id, Pagament p) {
        Optional<Pagament> pagamentOptional = pagamentsRepository.findById(id);
        if (pagamentOptional.isPresent()) {
            Pagament pagament = pagamentOptional.get();
            pagament.setMembre(p.getMembre());
            pagament.setQuota(p.getQuota());
            pagament.setQuantitat(p.getQuantitat());
            pagament.setDataInici(p.getDataInici());
            pagament.setDataFinal(p.getDataFinal());
            pagament.setGimnas(p.getGimnas());
            return pagamentsRepository.save(pagament);
        } else {
            throw new RuntimeException("No s'ha trobat el pagament");
        }
    }

    public void esborrarPagament(Long id) {
        try {
            Optional<Pagament> pagamentOptional = this.pagamentsRepository.findById(id);
            if (pagamentOptional.isPresent()) {
                this.pagamentsRepository.deleteById(id);
            } else {
                throw new RuntimeException("No s'ha trobat cap pagament amb l'id proporcionat");
            }
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es pot esborrar el pagament ja que té una relació activa.");
        }
    }

    private boolean existeixPagamentVigentPerMembre(Long membreId) {
        return pagamentsRepository.existsByMembreIdAndDataFinalAfter(membreId, LocalDateTime.now());
    }
}