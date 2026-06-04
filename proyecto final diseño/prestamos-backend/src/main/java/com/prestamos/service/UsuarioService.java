package com.prestamos.service;

import com.prestamos.dto.UsuarioDTO;
import com.prestamos.model.Rol;
import com.prestamos.model.Usuario;
import com.prestamos.repository.RolRepository;
import com.prestamos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioDTO crearUsuario(UsuarioDTO dto, String passwordPlano) {
        if (usuarioRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username ya en uso: " + dto.getUsername());
        }
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email ya en uso: " + dto.getEmail());
        }
        Usuario usuario = new Usuario(dto.getNombre(), dto.getUsername(),
                passwordEncoder.encode(passwordPlano), dto.getEmail(), dto.getRolId());
        usuario.setTipo(dto.getTipo() != null ? dto.getTipo() : "CLIENTE_USUARIO");
        return toDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO actualizarUsuario(String id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        if (dto.getRolId() != null) usuario.setRolId(dto.getRolId());
        return toDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO consultarUsuario(String id) {
        return usuarioRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
    }

    public List<UsuarioDTO> consultarTodos() {
        return usuarioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void cambiarEstado(String id, boolean estado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        usuario.setEstado(estado);
        usuarioRepository.save(usuario);
    }

    public void asignarRol(String id, String rolId) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        if (!rolRepository.existsById(rolId)) {
            throw new RuntimeException("Rol no encontrado: " + rolId);
        }
        usuario.setRolId(rolId);
        usuarioRepository.save(usuario);
    }

    public boolean cambiarPassword(String id, String nuevaPassword) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
        return usuario.cambiarContrasena(passwordEncoder.encode(nuevaPassword));
    }

    public UsuarioDTO toDTO(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNombre(u.getNombre());
        dto.setUsername(u.getUsername());
        dto.setEmail(u.getEmail());
        dto.setRolId(u.getRolId());
        dto.setEstado(u.isEstado());
        dto.setTipo(u.getTipo());
        return dto;
    }
}
