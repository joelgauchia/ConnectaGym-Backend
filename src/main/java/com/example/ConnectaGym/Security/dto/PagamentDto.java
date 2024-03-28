package com.example.ConnectaGym.Security.dto;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Entities.MembreGimnas;
import com.example.ConnectaGym.Entities.Quota;

import java.time.LocalDateTime;

public class PagamentDto {
    private Long id;
    private MembreGimnas membre;
    private Quota quota;
    private double quantitat;
    private LocalDateTime dataInici;
    private LocalDateTime dataFinal;
    private Gimnas gimnas;

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

    public double getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(double quantitat) {
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
