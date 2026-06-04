package com.prestamos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametroDTO {
    private String id;
    private String clave;
    private String valor;
    private String descripcion;
}
