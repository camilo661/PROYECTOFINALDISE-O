package com.prestamos.model;

/**
 * Administrador hereda de Usuario - gestiona usuarios y sistema
 */
public class Administrador extends Usuario {

    public Administrador() {
        super();
        this.setTipo("ADMINISTRADOR");
    }

    public Administrador(String nombre, String username, String password, String email, String rolId) {
        super(nombre, username, password, email, rolId);
        this.setTipo("ADMINISTRADOR");
    }

    public void gestionarUsuarios() {
        // logica de gestion de usuarios del sistema
    }

    public void gestionarSistema() {
        // logica de gestion global del sistema
    }

    public void verReportes() {
        // logica de acceso a reportes del sistema
    }
}
