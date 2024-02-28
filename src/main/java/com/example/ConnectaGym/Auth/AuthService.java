package com.example.ConnectaGym.Auth;

import com.example.ConnectaGym.Entities.Rol;
import com.example.ConnectaGym.Entities.Usuari;
import com.example.ConnectaGym.Jwt.JwtService;
import com.example.ConnectaGym.Repositories.UsuarisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarisRepository usuarisRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usuarisRepository.findByNomUsuari(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuari user = Usuari.builder()
                .nomUsuari(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .rol(Rol.STAFF)
                .dataCreacio(LocalDateTime.now())
                .dataModificacio(LocalDateTime.now())
                .actiu(true)
                .build();

        usuarisRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}