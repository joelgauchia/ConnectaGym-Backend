package com.example.ConnectaGym.Security.entity;

import com.example.ConnectaGym.Security.enums.RolNom;
import jakarta.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RolNom rolNom;

    public Rol() {}

    public Rol(RolNom rolNom) {
        this.rolNom = rolNom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNom getRolNom() {
        return rolNom;
    }

    public void setRolNom(RolNom rolNom) {
        this.rolNom = rolNom;
    }
}