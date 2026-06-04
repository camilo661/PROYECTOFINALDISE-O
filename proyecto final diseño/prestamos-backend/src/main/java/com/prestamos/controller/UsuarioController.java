package com.prestamos.controller;

import com.prestamos.dto.UsuarioDTO;
import com.prestamos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@RequestBody Map<String, Object> body) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNombre((String) body.get("nombre"));
        dto.setUsername((String) body.get("username"));
        dto.setEmail((String) body.get("email"));
        dto.setRolId((String) body.get("rolId"));
        dto.setTipo((String) body.get("tipo"));
        String password = (String) body.get("password");
        return ResponseEntity.ok(usuarioService.crearUsuario(dto, password));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.consultarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtener(@PathVariable String id) {
        return ResponseEntity.ok(usuarioService.consultarUsuario(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(@PathVariable String id,
                                                  @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, dto));
    }

    @PutMapping("/{id}/rol")
    public ResponseEntity<Map<String, String>> asignarRol(@PathVariable String id,
                                                           @RequestBody Map<String, String> body) {
        usuarioService.asignarRol(id, body.get("rolId"));
        return ResponseEntity.ok(Map.of("mensaje", "Rol asignado correctamente"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> desactivar(@PathVariable String id) {
        usuarioService.cambiarEstado(id, false);
        return ResponseEntity.ok(Map.of("mensaje", "Usuario desactivado"));
    }
}
