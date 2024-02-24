package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Visita;
import com.example.ConnectaGym.Services.VisitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/visites")
@RestController
public class VisitesController {

    @Autowired
    VisitesService visitesService;

    @GetMapping()
    public List<Visita> getVisites() {
        return this.visitesService.getVisites();
    }

    @GetMapping("/{id}")
    public Visita getVisitaById(@PathVariable("id") Long id) {
        return this.visitesService.getVisitaById(id);
    }

    @PostMapping()
    public Visita afegirVisita(@RequestBody Visita visita) {
        return this.visitesService.afegirVisita(visita);
    }

    @PutMapping("/{id}")
    public Visita editarVisita(@RequestBody Visita visita) {
        return this.visitesService.editarVisita(visita);
    }

    @DeleteMapping("/{id}")
    public Visita esborrarVisita(@PathVariable("id") Long id) {
        return this.visitesService.esborrarVisita(id);
    }
}