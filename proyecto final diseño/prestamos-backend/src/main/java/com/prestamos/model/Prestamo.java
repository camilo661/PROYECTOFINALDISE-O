package com.prestamos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "prestamos")
public class Prestamo {

    @Id
    private String id;

    private String clienteId;
    private BigDecimal monto;
    private BigDecimal tasaInteres;       // tasa mensual en porcentaje
    private Date fechaPrestamo;
    private int plazoMeses;
    private int numeroCuotas;
    private BigDecimal saldoPendiente;
    private String estado;               // SOLICITADO, APROBADO, ACTIVO, CANCELADO, EN_MORA

    // Cuotas y pagos embebidos en el prestamo (patron MongoDB)
    private List<Cuota> cuotas = new ArrayList<>();
    private List<Pago> pagos = new ArrayList<>();

    // Constructor de negocio
    public Prestamo(String clienteId, BigDecimal monto, BigDecimal tasaInteres, int plazoMeses) {
        this.clienteId = clienteId;
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.plazoMeses = plazoMeses;
        this.numeroCuotas = plazoMeses;
        this.fechaPrestamo = new Date();
        this.estado = "SOLICITADO";
        this.saldoPendiente = monto;
    }

    /** Calcula la cuota fija mensual usando formula de amortizacion francesa */
    public BigDecimal calcularCuotas() {
        if (tasaInteres.compareTo(BigDecimal.ZERO) == 0) {
            return monto.divide(BigDecimal.valueOf(plazoMeses), 2, RoundingMode.HALF_UP);
        }
        BigDecimal tasa = tasaInteres.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal factor = tasa.add(BigDecimal.ONE).pow(plazoMeses);
        BigDecimal cuota = monto.multiply(tasa).multiply(factor)
                .divide(factor.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
        return cuota;
    }

    public BigDecimal calcularInteres() {
        return monto.multiply(tasaInteres.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP));
    }

    public BigDecimal calcularSaldoPendiente() {
        BigDecimal totalPagado = pagos.stream()
                .map(Pago::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return monto.subtract(totalPagado).max(BigDecimal.ZERO);
    }

    public void aprobar() {
        this.estado = "APROBADO";
        generarCuotas();
    }

    /** Genera el plan de cuotas al aprobar el prestamo */
    private void generarCuotas() {
        this.cuotas.clear();
        BigDecimal cuotaValor = calcularCuotas();
        BigDecimal saldo = this.monto;
        BigDecimal tasa = tasaInteres.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fechaPrestamo);

        for (int i = 1; i <= this.plazoMeses; i++) {
            cal.add(Calendar.MONTH, 1);
            BigDecimal intereses = saldo.multiply(tasa).setScale(2, RoundingMode.HALF_UP);
            BigDecimal capital = cuotaValor.subtract(intereses).setScale(2, RoundingMode.HALF_UP);
            saldo = saldo.subtract(capital).max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);

            Cuota c = new Cuota();
            c.setNumero(i);
            c.setValor(cuotaValor);
            c.setFechaVencimiento(cal.getTime());
            c.setEstado("PENDIENTE");
            c.setCapital(capital);
            c.setInteres(intereses);
            c.setSaldo(saldo);
            c.setPagado(BigDecimal.ZERO);
            this.cuotas.add(c);
        }
    }

    public void consultar() {
        // metodo de acceso a datos del prestamo
    }
}
