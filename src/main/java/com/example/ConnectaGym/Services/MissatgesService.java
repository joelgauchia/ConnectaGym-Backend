package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Missatge;
import com.example.ConnectaGym.Repositories.MissatgesRepository;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissatgesService {

    @Autowired
    private MissatgesRepository missatgesRepository;

    @Autowired
    private UsuarisRepository usuarisRepository;

    public Missatge enviarMissatge(Missatge missatge) {
        Usuari remitent = usuarisRepository.findByNomUsuari(missatge.getRemitent().getNomUsuari());

        if (remitent == null) throw new RuntimeException("L'usuari remitent no existeix a la base de dades.");
        missatge.setRemitent(remitent);

        return missatgesRepository.save(missatge);
    }
}