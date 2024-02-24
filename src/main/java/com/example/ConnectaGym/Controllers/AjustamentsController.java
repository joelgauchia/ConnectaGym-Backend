package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Ajustament;
import com.example.ConnectaGym.Services.AjustamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/ajustaments")
@RestController
public class AjustamentsController {

    @Autowired
    AjustamentsService ajustamentsService;

    @GetMapping()
    public List<Ajustament> getAjustaments() {
        return this.ajustamentsService.getAjustaments();
    }

    @GetMapping("/{id}")
    public Ajustament getAjustamentById(@PathVariable("id") Long id) {
        return this.ajustamentsService.getAjustamentById(id);
    }

    @PostMapping()
    public Ajustament afegirAjustament(@RequestBody Ajustament a) {
        return this.ajustamentsService.afegirAjustament(a);
    }

    @PutMapping("/{id}")
    public Ajustament editarAjustament(@RequestBody Ajustament a) {
        return this.ajustamentsService.editarAjustament(a);
    }

    @DeleteMapping("/{id}")
    public Ajustament esborrarAjustament(@PathVariable("id") Long id) {
        return this.ajustamentsService.esborrarAjustament(id);
    }
}