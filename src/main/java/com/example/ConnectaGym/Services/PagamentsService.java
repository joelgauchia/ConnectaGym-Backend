package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Pagament;
import com.example.ConnectaGym.Repositories.PagamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentsService {

    @Autowired
    private PagamentsRepository pagamentsRepository;

    public List<Pagament> getPagaments() {
        return this.pagamentsRepository.findAll();
    }

    public Pagament getPagamentById(Long id) {
        Optional<Pagament> pagamentOptional = this.pagamentsRepository.findById(id);
        return pagamentOptional.orElse(null);
    }

    public Pagament afegirPagament(Pagament pagament) {
        return this.pagamentsRepository.save(pagament);
    }

    public Pagament esborrarPagament(Long id) {
        Optional<Pagament> pagamentOptional = this.pagamentsRepository.findById(id);
        if (pagamentOptional.isPresent()) {
            Pagament pagament = pagamentOptional.get();
            this.pagamentsRepository.deleteById(id);
            return pagament;
        } else {
            return null;
        }
    }
}