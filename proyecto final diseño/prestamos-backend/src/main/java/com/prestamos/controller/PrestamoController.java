package com.prestamos.controller;

import com.prestamos.dto.CuotaDTO;
import com.prestamos.dto.PrestamoDTO;
import com.prestamos.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<PrestamoDTO> solicitar(@RequestBody PrestamoDTO dto) {
        return ResponseEntity.ok(prestamoService.solicitarPrestamo(dto));
    }

    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> listar() {
        return ResponseEntity.ok(prestamoService.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> obtener(@PathVariable String id) {
        return ResponseEntity.ok(prestamoService.consultarPrestamo(id));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PrestamoDTO>> porCliente(@PathVariable String clienteId) {
        return ResponseEntity.ok(prestamoService.consultarPorCliente(clienteId));
    }

    @PutMapping("/{id}/aprobar")
    public ResponseEntity<PrestamoDTO> aprobar(@PathVariable String id) {
        return ResponseEntity.ok(prestamoService.aprobarPrestamo(id));
    }

    @PutMapping("/{id}/rechazar")
    public ResponseEntity<PrestamoDTO> rechazar(@PathVariable String id) {
        return ResponseEntity.ok(prestamoService.rechazarPrestamo(id));
    }

    @GetMapping("/{id}/cuotas")
    public ResponseEntity<List<CuotaDTO>> cuotas(@PathVariable String id) {
        return ResponseEntity.ok(prestamoService.calcularCuotas(id));
    }

    @GetMapping("/{id}/saldo")
    public ResponseEntity<BigDecimal> saldo(@PathVariable String id) {
        return ResponseEntity.ok(prestamoService.calcularSaldoPendiente(id));
    }
}
