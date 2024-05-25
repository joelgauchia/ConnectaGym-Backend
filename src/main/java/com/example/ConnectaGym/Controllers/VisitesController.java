package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Visita;
import com.example.ConnectaGym.Security.dto.QuotaDto;
import com.example.ConnectaGym.Security.dto.VisitaDto;
import com.example.ConnectaGym.Services.VisitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/visites")
@RestController
public class VisitesController {

    @Autowired
    VisitesService visitesService;

    @GetMapping("/llistat")
    public List<VisitaDto> getVisites() {
        return this.mapToVisitaDto(visitesService.getVisites());
    }

    @GetMapping("/perGimnas")
    public List<VisitaDto> getVisitesByGimnasNom(@RequestParam("nomGimnas") String nomGimnas) {
        return this.mapToVisitaDto(visitesService.getVisitesByGimnasNom(nomGimnas));
    }

    @GetMapping("/{id}")
    public VisitaDto getVisitaById(@PathVariable("id") Long id) {
        return this.mapToVisitaDto(visitesService.getVisitaById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<String> afegirVisita(@RequestBody Visita visita) {
        try {
            visitesService.afegirVisita(visita);
            return ResponseEntity.status(HttpStatus.CREATED).body("Visita creada amb èxit");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la creació de la visita: " + e.getMessage());
        }
    }

    private List<VisitaDto> mapToVisitaDto(List<Visita> visites) {
        List<VisitaDto> visitesDto = new ArrayList<>();
        for (Visita visita : visites) {
            VisitaDto visitaDto = new VisitaDto();
            visitaDto.setId(visita.getId());
            visitaDto.setMembreGimnas(visita.getMembreGimnas());
            visitaDto.setGimnas(visita.getGimnas());
            visitaDto.setDataVisita(visita.getDataVisita());
            visitaDto.setAbonat(visita.isAbonat());
            visitaDto.setPreu(visita.getPreu());
            visitesDto.add(visitaDto);
        }
        return visitesDto;
    }

    private VisitaDto mapToVisitaDto(Visita visita) {
        VisitaDto visitaDto = new VisitaDto();
        visitaDto.setId(visita.getId());
        visitaDto.setMembreGimnas(visita.getMembreGimnas());
        visitaDto.setGimnas(visita.getGimnas());
        visitaDto.setDataVisita(visita.getDataVisita());
        visitaDto.setAbonat(visita.isAbonat());
        visitaDto.setPreu(visita.getPreu());
        return visitaDto;
    }
}