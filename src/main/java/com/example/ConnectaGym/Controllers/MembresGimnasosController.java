package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.MembreGimnas;
import com.example.ConnectaGym.Security.dto.MembreDto;
import com.example.ConnectaGym.Services.MembresGimnasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/membres")
@RestController
public class MembresGimnasosController {

    @Autowired
    MembresGimnasosService membresGimnasosService;

    @GetMapping("/llistat")
    public List<MembreDto> getMembresGimnasos() {
        return this.mapToMembreDto(membresGimnasosService.getMembresGimnasos());
    }

    @GetMapping("/llistat-actiu")
    public List<MembreDto> getMembresGimnasosActius() {
        return this.mapToMembreDto(membresGimnasosService.getMembresGimnasosWithActiveCreator());
    }

    @GetMapping("/{id}")
    public MembreDto getMembreGimnasById(@PathVariable("id") Long id) {
        return this.mapToMembreDto(membresGimnasosService.getMembreGimnasById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearMembreGimnas(@RequestBody MembreGimnas m) {
        try {
            MembreGimnas membreGimnasCreat = membresGimnasosService.afegirMembreGimnas(m);
            return ResponseEntity.status(HttpStatus.CREATED).body("Membre creat amb èxit");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la creació del membre: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public MembreDto editarMembreGimnas(@PathVariable("id") Long id, @RequestBody MembreGimnas m) {
        return this.mapToMembreDto(membresGimnasosService.editarMembreGimnas(id, m));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> baixaMembreGimnas(@PathVariable("id") Long id) {
        try {
            membresGimnasosService.esborrarMembreGimnas(id);
            return ResponseEntity.ok("Membre esborrat amb èxit");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private MembreDto mapToMembreDto(MembreGimnas membreGimnas) {
        MembreDto membreDto = new MembreDto();
        membreDto.setId(membreGimnas.getId());
        membreDto.setNom(membreGimnas.getNom());
        membreDto.setEmail(membreGimnas.getEmail());
        membreDto.setTelefon(membreGimnas.getTelefon());
        membreDto.setAdreca(membreGimnas.getAdreca());
        membreDto.setGenere(membreGimnas.getGenere());
        membreDto.setEstat(membreGimnas.getEstat());
        membreDto.setDataNaixement(membreGimnas.getDataNaixement());
        membreDto.setObservacions(membreGimnas.getObservacions());
        membreDto.setGimnas(membreGimnas.getGimnas());
        membreDto.setCreador(membreGimnas.getCreador());
        membreDto.setDataCreacio(membreGimnas.getDataCreacio());
        membreDto.setDataModificacio(membreGimnas.getDataModificacio());
        return membreDto;
    }

    private List<MembreDto> mapToMembreDto(List<MembreGimnas> membresGimnas) {
        List<MembreDto> membresDto = new ArrayList<>();
        for (MembreGimnas membreGimnas : membresGimnas) {
            membresDto.add(mapToMembreDto(membreGimnas));
        }
        return membresDto;
    }
}