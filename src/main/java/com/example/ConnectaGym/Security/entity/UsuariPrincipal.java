package com.example.ConnectaGym.Security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuariPrincipal implements UserDetails {

    private final String nomUsuari;
    private final String email;
    private final String nom;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public UsuariPrincipal(String nomUsuari, String email, String nom, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nomUsuari = nomUsuari;
        this.email = email;
        this.nom = nom;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuariPrincipal build(Usuari usuari) {
        List<GrantedAuthority> authorities = usuari.getRols().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNom().name())).collect(Collectors.toList());
        return new UsuariPrincipal(usuari.getNomUsuari(), usuari.getEmail(), usuari.getNom(), usuari.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nomUsuari;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }
}
