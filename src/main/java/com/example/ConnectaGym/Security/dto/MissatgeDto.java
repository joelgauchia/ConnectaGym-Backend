package com.example.ConnectaGym.Security.dto;

import com.example.ConnectaGym.Entities.MembreGimnas;
import com.example.ConnectaGym.Security.entity.Usuari;

import java.time.LocalDateTime;

public class MissatgeDto {
    private Long id;
    private MembreGimnas membre;
    private Usuari remitent;
    private String titol;
    private String missatge;
    private LocalDateTime dataEnviament;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MembreGimnas getMembre() {
        return membre;
    }

    public void setMembre(MembreGimnas membre) {
        this.membre = membre;
    }

    public Usuari getRemitent() {
        return remitent;
    }

    public void setRemitent(Usuari remitent) {
        this.remitent = remitent;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getMissatge() {
        return missatge;
    }

    public void setMissatge(String missatge) {
        this.missatge = missatge;
    }

    public LocalDateTime getDataEnviament() {
        return dataEnviament;
    }

    public void setDataEnviament(LocalDateTime dataEnviament) {
        this.dataEnviament = dataEnviament;
    }
}
