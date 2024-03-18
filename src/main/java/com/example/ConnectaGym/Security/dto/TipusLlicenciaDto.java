package com.example.ConnectaGym.Security.dto;

import com.example.ConnectaGym.Security.entity.Usuari;

import java.time.LocalDateTime;

public class TipusLlicenciaDto {
    private Long id;
    private String nom;
    private String tipus;
    private Long mesos;
    private double preu;
    private Usuari creador;
    private LocalDateTime dataCreacio;
    private LocalDateTime dataModificacio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public Long getMesos() {
        return mesos;
    }

    public void setMesos(Long mesos) {
        this.mesos = mesos;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public Usuari getCreador() {
        return creador;
    }

    public void setCreador(Usuari creador) {
        this.creador = creador;
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
}
