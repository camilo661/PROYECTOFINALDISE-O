package com.prestamos.controller;

import com.prestamos.dto.AuthResponseDTO;
import com.prestamos.dto.LoginDTO;
import com.prestamos.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @GetMapping("/logout")
    public ResponseEntity<Map<String, String>> logout() {
        // Con JWT stateless el logout es del lado del cliente (borrar token)
        return ResponseEntity.ok(Map.of("mensaje", "Sesion cerrada. Elimine el token del cliente."));
    }

    @PutMapping("/refresh")
    public ResponseEntity<AuthResponseDTO> refresh(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok(authService.refreshToken(token));
    }

    @PutMapping("/cambiar-password")
    public ResponseEntity<Map<String, String>> cambiarPassword(@RequestBody Map<String, String> body,
            @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        // extraer username del token via el servicio
        authService.cambiarPassword(body.get("username"), body.get("nuevaPassword"));
        return ResponseEntity.ok(Map.of("mensaje", "Password actualizado correctamente"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, String>> delete() {
        return ResponseEntity.ok(Map.of("mensaje", "Operacion no permitida desde este endpoint"));
    }
}
