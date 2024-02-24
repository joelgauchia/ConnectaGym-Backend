package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Services.PropietarisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/propietaris")
@RestController
public class PropietarisController {

    @Autowired
    PropietarisService propietarisService;

    @GetMapping()
    public List<Propietari> getPropietaris() {
        return this.propietarisService.getPropietaris();
    }

    @GetMapping("/{id}")
    public Propietari getPropietariById(@PathVariable("id") Long id) {
        return this.propietarisService.getPropietariById(id);
    }

    @PostMapping()
    public Propietari nouPropietari(@RequestBody Propietari p) {
        return this.propietarisService.afegirPropietari(p);
    }

    @PutMapping("/{id}")
    public Propietari editarPropietari(@RequestBody Propietari p) {
        return this.propietarisService.editarPropietari(p);
    }

    @DeleteMapping("/{id}")
    public Propietari esborrarPropietari(@PathVariable("id") Long id) {
        return this.propietarisService.esborrarPropietari(id);
    }
}