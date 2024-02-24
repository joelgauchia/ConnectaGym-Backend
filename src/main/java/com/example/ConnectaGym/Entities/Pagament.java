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

    @Column(name = "NomMembre")
    private String nomMembre;

    @Column(name = "Quota")
    private double quota;

    @Column(name = "Quantitat")
    private Long quantitat;

    @Column(name = "DataInici")
    private Date dataInici;

    @Column(name = "DataFinal")
    private Date dataFinal;

    @Column(name = "Gimnas")
    private String gimnas;

    @Column(name = "Actiu")
    private boolean actiu;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
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

    public String getGimnas() {
        return gimnas;
    }

    public void setGimnas(String gimnas) {
        this.gimnas = gimnas;
    }

    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }
}