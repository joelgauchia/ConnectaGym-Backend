package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Usuari;
import com.example.ConnectaGym.Services.UsuarisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/usuaris")
@RestController
public class UsuarisController {

    @Autowired
    UsuarisService usuarisService;

    @GetMapping()
    public List<Usuari> getUsuaris() {
        return this.usuarisService.getUsuaris();
    }

    @GetMapping("/{id}")
    public Usuari getUsuariById(@PathVariable("id") Long id) {
        return this.usuarisService.getUsuariById(id);
    }

    @PostMapping()
    public Usuari afegirUsuari(@RequestBody Usuari u) {
        return this.usuarisService.afegirUsuari(u);
    }

    @PutMapping("/{id}")
    public Usuari editarUsuari(@RequestBody Usuari u) {
        return this.usuarisService.editarUsuari(u);
    }

    @DeleteMapping("/{id}")
    public Usuari esborrarUsuari(@PathVariable("id") Long id) {
        return this.usuarisService.esborrarUsuari(id);
    }
}
