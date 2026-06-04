package com.prestamos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;

    private String nombre;

    @Indexed(unique = true)
    private String cedula;

    private String telefono;
    private String direccion;

    @Indexed(unique = true)
    private String correo;

    private Date fechaRegistro;
    private boolean estado;

    // Constructor de negocio
    public Cliente(String nombre, String cedula, String telefono,
                   String direccion, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fechaRegistro = new Date();
        this.estado = true;
    }

    public void actualizar(String nombre, String telefono, String direccion, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }
}
