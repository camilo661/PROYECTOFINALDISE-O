package com.prestamos.service;

import com.prestamos.dto.CuotaDTO;
import com.prestamos.dto.PrestamoDTO;
import com.prestamos.model.Cuota;
import com.prestamos.model.Prestamo;
import com.prestamos.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteService clienteService;

    public PrestamoDTO solicitarPrestamo(PrestamoDTO dto) {
        if (!clienteService.validarCliente(dto.getClienteId())) {
            throw new RuntimeException("Cliente no encontrado: " + dto.getClienteId());
        }
        Prestamo prestamo = new Prestamo(dto.getClienteId(), dto.getMonto(),
                dto.getTasaInteres(), dto.getPlazoMeses());
        return toDTO(prestamoRepository.save(prestamo));
    }

    public PrestamoDTO aprobarPrestamo(String id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado: " + id));
        prestamo.aprobar();
        return toDTO(prestamoRepository.save(prestamo));
    }

    public PrestamoDTO rechazarPrestamo(String id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado: " + id));
        prestamo.setEstado("CANCELADO");
        return toDTO(prestamoRepository.save(prestamo));
    }

    public PrestamoDTO consultarPrestamo(String id) {
        return prestamoRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado: " + id));
    }

    public List<PrestamoDTO> consultarPorCliente(String clienteId) {
        return prestamoRepository.findByClienteId(clienteId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PrestamoDTO> consultarTodos() {
        return prestamoRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<CuotaDTO> calcularCuotas(String id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado: " + id));
        return prestamo.getCuotas().stream().map(this::cuotaToDTO).collect(Collectors.toList());
    }

    public BigDecimal calcularInteres(String id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado: " + id));
        return prestamo.calcularInteres();
    }

    public BigDecimal calcularSaldoPendiente(String id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado: " + id));
        return prestamo.calcularSaldoPendiente();
    }

    public void marcarCuotaPagada(String prestamoId, int numeroCuota) {
        Prestamo prestamo = prestamoRepository.findById(prestamoId)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado: " + prestamoId));
        prestamo.getCuotas().stream()
                .filter(c -> c.getNumero() == numeroCuota)
                .findFirst()
                .ifPresent(c -> c.setEstado("PAGADA"));
        // Verificar si todas las cuotas estan pagadas
        boolean todasPagadas = prestamo.getCuotas().stream()
                .allMatch(c -> "PAGADA".equals(c.getEstado()));
        if (todasPagadas) {
            prestamo.setEstado("CANCELADO");
        }
        prestamoRepository.save(prestamo);
    }

    public Prestamo obtenerEntidad(String id) {
        return prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado: " + id));
    }

    public void guardar(Prestamo prestamo) {
        prestamoRepository.save(prestamo);
    }

    public PrestamoDTO toDTO(Prestamo p) {
        PrestamoDTO dto = new PrestamoDTO();
        dto.setId(p.getId());
        dto.setClienteId(p.getClienteId());
        dto.setMonto(p.getMonto());
        dto.setTasaInteres(p.getTasaInteres());
        dto.setPlazoMeses(p.getPlazoMeses());
        dto.setFechaSolicitud(p.getFechaPrestamo());
        dto.setEstado(p.getEstado());
        dto.setSaldoPendiente(p.getSaldoPendiente());
        return dto;
    }

    private CuotaDTO cuotaToDTO(Cuota c) {
        CuotaDTO dto = new CuotaDTO();
        dto.setNumero(c.getNumero());
        dto.setValor(c.getValor());
        dto.setFechaVencimiento(c.getFechaVencimiento());
        dto.setEstado(c.getEstado());
        dto.setSaldo(c.getSaldo());
        dto.setPagado(c.getPagado());
        return dto;
    }
}
