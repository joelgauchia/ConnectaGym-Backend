package com.example.ConnectaGym.Security.dto;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Security.entity.Rol;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UsuariDto {
    private String nomUsuari;
    private String email;
    private String nom;
    private boolean actiu;
    private LocalDateTime dataCreacio;
    private LocalDateTime dataModificacio;
    private Set<Rol> rols = new HashSet<>();
    private Gimnas gimnasStaff;

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }

    public LocalDateTime getDataCreacio() {
        return dataCreacio;
    }

    public void setDataCreacio(LocalDateTime dataCreacio) {
        this.dataCreacio = dataCreacio;
    }

    public LocalDateTime getDataModificacio() {
        return dataModificacio;
    }

    public void setDataModificacio(LocalDateTime dataModificacio) {
        this.dataModificacio = dataModificacio;
    }

    public Set<Rol> getRols() {
        return rols;
    }

    public void setRols(Set<Rol> rols) {
        this.rols = rols;
    }

    public Gimnas getGimnasStaff() {
        return gimnasStaff;
    }

    public void setGimnasStaff(Gimnas gimnasStaff) {
        this.gimnasStaff = gimnasStaff;
    }
}
