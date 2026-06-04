package com.prestamos.model;

/**
 * ClienteUsuario hereda de Usuario - puede solicitar prestamos y ver su historial
 */
public class ClienteUsuario extends Usuario {

    private String clienteId; // referencia al cliente en la coleccion clientes

    public ClienteUsuario() {
        super();
        this.setTipo("CLIENTE_USUARIO");
    }

    public ClienteUsuario(String nombre, String username, String password, String email,
                          String rolId, String clienteId) {
        super(nombre, username, password, email, rolId);
        this.setTipo("CLIENTE_USUARIO");
        this.clienteId = clienteId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void solicitarPrestamo() {
        // logica de solicitud de prestamo por parte del cliente
    }

    public void verHistorialPagos() {
        // logica para ver el historial de pagos del cliente
    }
}
