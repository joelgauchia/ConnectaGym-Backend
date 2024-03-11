package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Security.dto.PropietariDto;
import com.example.ConnectaGym.Security.dto.PropietariDto;
import com.example.ConnectaGym.Security.dto.UsuariDto;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Services.PropietarisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/propietaris")
@RestController
public class PropietarisController {

    @Autowired
    PropietarisService propietarisService;

    @GetMapping()
    public List<PropietariDto> getPropietaris() {
        return this.mapToPropietariDto(propietarisService.getPropietaris());
    }

    @GetMapping("/{id}")
    public PropietariDto getPropietariById(@PathVariable("id") Long id) {
        return this.mapToPropietariDto(propietarisService.getPropietariById(id));
    }

    @PostMapping()
    public PropietariDto nouPropietari(@RequestBody Propietari p) {
        return this.mapToPropietariDto(propietarisService.afegirPropietari(p));
    }

    @PutMapping("/{id}")
    public PropietariDto editarPropietari(@RequestBody Propietari p) {
        return this.mapToPropietariDto(propietarisService.editarPropietari(p));
    }

    @DeleteMapping("/{id}")
    public PropietariDto esborrarPropietari(@PathVariable("id") Long id) {
        return this.mapToPropietariDto(propietarisService.esborrarPropietari(id));
    }

    private List<PropietariDto> mapToPropietariDto(List<Propietari> propietaris) {
        List<PropietariDto> propietarisDto = new ArrayList<>();
        for (Propietari propietari : propietaris) {
            PropietariDto propietariDto = new PropietariDto();
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