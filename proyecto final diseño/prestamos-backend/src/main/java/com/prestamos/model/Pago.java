package com.prestamos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    private String id;
    private Date fechaPago;
    private BigDecimal valor;
    private int cuotaId;
    private BigDecimal abono;
    private String metodoPago;
    private String referencia;
    private String registradoPor;

    public void autenticar() {
        // validar que el pago tenga los campos requeridos
        if (this.valor == null || this.valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El valor del pago debe ser mayor a cero");
        }
    }

    public boolean cambiarContrasena() {
        return this.referencia != null && !this.referencia.isBlank();
    }
}
