package com.example.ConnectaGym.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "propietaris")
public class Propietari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Email")
    private String email;

    @Column(name = "Telefon")
    private String telefon;

    @Column(name = "Adreca")
    private String adreca;

    @Column(name = "DataNaixement")
    private LocalDateTime dataNaixement;

    @Column(name = "Genere")
    private String genere;

    @Column(name = "Tipus")
    private String tipus;

    @Column(name = "Creador")
    private String creador;

    @Column(name = "DataCreacio")
    private LocalDateTime dataCreacio;

    @Column(name = "DataModificacio")
    private LocalDateTime dataModificacio;

    // Getters i setters

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

    public LocalDateTime getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDateTime dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
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
