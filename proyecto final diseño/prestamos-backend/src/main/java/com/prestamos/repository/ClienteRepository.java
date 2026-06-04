package com.prestamos.repository;

import com.prestamos.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByCedula(String cedula);
    Optional<Cliente> findByCorreo(String correo);
    boolean existsByCedula(String cedula);
    boolean existsByCorreo(String correo);
}
