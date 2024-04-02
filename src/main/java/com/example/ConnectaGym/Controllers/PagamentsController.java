package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Pagament;
import com.example.ConnectaGym.Security.dto.PagamentDto;
import com.example.ConnectaGym.Services.PagamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/pagaments")
@RestController
public class PagamentsController {

    @Autowired
    PagamentsService pagamentsService;

    @GetMapping("/llistat")
    public List<PagamentDto> getPagaments() {
        return this.mapToPagamentDto(pagamentsService.getPagaments());
    }

    @GetMapping("/{id}")
    public List<Pagament> getPagamentsInactiusByMembreId(@PathVariable("id") Long id) {
        return this.pagamentsService.getPagamentsInactiusByMembreId(id);
    }

    @GetMapping("/pagament/{membreId}")
    public Pagament getPagamentByMembreId(@PathVariable Long membreId) {
        return pagamentsService.getPagamentByMembreId(membreId);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> afegirPagament(@RequestBody Pagament p) {
        try {
            Pagament pagament = pagamentsService.afegirPagament(p);
            return ResponseEntity.status(HttpStatus.CREATED).body("Pagament creat amb èxit");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la creació del pagament: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public PagamentDto editarPagament(@PathVariable("id") Long id, @RequestBody Pagament p) {
        return this.mapToPagamentDto(pagamentsService.editarPagament(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> esborrarPagament(@PathVariable("id") Long id) {
        try {
            pagamentsService.esborrarPagament(id);
            return ResponseEntity.ok("Pagament esborrat amb èxit");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private PagamentDto mapToPagamentDto(Pagament pagament) {
        PagamentDto pagamentDto = new PagamentDto();
        pagamentDto.setId(pagament.getId());
        pagamentDto.setMembre(pagament.getMembre());
        pagamentDto.setQuota(pagament.getQuota());
        pagamentDto.setQuantitat(pagament.getQuantitat());
        pagamentDto.setDataInici(pagament.getDataInici());
        pagamentDto.setDataFinal(pagament.getDataFinal());
        pagamentDto.setGimnas(pagament.getGimnas());
        return pagamentDto;
    }

    private List<PagamentDto> mapToPagamentDto(List<Pagament> pagaments) {
        List<PagamentDto> pagamentsDto = new ArrayList<>();
        for (Pagament pagament : pagaments) {
            pagamentsDto.add(mapToPagamentDto(pagament));
        }
        return pagamentsDto;
    }
}