package com.prestamos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String id;
    private String nombre;
    private String cedula;
    private String telefono;
    private String direccion;
    private String correo;
    private Date fechaRegistro;
    private boolean estado;
}
