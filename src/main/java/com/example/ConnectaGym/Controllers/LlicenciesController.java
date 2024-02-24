package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Llicencia;
import com.example.ConnectaGym.Services.LlicenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/llicencies")
@RestController
public class LlicenciesController {

    @Autowired
    LlicenciesService llicenciesService;

    @GetMapping()
    public List<Llicencia> getLlicencies() {
        return this.llicenciesService.getLlicencies();
    }

    @GetMapping("/actives")
    public List<Llicencia> getLlicenciesActives() {
        return this.llicenciesService.getLlicenciesActives();
    }

    @GetMapping("/inactives")
    public List<Llicencia> getLlicenciesInactives() {
        return this.llicenciesService.getLlicenciesInactives();
    }

    @GetMapping("/{id}")
    public Llicencia getLlicenciaById(@PathVariable("id") Long id) {
        return this.llicenciesService.getLlicenciaById(id);
    }

    @PostMapping()
    public Llicencia novaLlicencia(@RequestBody Llicencia ll) {
        return this.llicenciesService.afegirLlicencia(ll);
    }

    @DeleteMapping()
    public Llicencia deleteLlicencia(@PathVariable("id") Long id) {
        return this.llicenciesService.deleteLlicencia(id);
    }
}
