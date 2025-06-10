package org.serratec.backend.service;

import org.serratec.backend.entity.Usuario;
import org.serratec.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetalheImpl implements UserDetailsService {

//    @Autowired
    private UsuarioRepository repository;

    // Injeção de dependência através do construtor passando o repositório
    public UsuarioDetalheImpl (UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Email não encontrado"));
        return usuario;
    }
}
