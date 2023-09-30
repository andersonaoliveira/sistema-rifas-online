package com.rifas.online.gerenciamentodeusuarios.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    public JwtAuthenticationResponse(String token) {
    }

    private String accessToken;
}