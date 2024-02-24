package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Rol;
import com.example.ConnectaGym.Repositories.RolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolsService {

    @Autowired
    private RolsRepository rolsRepository;

    public List<Rol> getRols() {
        return this.rolsRepository.findAll();
    }

    public Rol getRolById(Long id) {
        Optional<Rol> rolOptional = this.rolsRepository.findById(id);
        return rolOptional.orElse(null);
    }

    public Rol afegirRol(Rol r) {
        return this.rolsRepository.save(r);
    }

    public Rol editarRol(Rol r) {
        return this.rolsRepository.save(r);
    }

    public Rol esborrarRol(Long id) {
        Optional<Rol> rolOptional = this.rolsRepository.findById(id);
        if (rolOptional.isPresent()) {
            Rol rol = rolOptional.get();
            this.rolsRepository.deleteById(id);
            return rol;
        } else {
            return null;
        }
    }
}