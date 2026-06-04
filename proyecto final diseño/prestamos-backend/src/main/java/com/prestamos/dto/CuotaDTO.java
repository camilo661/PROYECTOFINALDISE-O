package com.prestamos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuotaDTO {
    private int numero;
    private BigDecimal valor;
    private Date fechaVencimiento;
    private String estado;
    private BigDecimal saldo;
    private BigDecimal pagado;
}
