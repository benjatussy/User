package com.usuario_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CorreoDTO {
    private Integer id;
    private String correo;
    private Integer idUsuario; // ← corregido aquí
    private String nombre;
}