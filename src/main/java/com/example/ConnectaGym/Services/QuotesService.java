package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Quota;
import com.example.ConnectaGym.Repositories.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuotesService {

    @Autowired
    private QuotesRepository quotesRepository;

    public List<Quota> getQuotes() {
        return this.quotesRepository.findAll();
    }

    public Quota getQuoteById(Long id) {
        Optional<Quota> quotaOptional = this.quotesRepository.findById(id);
        return quotaOptional.orElse(null);
    }

    public Quota afegirQuote(Quota q) {
        return this.quotesRepository.save(q);
    }

    public Quota editarQuote(Quota q) {
        return this.quotesRepository.save(q);
    }

    public Quota esborrarQuote(Long id) {
        Optional<Quota> quotaOptional = this.quotesRepository.findById(id);
        if (quotaOptional.isPresent()) {
            Quota quota = quotaOptional.get();
            this.quotesRepository.deleteById(id);
            return quota;
        } else {
            return null;
        }
    }
}