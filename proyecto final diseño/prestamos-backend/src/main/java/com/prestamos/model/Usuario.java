package com.prestamos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Clase base Usuario - implementa herencia con Administrador, Recaudador y ClienteUsuario
 * Patron de herencia de MongoDB: todos los subtipos en la misma coleccion con campo tipo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;

    private String nombre;
    private String username;
    private String password;
    private String email;
    private boolean estado;
    private Date fechaCreacion;
    private String rolId;
    private String tipo; // ADMINISTRADOR, RECAUDADOR, CLIENTE_USUARIO

    public Usuario(String nombre, String username, String password, String email, String rolId) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rolId = rolId;
        this.estado = true;
        this.fechaCreacion = new Date();
    }

    public boolean autenticar(String passwordIngresado) {
        return this.password.equals(passwordIngresado);
    }

    public boolean cambiarContrasena(String nuevaPassword) {
        if (nuevaPassword != null && !nuevaPassword.isBlank()) {
            this.password = nuevaPassword;
            return true;
        }
        return false;
    }
}
