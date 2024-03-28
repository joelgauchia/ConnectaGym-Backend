package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Pagament;
import com.example.ConnectaGym.Repositories.PagamentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

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

    public Pagament getPagamentById(Long id) {
        Optional<Pagament> pagamentOptional = this.pagamentsRepository.findById(id);
        return pagamentOptional.orElse(null);
    }

    public Pagament afegirPagament(Pagament p) {
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
}