package com.usuario_gateway.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CorreoDTO {
    private Integer id;
    private String correo;
    private String idUser;
    private String nombre;

}
