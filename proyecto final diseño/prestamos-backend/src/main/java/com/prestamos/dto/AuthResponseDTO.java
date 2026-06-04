package com.prestamos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDTO {
    private String token;
    private String tipo = "Bearer";
    private String username;
    private String rol;

    public AuthResponseDTO(String token, String username, String rol) {
        this.token = token;
        this.username = username;
        this.rol = rol;
    }
}
