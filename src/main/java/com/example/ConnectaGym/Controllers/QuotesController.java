package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Quota;
import com.example.ConnectaGym.Services.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/quotes")
@RestController
public class QuotesController {

    @Autowired
    QuotesService quotesService;

    @GetMapping()
    public List<Quota> getQuotes() {
        return this.quotesService.getQuotes();
    }

    @GetMapping("/{id}")
    public Quota getQuoteById(@PathVariable("id") Long id) {
        return this.quotesService.getQuoteById(id);
    }

    @PostMapping()
    public Quota afegirQuote(@RequestBody Quota q) {
        return this.quotesService.afegirQuote(q);
    }

    @PutMapping("/{id}")
    public Quota editarQuote(@RequestBody Quota q) {
        return this.quotesService.editarQuote(q);
    }

    @DeleteMapping("/{id}")
    public Quota esborrarQuote(@PathVariable("id") Long id) {
        return this.quotesService.esborrarQuote(id);
    }
}