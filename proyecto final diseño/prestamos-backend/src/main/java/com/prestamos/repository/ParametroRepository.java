package com.prestamos.repository;

import com.prestamos.model.Parametro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParametroRepository extends MongoRepository<Parametro, String> {
    Optional<Parametro> findByClave(String clave);
}
