package com.prestamos.service;

import com.prestamos.dto.AuthResponseDTO;
import com.prestamos.dto.LoginDTO;
import com.prestamos.model.Rol;
import com.prestamos.model.Usuario;
import com.prestamos.repository.RolRepository;
import com.prestamos.repository.UsuarioRepository;
import com.prestamos.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponseDTO login(LoginDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales invalidas"));

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }
        if (!usuario.isEstado()) {
            throw new RuntimeException("Usuario inactivo");
        }

        String rolNombre = rolRepository.findById(usuario.getRolId())
                .map(Rol::getNombre)
                .orElse("CLIENTE_USUARIO");

        String token = jwtUtil.generarToken(usuario.getUsername(), rolNombre);
        return new AuthResponseDTO(token, usuario.getUsername(), rolNombre);
    }

    public AuthResponseDTO refreshToken(String token) {
        if (!jwtUtil.validarToken(token)) {
            throw new RuntimeException("Token invalido o expirado");
        }
        String newToken = jwtUtil.refreshToken(token);
        String username = jwtUtil.extraerUsername(newToken);
        String rol = jwtUtil.extraerRol(newToken);
        return new AuthResponseDTO(newToken, username, rol);
    }

    public void cambiarPassword(String username, String nuevaPassword) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.cambiarContrasena(passwordEncoder.encode(nuevaPassword));
        usuarioRepository.save(usuario);
    }
}
