package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Security.dto.GimnasDto;
import com.example.ConnectaGym.Services.GimnasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gimnasos")
public class GimnasosController {

    @Autowired
    GimnasosService gimnasosService;

    @GetMapping("/llistat")
    public List<GimnasDto> getGimnasos() {
        return this.mapToGimnasDto(gimnasosService.getGimnasos());
    }

    @GetMapping(path="/{id}")
    public GimnasDto getGimnasById(@PathVariable("id") Long id) {
        return this.mapToGimnasDto(gimnasosService.getGimnasById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearGimnas(@RequestBody Gimnas g) {
       try {
           Gimnas gimnasCreat = gimnasosService.afegirGimnas(g);
           return ResponseEntity.status(HttpStatus.CREATED).body("Gimnàs creat amb èxit" );
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la creació del gimnàs: " + e.getMessage());
       }
    }

    @PutMapping(path="/{id}")
    public GimnasDto editarGimnas(@PathVariable("id") Long id, @RequestBody Gimnas g) {
        return this.mapToGimnasDto(gimnasosService.editarGimnas(id, g));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteGimnas(@PathVariable("id") Long id) {
        gimnasosService.deleteGimnas(id);
        return ResponseEntity.ok("Gimnàs eliminat correctament");
    }

    private GimnasDto mapToGimnasDto(Gimnas gimnas) {
        GimnasDto gimnasDto = new GimnasDto();
        gimnasDto.setId(gimnas.getId());
        gimnasDto.setNom(gimnas.getNom());
        gimnasDto.setAdreca(gimnas.getAdreca());
        gimnasDto.setTelefon(gimnas.getTelefon());
        gimnasDto.setEmail(gimnas.getEmail());
        gimnasDto.setPropietari(gimnas.getPropietari());
        gimnasDto.setCreador(gimnas.getAdmin());
        gimnasDto.setDataCreacio(gimnas.getDataCreacio());
        gimnasDto.setDataModificacio(gimnas.getDataModificacio());
        return gimnasDto;
    }

    private List<GimnasDto> mapToGimnasDto(List<Gimnas> gimnasos) {
        List<GimnasDto> gimnasosDto = new ArrayList<>();
        for (Gimnas gimnas : gimnasos) {
            GimnasDto gimnasDto = new GimnasDto();
            gimnasDto.setId(gimnas.getId());
            gimnasDto.setNom(gimnas.getNom());
            gimnasDto.setAdreca(gimnas.getAdreca());
            gimnasDto.setTelefon(gimnas.getTelefon());
            gimnasDto.setEmail(gimnas.getEmail());
            gimnasDto.setPropietari(gimnas.getPropietari());
            gimnasDto.setCreador(gimnas.getAdmin());
            gimnasDto.setDataCreacio(gimnas.getDataCreacio());
            gimnasDto.setDataModificacio(gimnas.getDataModificacio());
            gimnasosDto.add(gimnasDto);
        }
        return gimnasosDto;
    }
}