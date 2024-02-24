package com.example.ConnectaGym.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ajustaments")
public class Ajustament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "NomAplicacio")
    private String nomAplicacio;

    @Column(name = "MostrarLogo")
    private Boolean mostrarLogo;

    @Column(name = "ColorAplicacio")
    private String colorAplicacio;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomAplicacio() {
        return nomAplicacio;
    }

    public void setNomAplicacio(String nomAplicacio) {
        this.nomAplicacio = nomAplicacio;
    }

    public Boolean getMostrarLogo() {
        return mostrarLogo;
    }

    public void setMostrarLogo(Boolean mostrarLogo) {
        this.mostrarLogo = mostrarLogo;
    }

    public String getColorAplicacio() {
        return colorAplicacio;
    }

    public void setColorAplicacio(String colorAplicacio) {
        this.colorAplicacio = colorAplicacio;
    }
}
