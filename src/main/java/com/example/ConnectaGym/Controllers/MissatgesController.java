package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Missatge;
import com.example.ConnectaGym.Services.MissatgesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/missatges")
@RestController
public class MissatgesController {

    @Autowired
    MissatgesService missatgesService;

    @GetMapping()
    public List<Missatge> getMissatges() {
        return this.missatgesService.getMissatges();
    }

    @GetMapping("/{id}")
    public Missatge getMissatgeById(@PathVariable("id") Long id) {
        return this.missatgesService.getMissatgeById(id);
    }

    @PostMapping()
    public Missatge afegirMissatge(@RequestBody Missatge missatge) {
        return this.missatgesService.afegirMissatge(missatge);
    }

    @PutMapping("/{id}")
    public Missatge editarMissatge(@RequestBody Missatge missatge) {
        return this.missatgesService.editarMissatge(missatge);
    }

    @DeleteMapping("/{id}")
    public Missatge esborrarMissatge(@PathVariable("id") Long id) {
        return this.missatgesService.esborrarMissatge(id);
    }
}