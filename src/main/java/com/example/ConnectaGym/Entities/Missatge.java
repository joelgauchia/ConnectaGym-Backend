package com.example.ConnectaGym.Entities;

import jakarta.persistence.*;

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

    @Column(name = "Titol")
    private String titol;

    @Column(name = "Missatge")
    private String missatge;

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
}
