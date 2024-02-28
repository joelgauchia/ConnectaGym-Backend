package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Services.GimnasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasos")
public class GimnasosController {

    @Autowired
    GimnasosService gimnasosService;

    @GetMapping()
    public List<Gimnas> getGimnasos() {
        return this.gimnasosService.getGimnasos();
    }

    @GetMapping(path="/{id}")
    public Gimnas getGimnasById(@PathVariable("id") Long id) {
        return this.gimnasosService.getGimnasById(id);
    }

    @PostMapping()
    public Gimnas afegirGimnas(@RequestBody Gimnas g) {
        return this.gimnasosService.afegirGimnas(g);
    }

    @PutMapping(path="/{id}")
    public Gimnas editarGimnas(@RequestBody Gimnas g) {
        return this.gimnasosService.editarGimnas(g);
    }

    @DeleteMapping(path="/{id}")
    public Gimnas deleteGimnas(@PathVariable("id") Long id) {
        return this.gimnasosService.deleteGimnas(id);
    }
}