package com.example.ConnectaGym.Entities;

import com.example.ConnectaGym.Security.entity.Usuari;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "missatges")
public class Missatge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IdMembre", referencedColumnName = "Id")
    private MembreGimnas membre;

    @ManyToOne
    @JoinColumn(name = "IdUsuari", referencedColumnName = "Id")
    private Usuari remitent;

    @Column(name = "Titol")
    private String titol;

    @Column(name = "Missatge")
    private String missatge;

    @Column(name = "dataEnviament")
    private LocalDateTime dataEnviament;

    // Getters y setters

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
