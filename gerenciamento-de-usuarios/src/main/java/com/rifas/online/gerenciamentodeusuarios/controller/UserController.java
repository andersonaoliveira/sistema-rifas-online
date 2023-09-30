package com.rifas.online.gerenciamentodeusuarios.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rifas.online.gerenciamentodeusuarios.service.UserService;
import com.rifas.online.gerenciamentodeusuarios.model.Usuario;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getPassword() == null || Usuario.getEmail() == null) {
            return ResponseEntity.badRequest().body("Por favor, forneça todos os campos obrigatórios.");
        }
        if (UserService.existsByUsername(usuario.getUsername())) {
            return ResponseEntity.badRequest().body("Nome de usuário já em uso.");
        }
        if (UserService.existsByEmail(Usuario.getEmail())) {
            return ResponseEntity.badRequest().body("Email já em uso.");
        }

        userService.createUser(usuario);
        return ResponseEntity.ok("Usuário criado com sucesso.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("ID de usuário inválido.");
        }
        Optional<Usuario> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            Usuario user = userOptional.get();
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
            userDetailsDTO.setId(user.getId());
            userDetailsDTO.setUsername(user.getUsername());
            userDetailsDTO.setEmail(Usuario.getEmail());
            return ResponseEntity.ok(userDetailsDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("ID de usuário inválido.");
        }
        Optional<Usuario> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            Usuario user = userOptional.get();
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            user.setEmail(userRequest.getEmail());
            userService.save(user);
            return ResponseEntity.ok("Usuário atualizado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("ID de usuário inválido.");
        }
        Optional<Usuario> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            userService.deleteUser(userOptional.get());
            return ResponseEntity.ok("Usuário excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
