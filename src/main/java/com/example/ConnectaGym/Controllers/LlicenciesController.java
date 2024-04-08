package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Llicencia;
import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Security.dto.LlicenciaDto;
import com.example.ConnectaGym.Services.LlicenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/llicencies")
@RestController
public class LlicenciesController {

    @Autowired
    LlicenciesService llicenciesService;

    @GetMapping("/llistat")
    public List<LlicenciaDto> getLlicencies() {
        return this.mapToDto(llicenciesService.getLlicencies());
    }

    @GetMapping("/{id}")
    public LlicenciaDto getLlicenciaById(@PathVariable("id") Long id) {
        return this.mapToDto(llicenciesService.getLlicenciaById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearLlicencia(@RequestBody Llicencia ll) {
        try {
            Llicencia llicenciaCreada = llicenciesService.afegirLlicencia(ll, false);
            return ResponseEntity.status(HttpStatus.CREATED).body("LLicència creada amb èxit");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la creació de la llicència: " + e.getMessage());
        }
    }

    @PutMapping("/desactivar")
    public ResponseEntity<String> desactivarLlicencia(@RequestParam Long id) {
        try {
            Llicencia llicencia = llicenciesService.getLlicenciaById(id);
            if (llicencia == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No s'ha trobat cap llicència amb l'id especificat");
            }
            llicencia.setActiva(false);
            llicenciesService.afegirLlicencia(llicencia, true);
            return ResponseEntity.ok("Llicència desactivada amb èxit");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la desactivació de la llicència: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> esborraLlicencia(@PathVariable("id") Long id) {
        llicenciesService.deleteLlicencia(id);
        return ResponseEntity.ok("LLicència eliminada correctament");
    }

    private LlicenciaDto mapToDto(Llicencia llicencia) {
        LlicenciaDto llicenciaDto = new LlicenciaDto();
        llicenciaDto.setId(llicencia.getId());
        llicenciaDto.setPropietari(llicencia.getPropietari());
        llicenciaDto.setTipusLlicencia(llicencia.getTipusLlicencia());
        llicenciaDto.setPreu(llicencia.getPreu());
        llicenciaDto.setActiva(llicencia.getActiva());
        llicenciaDto.setDataInici(llicencia.getDataInici());
        llicenciaDto.setDataVenciment(llicencia.getDataVenciment());
        return llicenciaDto;
    }

    private List<LlicenciaDto> mapToDto(List<Llicencia> llicencies) {
        List<LlicenciaDto> llicenciesDto = new ArrayList<>();
        for (Llicencia llicencia : llicencies) {
            LlicenciaDto llicenciaDto = new LlicenciaDto();
            llicenciaDto.setId(llicencia.getId());
            llicenciaDto.setPropietari(llicencia.getPropietari());
            llicenciaDto.setTipusLlicencia(llicencia.getTipusLlicencia());
            llicenciaDto.setPreu(llicencia.getPreu());
            llicenciaDto.setActiva(llicencia.getActiva());
            llicenciaDto.setDataInici(llicencia.getDataInici());
            llicenciaDto.setDataVenciment(llicencia.getDataVenciment());
            llicenciesDto.add(llicenciaDto);
        }
        return llicenciesDto;
    }
}
