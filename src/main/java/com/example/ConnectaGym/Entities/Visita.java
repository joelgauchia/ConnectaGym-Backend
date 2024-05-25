package com.example.ConnectaGym.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Visites")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idMembre", referencedColumnName = "Id")
    private MembreGimnas membreGimnas;

    @Column(name = "DataVisita")
    private LocalDateTime dataVisita;

    @ManyToOne
    @JoinColumn(name = "idGimnas", referencedColumnName = "Id")
    private Gimnas gimnas;

    private Long preu;

    private boolean abonat;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MembreGimnas getMembreGimnas() {
        return membreGimnas;
    }
    
    public void setMembreGimnas(MembreGimnas membreGimnas) {
        this.membreGimnas = membreGimnas;
    }

    public LocalDateTime getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDateTime dataVisita) {
        this.dataVisita = dataVisita;
    }

    public Gimnas getGimnas() {
        return gimnas;
    }
    
    public void setGimnas(Gimnas gimnas) {
        this.gimnas = gimnas;
    }

    public boolean isAbonat() {
        return abonat;
    }

    public void setAbonat(boolean abonat) {
        this.abonat = abonat;
    }

    public Long getPreu() {
        return preu;
    }

    public void setPreu(Long preu) {
        this.preu = preu;
    }
}
