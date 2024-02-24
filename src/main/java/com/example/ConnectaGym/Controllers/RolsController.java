package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Rol;
import com.example.ConnectaGym.Services.RolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/rols")
@RestController
public class RolsController {

    @Autowired
    RolsService rolsService;

    @GetMapping()
    public List<Rol> getRols() {
        return this.rolsService.getRols();
    }

    @GetMapping("/{id}")
    public Rol getRolById(@PathVariable("id") Long id) {
        return this.rolsService.getRolById(id);
    }

    @PostMapping()
    public Rol afegirRol(@RequestBody Rol r) {
        return this.rolsService.afegirRol(r);
    }

    @PutMapping("/{id}")
    public Rol editarRol(@RequestBody Rol r) {
        return this.rolsService.editarRol(r);
    }

    @DeleteMapping("/{id}")
    public Rol esborrarRol(@PathVariable("id") Long id) {
        return this.rolsService.esborrarRol(id);
    }
}