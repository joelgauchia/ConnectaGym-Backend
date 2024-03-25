package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Entities.TipusLlicencia;
import com.example.ConnectaGym.Security.dto.TipusLlicenciaDto;
import com.example.ConnectaGym.Services.TipusLlicenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/tipusllicencia")
@RestController
public class TipusLlicenciesController {

    @Autowired
    TipusLlicenciesService tipusLlicenciesService;

    @GetMapping("/llistat")
    public List<TipusLlicenciaDto> getTipusLlicencia() {
        return this.mapToTipusLlicenciaDto(tipusLlicenciesService.getTipusLlicencia());
    }

    @GetMapping("/{id}")
    public TipusLlicenciaDto getTipusLlicenciaById(@PathVariable("id") Long id) {
        return this.mapToTipusLlicenciaDto(tipusLlicenciesService.getTipusLlicenciaById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearTipusLlicencia(@RequestBody TipusLlicencia tl) {
        try {
            TipusLlicencia tipusLlicenciaCreat = tipusLlicenciesService.afegirTipusLlicencia(tl);
            return ResponseEntity.status(HttpStatus.CREATED).body("Tipus de llicència creat amb èxit");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la creació del tipus de: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public TipusLlicenciaDto editarTipusLlicencia(@PathVariable("id") Long id, @RequestBody TipusLlicencia tl) {
        return this.mapToTipusLlicenciaDto(tipusLlicenciesService.editarTipusLlicencia(tl));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTipusLlicencia(@PathVariable("id") Long id) {
        tipusLlicenciesService.deleteTipusLlicencia(id);
        return ResponseEntity.ok("Tipus de llicència eliminat correctament");
    }

    private List<TipusLlicenciaDto> mapToTipusLlicenciaDto(List<TipusLlicencia> tipusLlicencia) {
        List<TipusLlicenciaDto> llistaTipusLlicenciaDto = new ArrayList<>();
        for (TipusLlicencia tl : tipusLlicencia) {
            TipusLlicenciaDto tipusLlicenciaDto = new TipusLlicenciaDto();
            tipusLlicenciaDto.setId(tl.getId());
            tipusLlicenciaDto.setNom(tl.getNom());
            tipusLlicenciaDto.setPreu(tl.getPreu());
            tipusLlicenciaDto.setDurada(tl.getDurada());
            tipusLlicenciaDto.setMesos(tl.getMesos());
            tipusLlicenciaDto.setTipus(tl.getTipus());
            tipusLlicenciaDto.setCreador(tl.getCreador());
            tipusLlicenciaDto.setDataCreacio(tl.getDataCreacio());
            tipusLlicenciaDto.setDataModificacio(tl.getDataModificacio());
            llistaTipusLlicenciaDto.add(tipusLlicenciaDto);
        }
        return llistaTipusLlicenciaDto;
    }

    private TipusLlicenciaDto mapToTipusLlicenciaDto(TipusLlicencia tl) {
        TipusLlicenciaDto tipusLlicenciaDto = new TipusLlicenciaDto();
        tipusLlicenciaDto.setId(tl.getId());
        tipusLlicenciaDto.setNom(tl.getNom());
        tipusLlicenciaDto.setPreu(tl.getPreu());
        tipusLlicenciaDto.setDurada(tl.getDurada());
        tipusLlicenciaDto.setMesos(tl.getMesos());
        tipusLlicenciaDto.setTipus(tl.getTipus());
        tipusLlicenciaDto.setCreador(tl.getCreador());
        tipusLlicenciaDto.setDataCreacio(tl.getDataCreacio());
        tipusLlicenciaDto.setDataModificacio(tl.getDataModificacio());
        return tipusLlicenciaDto;
    }
}
