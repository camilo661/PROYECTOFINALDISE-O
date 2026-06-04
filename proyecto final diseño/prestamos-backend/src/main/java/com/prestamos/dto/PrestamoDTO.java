package com.prestamos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDTO {
    private String id;
    private String clienteId;
    private BigDecimal monto;
    private BigDecimal tasaInteres;
    private int plazoMeses;
    private Date fechaSolicitud;
    private String estado;
    private BigDecimal saldoPendiente;
}
