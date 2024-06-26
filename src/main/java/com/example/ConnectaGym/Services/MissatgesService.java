package com.example.ConnectaGym.Services;

import com.example.ConnectaGym.Entities.Missatge;
import com.example.ConnectaGym.Repositories.MissatgesRepository;
import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MissatgesService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MissatgesRepository missatgesRepository;

    @Autowired
    private UsuarisRepository usuarisRepository;

    public Missatge enviarMissatge(Missatge missatge) {
        Usuari remitent = usuarisRepository.findByNomUsuari(missatge.getRemitent().getNomUsuari());
        if (remitent == null) throw new RuntimeException("L'usuari remitent no existeix a la base de dades.");

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(missatge.getMembre().getEmail());
        email.setSubject(missatge.getTitol());
        email.setText(missatge.getMissatge());
        mailSender.send(email);

        missatge.setRemitent(remitent);

        return missatgesRepository.save(missatge);
    }
}