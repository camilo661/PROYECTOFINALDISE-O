package com.prestamos.service;

import com.prestamos.dto.PagoDTO;
import com.prestamos.model.Pago;
import com.prestamos.model.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PagoService {

    @Autowired
    private PrestamoService prestamoService;

    public PagoDTO registrarPago(PagoDTO dto) {
        Prestamo prestamo = prestamoService.obtenerEntidad(dto.getPrestamoId());

        Pago pago = new Pago();
        pago.setId(UUID.randomUUID().toString());
        pago.setFechaPago(new Date());
        pago.setValor(dto.getValor());
        pago.setCuotaId(dto.getCuotaId());
        pago.setAbono(dto.getAbono() != null ? dto.getAbono() : dto.getValor());
        BigDecimal abono = dto.getAbono() != null ? dto.getAbono() : dto.getValor();
        pago.setAbono(abono);

        String metodoPago = dto.getMetodoPago() != null ? dto.getMetodoPago() : "EFECTIVO";
        pago.setMetodoPago(metodoPago);

        String referencia = dto.getReferencia() != null ? dto.getReferencia()
                : "PAG-" + System.currentTimeMillis();
        pago.setReferencia(referencia);
        pago.autenticar();

        prestamo.getPagos().add(pago);

        // Aplicar pago a la cuota correspondiente
        prestamo.getCuotas().stream()
                .filter(c -> c.getNumero() == dto.getCuotaId() && !"PAGADA".equals(c.getEstado()))
                .findFirst()
                .ifPresent(c -> c.pagoParcial(dto.getValor()));

        // Actualizar saldo pendiente
        prestamo.setSaldoPendiente(prestamo.calcularSaldoPendiente());

        // Verificar si todas las cuotas estan pagadas
        boolean todasPagadas = prestamo.getCuotas().stream()
                .allMatch(c -> "PAGADA".equals(c.getEstado()));
        if (todasPagadas) {
            prestamo.setEstado("CANCELADO");
        } else {
            prestamo.setEstado("ACTIVO");
        }

        prestamoService.guardar(prestamo);
        return toDTO(pago, dto.getPrestamoId());
    }

    public List<PagoDTO> consultarPagosPorPrestamo(String prestamoId) {
        Prestamo prestamo = prestamoService.obtenerEntidad(prestamoId);
        return prestamo.getPagos().stream()
                .map(p -> toDTO(p, prestamoId))
                .collect(Collectors.toList());
    }

    public BigDecimal calcularAbono(String prestamoId, BigDecimal monto) {
        Prestamo prestamo = prestamoService.obtenerEntidad(prestamoId);
        return prestamo.calcularSaldoPendiente().subtract(monto).max(BigDecimal.ZERO);
    }

    public String generarComprobante(String prestamoId, String pagoId) {
        Prestamo prestamo = prestamoService.obtenerEntidad(prestamoId);
        return prestamo.getPagos().stream()
                .filter(p -> p.getId().equals(pagoId))
                .findFirst()
                .map(p -> "COMPROBANTE PAGO: " + p.getReferencia() +
                          " | Valor: " + p.getValor() +
                          " | Fecha: " + p.getFechaPago())
                .orElseThrow(() -> new RuntimeException("Pago no encontrado: " + pagoId));
    }

    private PagoDTO toDTO(Pago p, String prestamoId) {
        PagoDTO dto = new PagoDTO();
        dto.setId(p.getId());
        dto.setPrestamoId(prestamoId);
        dto.setFechaPago(p.getFechaPago());
        dto.setValor(p.getValor());
        dto.setCuotaId(p.getCuotaId());
        dto.setAbono(p.getAbono());
        dto.setMetodoPago(p.getMetodoPago());
        dto.setReferencia(p.getReferencia());
        return dto;
    }
}
