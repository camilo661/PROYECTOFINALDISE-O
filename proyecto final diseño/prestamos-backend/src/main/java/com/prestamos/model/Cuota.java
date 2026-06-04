package com.prestamos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuota {

    private int numero;
    private BigDecimal valor;
    private Date fechaVencimiento;
    private String estado; // PENDIENTE, PAGADA, VENCIDA
    private BigDecimal capital;
    private BigDecimal interes;
    private BigDecimal saldo;
    private BigDecimal pagado;

    public boolean verificarMora() {
        return "VENCIDA".equals(this.estado) ||
               (new Date().after(this.fechaVencimiento) && !"PAGADA".equals(this.estado));
    }

    public BigDecimal pagoParcial(BigDecimal monto) {
        if (this.pagado == null) this.pagado = BigDecimal.ZERO;
        this.pagado = this.pagado.add(monto);
        this.saldo = this.valor.subtract(this.pagado);
        if (this.saldo.compareTo(BigDecimal.ZERO) <= 0) {
            this.estado = "PAGADA";
            this.saldo = BigDecimal.ZERO;
        }
        return this.saldo;
    }

    public BigDecimal getSaldoDeCuota() {
        if (this.pagado == null) return this.valor;
        return this.valor.subtract(this.pagado);
    }
}
