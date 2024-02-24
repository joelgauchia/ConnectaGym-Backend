package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.MembreGimnas;
import com.example.ConnectaGym.Services.MembresGimnasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/membres")
@RestController
public class MembresGimnasosController {

    @Autowired
    MembresGimnasosService membresGimnasosService;

    @GetMapping()
    public List<MembreGimnas> getMembresGimnasos() {
        return this.membresGimnasosService.getMembresGimnasos();
    }

    @GetMapping("/{id}")
    public MembreGimnas getMembresGimnasosById(@PathVariable("id") Long id) {
        return this.membresGimnasosService.getMembreGimnasById(id);
    }

    @PostMapping()
    public MembreGimnas nouMembresGimnasos(@RequestBody MembreGimnas m) {
        return this.membresGimnasosService.afegirMembreGimnas(m);
    }

    @PutMapping("/{id}")
    public MembreGimnas editarMembresGimnasos(@RequestBody MembreGimnas m) {
        return this.membresGimnasosService.editarMembreGimnas(m);
    }

    @DeleteMapping("/{id}")
    public MembreGimnas esborrarMembresGimnasos(@PathVariable("id") Long id) {
        return this.membresGimnasosService.esborrarMembreGimnas(id);
    }
}