package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Security.dto.UsuariDto;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.service.UsuarisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        return this.mapToUsuariDto(this.usuarisService.getByNomUsuari(username)).get(0);
    }

    @PutMapping("/{id}")
    public UsuariDto actualitzarUsuari(@PathVariable("id") String nomUsuari, @RequestBody Usuari usuari) {
        Usuari usuariActualitzat = usuarisService.actualitzarUsuari(nomUsuari, usuari);
        return this.mapToUsuariDto(usuariActualitzat);
    }

    @PostMapping("/crear")
    public UsuariDto crearUsuari(@RequestBody Usuari usuari) {
        Usuari usuariCreat = usuarisService.crearUsuari(usuari);
        return mapToUsuariDto(usuariCreat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuari(@PathVariable("id") String nomUsuari) {
        usuarisService.eliminarUsuari(nomUsuari);
        return ResponseEntity.ok("Usuari eliminat correctament");
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
            usuarisDto.add(usuariDto);
        }
        logger.info(usuarisDto.toString());
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
        return usuariDto;
    }
}
