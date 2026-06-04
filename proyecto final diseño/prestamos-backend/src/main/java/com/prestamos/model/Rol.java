package com.prestamos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "roles")
public class Rol {

    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private List<String> permisos;

    public Rol(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getRol() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "Rol{id='" + id + "', nombre='" + nombre + "'}";
    }
}
