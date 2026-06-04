package com.prestamos.service;

import com.prestamos.model.Prestamo;
import com.prestamos.repository.ClienteRepository;
import com.prestamos.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Map<String, Object> generarReporteCartera() {
        List<Prestamo> todos = prestamoRepository.findAll();
        BigDecimal totalCartera = todos.stream()
                .filter(p -> "ACTIVO".equals(p.getEstado()) || "APROBADO".equals(p.getEstado()))
                .map(Prestamo::calcularSaldoPendiente)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Object> reporte = new HashMap<>();
        reporte.put("totalPrestamos", todos.size());
        reporte.put("prestamosActivos", prestamoRepository.findByEstado("ACTIVO").size());
        reporte.put("totalCartera", totalCartera);
        reporte.put("clientes", clienteRepository.count());
        return reporte;
    }

    public Map<String, Object> generarReporteMora() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        long enMora = prestamos.stream()
                .flatMap(p -> p.getCuotas().stream())
                .filter(c -> c.verificarMora() && !"PAGADA".equals(c.getEstado()))
                .count();

        Map<String, Object> reporte = new HashMap<>();
        reporte.put("cuotasEnMora", enMora);
        return reporte;
    }

    public Map<String, Object> generarReportePagos() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        BigDecimal totalPagado = prestamos.stream()
                .flatMap(p -> p.getPagos().stream())
                .map(pago -> pago.getValor())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Object> reporte = new HashMap<>();
        reporte.put("totalPagos", prestamos.stream().mapToLong(p -> p.getPagos().size()).sum());
        reporte.put("totalRecaudado", totalPagado);
        return reporte;
    }
}
