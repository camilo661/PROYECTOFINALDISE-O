package com.prestamos.controller;

import com.prestamos.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/cartera")
    public ResponseEntity<Map<String, Object>> cartera() {
        return ResponseEntity.ok(reporteService.generarReporteCartera());
    }

    @GetMapping("/mora")
    public ResponseEntity<Map<String, Object>> mora() {
        return ResponseEntity.ok(reporteService.generarReporteMora());
    }

    @GetMapping("/pagos")
    public ResponseEntity<Map<String, Object>> pagos() {
        return ResponseEntity.ok(reporteService.generarReportePagos());
    }
}
