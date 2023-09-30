package com.rifas.online.gerenciamentodeusuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rifas.online.gerenciamentodeusuarios.dto.JwtAuthenticationResponse;
import com.rifas.online.gerenciamentodeusuarios.dto.LoginRequest;
import com.rifas.online.gerenciamentodeusuarios.dto.SignUpRequest;
import com.rifas.online.gerenciamentodeusuarios.model.Usuario;
import com.rifas.online.gerenciamentodeusuarios.service.UserService;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(userDetails);

        JwtAuthenticationResponse response = new JwtAuthenticationResponse(token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if (UserService.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (UserService.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Email is already in use!", HttpStatus.BAD_REQUEST);
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(signUpRequest.getUsername());
        novoUsuario.setEmail(signUpRequest.getEmail());
        novoUsuario.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        userService.createUser(novoUsuario);

        return new ResponseEntity<>("User registered successfully.", HttpStatus.CREATED);
    }
}
