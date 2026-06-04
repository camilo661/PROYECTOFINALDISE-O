package com.prestamos.controller;

import com.prestamos.dto.ParametroDTO;
import com.prestamos.service.ParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/parametros")
public class ParametroController {

    @Autowired
    private ParametroService parametroService;

    @GetMapping
    public ResponseEntity<List<ParametroDTO>> listar() {
        return ResponseEntity.ok(parametroService.listarParametros());
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Map<String, String>> obtener(@PathVariable String clave) {
        return ResponseEntity.ok(Map.of("clave", clave,
                "valor", parametroService.consultarParametro(clave)));
    }

    @PutMapping("/{clave}")
    public ResponseEntity<ParametroDTO> actualizar(@PathVariable String clave,
                                                    @RequestBody Map<String, String> body) {
        return ResponseEntity.ok(parametroService.actualizarParametro(clave, body.get("valor")));
    }
}
