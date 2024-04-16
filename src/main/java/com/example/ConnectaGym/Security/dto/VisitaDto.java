package com.example.ConnectaGym.Security.dto;

import com.example.ConnectaGym.Entities.Gimnas;
import com.example.ConnectaGym.Entities.MembreGimnas;

import java.time.LocalDateTime;

public class VisitaDto {
    private Long id;
    private MembreGimnas membreGimnas;
    private Gimnas gimnas;
    private LocalDateTime dataVisita;
    private boolean abonat;
    private Long preu;

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

    public Gimnas getGimnas() {
        return gimnas;
    }

    public void setGimnas(Gimnas gimnas) {
        this.gimnas = gimnas;
    }

    public LocalDateTime getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDateTime dataVisita) {
        this.dataVisita = dataVisita;
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
