package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Security.dto.PropietariDto;
import com.example.ConnectaGym.Services.PropietarisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/propietaris")
@RestController
public class PropietarisController {

    @Autowired
    PropietarisService propietarisService;

    @GetMapping("/llistat")
    public List<PropietariDto> getPropietaris() {
        return this.mapToPropietariDto(propietarisService.getPropietaris());
    }

    @GetMapping("/{id}")
    public PropietariDto getPropietariById(@PathVariable("id") Long id) {
        return this.mapToPropietariDto(propietarisService.getPropietariById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPropietari(@RequestBody Propietari propietari) {
        try {
            Propietari propietariCreado = propietarisService.afegirPropietari(propietari);
            return ResponseEntity.status(HttpStatus.CREATED).body("Propietari creat amb èxit amb ID: " + propietariCreado.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la creació del propietari: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public PropietariDto editarPropietari(@PathVariable("id") Long id, @RequestBody Propietari p) {
        return this.mapToPropietariDto(propietarisService.editarPropietari(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> esborrarPropietari(@PathVariable("id") Long id) {
        propietarisService.esborrarPropietari(id);
        return ResponseEntity.ok("Propietari eliminat correctament");
    }

    private List<PropietariDto> mapToPropietariDto(List<Propietari> propietaris) {
        List<PropietariDto> propietarisDto = new ArrayList<>();
        for (Propietari propietari : propietaris) {
            PropietariDto propietariDto = new PropietariDto();
            propietariDto.setId(propietari.getId());
            propietariDto.setNom(propietari.getNom());
            propietariDto.setEmail(propietari.getEmail());
            propietariDto.setTelefon(propietari.getTelefon());
            propietariDto.setAdreca(propietari.getAdreca());
            propietariDto.setDataNaixement(propietari.getDataNaixement());
            propietariDto.setGenere(propietari.getGenere());
            propietariDto.setTipus(propietari.getTipus());
            propietariDto.setCreador(propietari.getCreador());
            propietariDto.setDataCreacio(propietari.getDataCreacio());
            propietariDto.setDataModificacio(propietari.getDataModificacio());
            propietarisDto.add(propietariDto);
        }
        return propietarisDto;
    }

    private PropietariDto mapToPropietariDto(Propietari propietari) {
        PropietariDto propietariDto = new PropietariDto();
        propietariDto.setId(propietari.getId());
        propietariDto.setNom(propietari.getNom());
        propietariDto.setEmail(propietari.getEmail());
        propietariDto.setTelefon(propietari.getTelefon());
        propietariDto.setAdreca(propietari.getAdreca());
        propietariDto.setDataNaixement(propietari.getDataNaixement());
        propietariDto.setGenere(propietari.getGenere());
        propietariDto.setTipus(propietari.getTipus());
        propietariDto.setCreador(propietari.getCreador());
        propietariDto.setDataCreacio(propietari.getDataCreacio());
        propietariDto.setDataModificacio(propietari.getDataModificacio());
        return propietariDto;
    }
}