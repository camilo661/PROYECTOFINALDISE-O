package com.prestamos.service;

import com.prestamos.dto.ParametroDTO;
import com.prestamos.model.Parametro;
import com.prestamos.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParametroService {

    @Autowired
    private ParametroRepository parametroRepository;

    public String consultarParametro(String clave) {
        return parametroRepository.findByClave(clave)
                .map(Parametro::getValor)
                .orElseThrow(() -> new RuntimeException("Parametro no encontrado: " + clave));
    }

    public ParametroDTO actualizarParametro(String clave, String nuevoValor) {
        Parametro p = parametroRepository.findByClave(clave)
                .orElseThrow(() -> new RuntimeException("Parametro no encontrado: " + clave));
        p.setValor(nuevoValor);
        return toDTO(parametroRepository.save(p));
    }

    public List<ParametroDTO> listarParametros() {
        return parametroRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public boolean validarConfiguracion() {
        return parametroRepository.findByClave("TASA_INTERES_DEFECTO").isPresent();
    }

    private ParametroDTO toDTO(Parametro p) {
        return new ParametroDTO(p.getId(), p.getClave(), p.getValor(), p.getDescripcion());
    }
}
