package com.prestamos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private String id;
    private String prestamoId;
    private Date fechaPago;
    private BigDecimal valor;
    private int cuotaId;
    private BigDecimal abono;
    private String metodoPago;
    private String referencia;
    private String estado;
}
