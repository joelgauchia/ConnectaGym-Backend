package com.example.ConnectaGym.Security.dto;

import com.example.ConnectaGym.Entities.Propietari;
import com.example.ConnectaGym.Entities.TipusLlicencia;

import java.time.LocalDateTime;

public class LlicenciaDto {
    private Long id;
    private Propietari propietari;
    private TipusLlicencia tipusLlicencia;
    private double preu;
    private boolean activa;
    private LocalDateTime dataInici;
    private LocalDateTime dataVenciment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Propietari getPropietari() {
        return propietari;
    }

    public void setPropietari(Propietari propietari) {
        this.propietari = propietari;
    }

    public TipusLlicencia getTipusLlicencia() {
        return tipusLlicencia;
    }

    public void setTipusLlicencia(TipusLlicencia tipusLlicencia) {
        this.tipusLlicencia = tipusLlicencia;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public LocalDateTime getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDateTime dataInici) {
        this.dataInici = dataInici;
    }

    public LocalDateTime getDataVenciment() {
        return dataVenciment;
    }

    public void setDataVenciment(LocalDateTime dataVenciment) {
        this.dataVenciment = dataVenciment;
    }
}
