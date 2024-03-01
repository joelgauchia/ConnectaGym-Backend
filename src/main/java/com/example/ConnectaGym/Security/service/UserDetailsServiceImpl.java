package com.example.ConnectaGym.Security.service;

import com.example.ConnectaGym.Security.entity.Usuari;
import com.example.ConnectaGym.Security.entity.UsuariPrincipal;
import com.example.ConnectaGym.Security.repository.UsuarisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarisRepository usuarisRepository;

    @Override
    public UserDetails loadUserByUsername(String nomOrEmail) throws UsernameNotFoundException {
        Usuari usuari = usuarisRepository.findByNomUsuariOrEmail(nomOrEmail, nomOrEmail)
                .orElseThrow(()->new UsernameNotFoundException("Aquest usuari no existeix"));
        return UsuariPrincipal.build(usuari);
    }
}
