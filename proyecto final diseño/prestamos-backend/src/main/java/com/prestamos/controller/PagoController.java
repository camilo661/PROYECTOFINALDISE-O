package com.prestamos.controller;

import com.prestamos.dto.PagoDTO;
import com.prestamos.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoDTO> registrar(@RequestBody PagoDTO dto) {
        return ResponseEntity.ok(pagoService.registrarPago(dto));
    }

    @GetMapping("/prestamo/{prestamoId}")
    public ResponseEntity<List<PagoDTO>> porPrestamo(@PathVariable String prestamoId) {
        return ResponseEntity.ok(pagoService.consultarPagosPorPrestamo(prestamoId));
    }

    @GetMapping("/prestamo/{prestamoId}/comprobante/{pagoId}")
    public ResponseEntity<String> comprobante(@PathVariable String prestamoId,
                                               @PathVariable String pagoId) {
        return ResponseEntity.ok(pagoService.generarComprobante(prestamoId, pagoId));
    }
}
