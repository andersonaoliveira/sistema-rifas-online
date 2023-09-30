package com.rifas.online.gerenciamentodeusuarios.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.rifas.online.gerenciamentodeusuarios.model.Usuario;
import com.rifas.online.gerenciamentodeusuarios.repository.UsuarioRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

        UserDetails userDetails = User.builder()
            .username(Usuario.getEmail())
            .password(Usuario.getSenha())
            .authorities(new SimpleGrantedAuthority("ROLE_USER"))
            .build();

        return userDetails;
    }
}
