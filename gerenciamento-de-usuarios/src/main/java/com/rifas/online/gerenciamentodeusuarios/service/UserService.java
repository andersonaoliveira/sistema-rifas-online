package com.rifas.online.gerenciamentodeusuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rifas.online.gerenciamentodeusuarios.repository.UsuarioRepository;
import com.rifas.online.gerenciamentodeusuarios.model.Usuario;


@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUser(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public Usuario getUserById(String usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public static boolean existsByUsername(Object username) {
        return false;
    }

    public static boolean existsByEmail(String email) {
        return false;
    }

    public Optional<Usuario> findById(Long id) {
        return null;
    }

    public void save(Usuario user) {
    }

}
