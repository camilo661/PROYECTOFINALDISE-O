package com.prestamos.model;

/**
 * Recaudador hereda de Usuario - registra pagos y consulta deudas
 */
public class Recaudador extends Usuario {

    public Recaudador() {
        super();
        this.setTipo("RECAUDADOR");
    }

    public Recaudador(String nombre, String username, String password, String email, String rolId) {
        super(nombre, username, password, email, rolId);
        this.setTipo("RECAUDADOR");
    }

    public void registrarPago() {
        // logica de registro de pagos
    }

    public void consultarDeuda() {
        // logica de consulta de deuda del cliente
    }

    public void imprimirRecibo() {
        // logica de impresion de recibos de pago
    }
}
