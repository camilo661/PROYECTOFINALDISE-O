package com.prestamos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDTO {
    private String tipoReporte;
    private Date fechaInicio;
    private Date fechaFin;
    private Map<String, Object> filtros;
    private Object datos;
}
