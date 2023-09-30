package com.rifas.online.gerenciamentodeusuarios.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;

    @NotBlank
    private String nome;

    @Pattern(regexp = "^[0]{8}[0-9]{3}$")
    private String cpf;

    @Email
    private String email;

    @NotBlank
    private String telefone;

    @Pattern(regexp = "^[0]{8}[0-9]{3}$")
    private String cep;

    @NotBlank
    private String rua;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String pais;

    public static String getEmail() {
        return null;
    }

    public static String getSenha() {
        return null;
    }

    public Object getUsername() {
        return null;
    }

    public Object getPassword() {
        return null;
    }

    public Object getId() {
        return null;
    }

    public void setUsername(Object username) {
    }

    public void setPassword(Object password) {
    }

    public void setEmail(Object email2) {
    }

}