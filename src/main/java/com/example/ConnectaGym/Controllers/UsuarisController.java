package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Security.dto.UsuariDto;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.service.UsuarisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/usuaris")
@RestController
public class UsuarisController {

    private final static Logger logger = LoggerFactory.getLogger(UsuarisController.class);

    @Autowired
    UsuarisService usuarisService;

    @GetMapping("/llistat")
    public List<UsuariDto> getUsuaris() { return this.mapToUsuariDto(this.usuarisService.getUsuaris()); }

    @GetMapping("/{id}")
    public UsuariDto getUsuariByUsername(@PathVariable("id") String username) {
        try {
            Usuari usuari = this.usuarisService.getByNomUsuari(username);
            return this.mapToUsuariDto(usuari);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/actiu/{id}")
    public UsuariDto getUsuariByUsernameActiu(@PathVariable("id") String username) {
        try {
            Usuari usuari = this.usuarisService.getByNomUsuariActiu(username);
            return this.mapToUsuariDto(usuari);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualitzarUsuari(@PathVariable("id") String nomUsuari, @RequestBody Usuari usuari) {
        try {
            Usuari usuariActualitzat = usuarisService.actualitzarUsuari(nomUsuari, usuari);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuari editat amb èxit");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en l'edició de l'usuari: " + e.getMessage());
        }
    }

    @PostMapping("/crear")
    public UsuariDto crearUsuari(@RequestBody Usuari usuari) {
        Usuari usuariCreat = usuarisService.crearUsuari(usuari);
        return mapToUsuariDto(usuariCreat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuari(@PathVariable("id") String nomUsuari) {
        try {
            usuarisService.eliminarUsuari(nomUsuari);
            return ResponseEntity.ok("Usuari eliminat correctament");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private List<UsuariDto> mapToUsuariDto(List<Usuari> usuaris) {
        List<UsuariDto> usuarisDto = new ArrayList<>();
        for (Usuari usuari : usuaris) {
            UsuariDto usuariDto = new UsuariDto();
            usuariDto.setNomUsuari(usuari.getNomUsuari());
            usuariDto.setNom(usuari.getNom());
            usuariDto.setEmail(usuari.getEmail());
            usuariDto.setActiu(usuari.getActiu());
            usuariDto.setDataCreacio(usuari.getDataCreacio());
            usuariDto.setDataModificacio(usuari.getDataModificacio());
            usuariDto.setRols(usuari.getRols());
            if (usuari.getGimnasStaff() != null) usuariDto.setGimnasStaff(usuari.getGimnasStaff());
            usuarisDto.add(usuariDto);
        }
        return usuarisDto;
    }

    private UsuariDto mapToUsuariDto(Usuari usuari) {
        UsuariDto usuariDto = new UsuariDto();
        usuariDto.setNomUsuari(usuari.getNomUsuari());
        usuariDto.setNom(usuari.getNom());
        usuariDto.setEmail(usuari.getEmail());
        usuariDto.setActiu(usuari.getActiu());
        usuariDto.setDataCreacio(usuari.getDataCreacio());
        usuariDto.setDataModificacio(usuari.getDataModificacio());
        usuariDto.setRols(usuari.getRols());
        if (usuari.getGimnasStaff() != null) usuariDto.setGimnasStaff(usuari.getGimnasStaff());
        return usuariDto;
    }
}
