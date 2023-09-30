package com.rifas.online.gerenciamentodeusuarios.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rifas.online.gerenciamentodeusuarios.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByEmail(String email);
}