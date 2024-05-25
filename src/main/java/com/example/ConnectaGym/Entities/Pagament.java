package com.example.ConnectaGym.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "pagaments")
public class Pagament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IdMembre", referencedColumnName = "Id")
    private MembreGimnas membre;
    
    @ManyToOne
    @JoinColumn(name = "IdQuota", referencedColumnName = "Id")
    private Quota quota;

    @Column(name = "Quantitat")
    private Long quantitat;

    @Column(name = "DataInici")
    private LocalDateTime dataInici;

    @Column(name = "DataFinal")
    private LocalDateTime dataFinal;

    @ManyToOne
    @JoinColumn(name = "IdGimnas", referencedColumnName = "Id")
    private Gimnas gimnas;

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
    
    public Quota getQuota() {
        return quota;
    }
    
    public void setQuota(Quota quota) {
        this.quota = quota;
    }
    
    public Long getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(Long quantitat) {
        this.quantitat = quantitat;
    }

    public LocalDateTime getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDateTime dataInici) {
        this.dataInici = dataInici;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Gimnas getGimnas() {
        return gimnas;
    }

    public void setGimnas(Gimnas gimnas) {
        this.gimnas = gimnas;
    }
}
