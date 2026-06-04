package com.prestamos.config;

import com.prestamos.model.Parametro;
import com.prestamos.model.Rol;
import com.prestamos.model.Usuario;
import com.prestamos.repository.ParametroRepository;
import com.prestamos.repository.RolRepository;
import com.prestamos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Inicializa datos base: roles, usuario administrador, parametros del sistema
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired private RolRepository rolRepository;
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private ParametroRepository parametroRepository;

    @Override
    public void run(String... args) {
        crearRoles();
        crearAdministrador();
        crearParametros();
    }

    private void crearRoles() {
        if (rolRepository.findByNombre("ADMINISTRADOR").isEmpty()) {
            rolRepository.save(new Rol(null, "ADMINISTRADOR",
                    "Administrador del sistema con acceso total", null));
        }
        if (rolRepository.findByNombre("RECAUDADOR").isEmpty()) {
            rolRepository.save(new Rol(null, "RECAUDADOR",
                    "Recaudador que registra y consulta pagos", null));
        }
        if (rolRepository.findByNombre("CLIENTE_USUARIO").isEmpty()) {
            rolRepository.save(new Rol(null, "CLIENTE_USUARIO",
                    "Cliente con acceso a sus prestamos y pagos", null));
        }
        System.out.println(">>> Roles inicializados");
    }

    private void crearAdministrador() {
        if (!usuarioRepository.existsByUsername("admin")) {
            String rolId = rolRepository.findByNombre("ADMINISTRADOR")
                    .map(r -> r.getId()).orElse(null);
            Usuario admin = new Usuario("Administrador Principal", "admin",
                    passwordEncoder.encode("admin123"), "admin@prestamos.com", rolId);
            admin.setTipo("ADMINISTRADOR");
            usuarioRepository.save(admin);
            System.out.println(">>> Usuario admin creado. Username: admin / Password: admin123");
        }
    }

    private void crearParametros() {
        if (parametroRepository.findByClave("TASA_INTERES_DEFECTO").isEmpty()) {
            parametroRepository.save(new Parametro(null, "TASA_INTERES_DEFECTO", "2.5",
                    "Tasa de interes mensual por defecto (%)"));
        }
        if (parametroRepository.findByClave("MORA_DIAS").isEmpty()) {
            parametroRepository.save(new Parametro(null, "MORA_DIAS", "3",
                    "Dias de gracia antes de aplicar mora"));
        }
        System.out.println(">>> Parametros del sistema inicializados");
    }
}
