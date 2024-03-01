package com.example.ConnectaGym.Security.entity;

import com.example.ConnectaGym.Entities.Gimnas;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuaris", uniqueConstraints = {@UniqueConstraint(columnNames = {"Email"})})
public class Usuari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "NomUsuari")
    private String nomUsuari;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;
    private String tokenPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UsuarisRol", joinColumns = @JoinColumn(name = "usuari_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> rols = new HashSet<>();

    @Column(name = "Actiu")
    private Boolean actiu;

    @Column(name = "DataCreacio")
    private LocalDateTime dataCreacio;

    @Column(name = "DataModificacio")
    private LocalDateTime dataModificacio;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Gimnas> gimnasos = new HashSet<>();

    public Usuari() {}

    public Usuari(String nomUsuari, String email, String password, Boolean actiu, LocalDateTime dataCreacio, LocalDateTime dataModificacio) {
        this.nomUsuari = nomUsuari;
        this.email = email;
        this.password = password;
        this.actiu = actiu;
        this.dataCreacio = dataCreacio;
        this.dataModificacio = dataModificacio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRols() {
        return rols;
    }

    public void setRols(Set<Rol> rols) {
        this.rols = rols;
    }

    public Boolean getActiu() {
        return actiu;
    }

    public void setActiu(Boolean actiu) {
        this.actiu = actiu;
    }

    public LocalDateTime getDataCreacio() {
        return dataCreacio;
    }

    public void setDataCreacio(LocalDateTime dataCreacio) {
        this.dataCreacio = dataCreacio;
    }

    public LocalDateTime getDataModificacio() {
        return dataModificacio;
    }

    public void setDataModificacio(LocalDateTime dataModificacio) {
        this.dataModificacio = dataModificacio;
    }

    public Set<Gimnas> getGimnasos() {
        return gimnasos;
    }

    public void setGimnasos(Set<Gimnas> gimnasos) {
        this.gimnasos = gimnasos;
    }
}