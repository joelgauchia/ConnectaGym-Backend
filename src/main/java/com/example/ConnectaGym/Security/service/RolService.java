package com.example.ConnectaGym.Security.service;

import com.example.ConnectaGym.Security.entity.Rol;
import com.example.ConnectaGym.Security.enums.RolNom;
import com.example.ConnectaGym.Security.repository.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNom(RolNom rolNom) {
        return rolRepository.findByRolNom(rolNom);
    }

    public void save(Rol rol) {
        rolRepository.save(rol);
    }
}
