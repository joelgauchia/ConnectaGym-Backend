package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Pagament;
import com.example.ConnectaGym.Services.PagamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/pagaments")
@RestController
public class PagamentsController {

    @Autowired
    PagamentsService pagamentsService;

    @GetMapping()
    public List<Pagament> getPagaments() {
        return this.pagamentsService.getPagaments();
    }

    @GetMapping("/{id}")
    public Pagament getPagamentById(@PathVariable("id") Long id) {
        return this.pagamentsService.getPagamentById(id);
    }

    @PostMapping()
    public Pagament afegirPagament(@RequestBody Pagament pagament) {
        return this.pagamentsService.afegirPagament(pagament);
    }

    @DeleteMapping("/{id}")
    public Pagament esborrarPagament(@PathVariable("id") Long id) {
        return this.pagamentsService.esborrarPagament(id);
    }
}