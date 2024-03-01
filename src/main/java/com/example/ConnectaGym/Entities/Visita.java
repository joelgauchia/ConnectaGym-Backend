package com.example.ConnectaGym.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
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
    private Date dataVisita;

    @ManyToOne
    @JoinColumn(name = "idGimnas", referencedColumnName = "Id")
    private Gimnas gimnas;

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

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public Gimnas getGimnas() {
        return gimnas;
    }
    
    public void setGimnas(Gimnas gimnas) {
        this.gimnas = gimnas;
    }
}
