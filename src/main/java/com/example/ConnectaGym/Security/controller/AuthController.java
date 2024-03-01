package com.example.ConnectaGym.Security.controller;

import com.example.ConnectaGym.Security.dto.JwtDto;
import com.example.ConnectaGym.Security.dto.LoginUsuari;
import com.example.ConnectaGym.Security.dto.NouUsuari;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.service.UsuarisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    UsuarisService usuarisService;

    @PostMapping("/register")
    public ResponseEntity<Usuari> register(@Valid @RequestBody NouUsuari nouUsuari, BindingResult bindingResult) {
       return ResponseEntity.ok(usuarisService.save(nouUsuari));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuari loginUsuari, BindingResult bindingResult) {
        return ResponseEntity.ok(usuarisService.login(loginUsuari));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        return ResponseEntity.ok(usuarisService.refresh(jwtDto));
    }
}
