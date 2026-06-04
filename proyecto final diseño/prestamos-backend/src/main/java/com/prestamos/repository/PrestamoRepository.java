package com.prestamos.repository;

import com.prestamos.model.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
    List<Prestamo> findByClienteId(String clienteId);
    List<Prestamo> findByEstado(String estado);
    List<Prestamo> findByClienteIdAndEstado(String clienteId, String estado);
    long countByEstado(String estado);
}
