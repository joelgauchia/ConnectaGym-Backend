package com.example.ConnectaGym.Entities;

import jakarta.persistence.*;
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
    private Date dataInici;

    @Column(name = "DataFinal")
    private Date dataFinal;

    @ManyToOne
    @JoinColumn(name = "IdGimnas", referencedColumnName = "Id")
    private Gimnas gimnas;

    @Column(name = "Actiu")
    private boolean actiu;

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

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Gimnas getGimnas() {
        return gimnas;
    }

    public void setGimnas(Gimnas gimnas) {
        this.gimnas = gimnas;
    }

    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }
}
