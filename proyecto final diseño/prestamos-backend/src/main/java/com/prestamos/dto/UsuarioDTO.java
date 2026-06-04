package com.prestamos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String id;
    private String nombre;
    private String username;
    private String email;
    private String rolId;
    private boolean estado;
    private String tipo;
}
