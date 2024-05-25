package com.example.ConnectaGym.Controllers;

import com.example.ConnectaGym.Entities.Missatge;
import com.example.ConnectaGym.Security.dto.MissatgeDto;
import com.example.ConnectaGym.Services.MissatgesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/missatges")
@RestController
public class MissatgesController {

    @Autowired
    MissatgesService missatgesService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarMissatge(@RequestBody Missatge m) {
        try {
            Missatge missatge = this.missatgesService.enviarMissatge(m);
            return ResponseEntity.status(HttpStatus.CREATED).body("Missatge enviat amb èxit");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error a l'enviar el missatge: " + e.getMessage());
        }
    }
}