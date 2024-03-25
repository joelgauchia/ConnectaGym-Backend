package com.example.ConnectaGym.Security.dto;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Security.entity.Usuari;

import java.time.LocalDateTime;

public class MembreDto {
    private Long id;
    private String nom;
    private String email;
    private String telefon;
    private String adreca;
    private String genere;
    private String estat;
    private LocalDateTime dataNaixement;
    private String observacions;
    private Gimnas gimnas;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public LocalDateTime getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDateTime dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getObservacions() {
        return observacions;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }

    public Gimnas getGimnas() {
        return gimnas;
    }

    public void setGimnas(Gimnas gimnas) {
        this.gimnas = gimnas;
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
