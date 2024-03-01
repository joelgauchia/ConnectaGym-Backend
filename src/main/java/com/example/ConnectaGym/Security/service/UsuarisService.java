package com.example.ConnectaGym.Security.service;

import com.example.ConnectaGym.Security.dto.JwtDto;
import com.example.ConnectaGym.Security.dto.LoginUsuari;
import com.example.ConnectaGym.Security.dto.NouUsuari;
import com.example.ConnectaGym.Security.entity.Rol;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.enums.RolNom;
import com.example.ConnectaGym.Security.jwt.JwtProvider;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarisService {

    @Autowired
    UsuarisRepository usuarisRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    public Optional<Usuari> getByNomUsuari(String nomUsuari) {
        return usuarisRepository.findByNomUsuari(nomUsuari);
    }

    public Optional<Usuari> getByNomUsuariOrEmail(String nomOrEmail) {
        return usuarisRepository.findByNomUsuariOrEmail(nomOrEmail, nomOrEmail);
    }

    public Optional<Usuari> getByTokenPassword(String tokenPassword) {
        return usuarisRepository.findByTokenPassword(tokenPassword);
    }

    public boolean existsByNomUsuari(String nomUsuari) {
        return usuarisRepository.existsByNomUsuari(nomUsuari);
    }

    public boolean existsByEmail(String email) {
        return usuarisRepository.existsByEmail(email);
    }

    public JwtDto login(LoginUsuari loginUsuari) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuari.getNomUsuari(), loginUsuari.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        return new JwtDto(jwt);
    }

    public JwtDto refresh(JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        return new JwtDto(token);
    }

    public Usuari save(NouUsuari nouUsuari) {
        Usuari usuari = new Usuari(nouUsuari.getNomUsuari(), nouUsuari.getEmail(), passwordEncoder.encode(nouUsuari.getPassword()), true, LocalDateTime.now(), LocalDateTime.now());
        Set<Rol> rols = new HashSet<>();
        rols.add(rolService.getByRolNom(RolNom.STAFF).get());
        if (nouUsuari.getRols().contains("GYMADMIN")) rols.add(rolService.getByRolNom(RolNom.GYMADMIN).get());
        if (nouUsuari.getRols().contains("SUPERADMIN")) rols.add(rolService.getByRolNom(RolNom.SUPERADMIN).get());
        usuari.setRols(rols);
        usuarisRepository.save(usuari);
        return usuari;
    }
}