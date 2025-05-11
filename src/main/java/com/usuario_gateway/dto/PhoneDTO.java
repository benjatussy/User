package com.usuario_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneDTO {
    private Integer id;
    private String numero;
    private Integer idUsuario; // ← corregido aquí
    private String nombre;
}