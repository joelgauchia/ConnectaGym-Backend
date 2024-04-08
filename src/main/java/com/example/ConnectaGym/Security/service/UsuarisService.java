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
import org.springframework.dao.DataIntegrityViolationException;
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
import java.util.List;
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

    public List<Usuari> getUsuaris() { return usuarisRepository.findAll(); }

    public Usuari getByNomUsuari(String nomUsuari) {
        return usuarisRepository.findByNomUsuari(nomUsuari);
    }

    public Usuari getByNomUsuariActiu(String nomUsuari) {
        Usuari usuari = usuarisRepository.findByNomUsuariAndActiuIsTrue(nomUsuari);
        if (usuari != null) {
            return usuari;
        } else throw new RuntimeException("No s'ha trobat cap usuari actiu amb aquest nom d'usuari");
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
        Usuari usuari = new Usuari(nouUsuari.getNomUsuari(), nouUsuari.getEmail(), nouUsuari.getNom(), passwordEncoder.encode(nouUsuari.getPassword()), true, LocalDateTime.now(), LocalDateTime.now());
        Set<Rol> rols = new HashSet<>();
        rols.add(rolService.getByRolNom(RolNom.STAFF).get());
        if (nouUsuari.getRols().contains("GYMADMIN")) rols.add(rolService.getByRolNom(RolNom.GYMADMIN).get());
        if (nouUsuari.getRols().contains("SUPERADMIN")) rols.add(rolService.getByRolNom(RolNom.SUPERADMIN).get());
        usuari.setRols(rols);
        usuarisRepository.save(usuari);
        return usuari;
    }

    public Usuari actualitzarUsuari(String nomUsuari, Usuari usuariEditat) {
        Usuari usuariExistent = usuarisRepository.findByNomUsuari(nomUsuari);
        if (usuariExistent != null) {
            usuariExistent.setNomUsuari(usuariEditat.getNomUsuari());
            usuariExistent.setNom(usuariEditat.getNom());
            usuariExistent.setEmail(usuariEditat.getEmail());
            usuariExistent.setActiu(usuariEditat.getActiu());
            usuariExistent.setDataCreacio(usuariEditat.getDataCreacio());
            usuariExistent.setDataModificacio(LocalDateTime.now());
            return usuarisRepository.save(usuariExistent);
        } else {
            throw new RuntimeException("No s'ha trobat cap usuari amb el nom d'usuari proporcionat");
        }
    }

    public Usuari crearUsuari(Usuari nouUsuari) {
        if (existsByNomUsuari(nouUsuari.getNomUsuari())) {
            throw new RuntimeException("El nom d'usuari ja està en ús");
        }
        if (existsByEmail(nouUsuari.getEmail())) {
            throw new RuntimeException("L'email ja està en ús");
        }
        Usuari usuari = new Usuari(nouUsuari.getNomUsuari(), nouUsuari.getEmail(), nouUsuari.getNom(), passwordEncoder.encode(nouUsuari.getPassword()), true, LocalDateTime.now(), LocalDateTime.now());

        Set<Rol> rols = new HashSet<>();

        if (nouUsuari.getRols().stream().anyMatch(rol -> rol.getRolNom() == RolNom.SUPERADMIN)) {
            rols.add(rolService.getByRolNom(RolNom.SUPERADMIN).orElseThrow(() -> new RuntimeException("El rol SUPERADMIN no s'ha trobat")));
            rols.add(rolService.getByRolNom(RolNom.GYMADMIN).orElseThrow(() -> new RuntimeException("El rol GYMADMIN no s'ha trobat")));
            rols.add(rolService.getByRolNom(RolNom.STAFF).orElseThrow(() -> new RuntimeException("El rol STAFF no s'ha trobat")));
        } else if (nouUsuari.getRols().stream().anyMatch(rol -> rol.getRolNom() == RolNom.GYMADMIN)) {
            rols.add(rolService.getByRolNom(RolNom.GYMADMIN).orElseThrow(() -> new RuntimeException("El rol GYMADMIN no s'ha trobat")));
            rols.add(rolService.getByRolNom(RolNom.STAFF).orElseThrow(() -> new RuntimeException("El rol STAFF no s'ha trobat")));
        } else {
            rols.add(rolService.getByRolNom(RolNom.STAFF).orElseThrow(() -> new RuntimeException("El rol STAFF no s'ha trobat")));
        }
        usuari.setRols(rols);

        return usuarisRepository.save(usuari);
    }

    public void eliminarUsuari(String nomUsuari) {
        try {
            Usuari usuariExistent = usuarisRepository.findByNomUsuari(nomUsuari);
            if (usuariExistent != null) {
                usuarisRepository.delete(usuariExistent);
            } else {
                throw new RuntimeException("No s'ha trobat cap usuari amb el nom d'usuari proporcionat");
            }
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es pot esborrar l'usuari");
        }
    }
}