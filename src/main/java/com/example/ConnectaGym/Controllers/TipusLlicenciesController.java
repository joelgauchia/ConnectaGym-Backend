package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.TipusLlicencia;
import com.example.ConnectaGym.Services.TipusLlicenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path="/tipusllicencia")
@RestController
public class TipusLlicenciesController {

    @Autowired
    TipusLlicenciesService tipusLlicenciesService;

    @GetMapping("/llistat")
    public List<TipusLlicencia> getTipusLlicencia() {
        return this.tipusLlicenciesService.getTipusLlicencia();
    }

    @GetMapping("/{id}")
    public TipusLlicencia getTipusLlicenciaById(@PathVariable("id") Long id) {
        return this.tipusLlicenciesService.getTipusLlicenciaById(id);
    }

    @PostMapping()
    public TipusLlicencia novaTipusLlicencia(@RequestBody TipusLlicencia tl) {
        return this.tipusLlicenciesService.afegirTipusLlicencia(tl);
    }

    @PutMapping("/{id}")
    public TipusLlicencia editarTipusLlicencia(@RequestBody TipusLlicencia tl) {
        return this.tipusLlicenciesService.editarTipusLlicencia(tl);
    }

    @DeleteMapping("/{id}")
    public TipusLlicencia deleteTipusLlicencia(@PathVariable("id") Long id) {
        return this.tipusLlicenciesService.deleteTipusLlicencia(id);
    }
}
