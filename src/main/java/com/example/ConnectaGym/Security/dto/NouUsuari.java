package com.example.ConnectaGym.Security.dto;

import java.util.HashSet;
import java.util.Set;

public class NouUsuari {
    private String nomUsuari;
    private String password;
    private String email;
    private Set<String> rols = new HashSet<>();

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRols() {
        return rols;
    }

    public void setRols(Set<String> rols) {
        this.rols = rols;
    }
}
