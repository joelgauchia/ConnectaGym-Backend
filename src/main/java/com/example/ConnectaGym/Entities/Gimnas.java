package com.example.ConnectaGym.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gimnasos")
public class Gimnas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Adreca")
    private String adreca;

    @Column(name = "Telefon")
    private String telefon;

    @Column(name = "Email")
    private String email;

    @Column(name = "NomPropietari")
    private String nomPropietari;

    @Column(name = "Admin")
    private String admin;

    @Column(name = "DataCreacio")
    private LocalDateTime dataCreacio;

    @Column(name = "DataModificacio")
    private LocalDateTime dataModificacio;

    protected Gimnas() {

    }

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

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomPropietari() {
        return nomPropietari;
    }

    public void setNomPropietari(String nomPropietari) {
        this.nomPropietari = nomPropietari;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
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