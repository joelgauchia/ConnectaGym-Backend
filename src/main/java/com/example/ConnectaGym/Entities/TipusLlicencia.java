package com.example.ConnectaGym.Entities;

import com.example.ConnectaGym.Security.entity.Usuari;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tipusllicencies")
public class TipusLlicencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Preu")
    private Double preu;

    @Column(name = "Tipus")
    private String tipus;

    @Column(name = "Mesos")
    private Long mesos;

    @ManyToOne
    @JoinColumn(name = "IdCreador", referencedColumnName = "Id")
    private Usuari creador;

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

    public Double getPreu() {
        return preu;
    }

    public void setPreu(Double preu) {
        this.preu = preu;
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
