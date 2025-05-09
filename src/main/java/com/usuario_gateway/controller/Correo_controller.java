package com.usuario_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.usuario_gateway.dto.CorreoDTO;
import com.usuario_gateway.model.Correo;
import com.usuario_gateway.service.Correo_service;

@RestController
@RequestMapping("api/v1/correo")
public class Correo_controller {
 @Autowired
    private Correo_service correo_service;

    // Obtener todos los correos (entidad completa)
    @GetMapping
    public ResponseEntity<List<Correo>> getAll() {
        return ResponseEntity.ok(correo_service.getAll());
    }

    // Obtener todos los correos en formato DTO
    @GetMapping("/correosdto")
    public ResponseEntity<List<CorreoDTO>> getAllDTO() {
        // Este método debe existir en Correo_service
        List<CorreoDTO> correosDto = correo_service.getAll().stream().map(c ->
            new CorreoDTO(c.getId(), c.getCorreo(), c.getIdUser(), c.getNombre())
        ).toList();
        return ResponseEntity.ok(correosDto);
    }

    // Obtener un correo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Correo correo = correo_service.getById(id);
        if (correo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Correo no encontrado"));
        }
        return ResponseEntity.ok(correo);
    }

    // Agregar un nuevo correo
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Correo correo) {
        Correo newCorreo = correo_service.add(correo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCorreo);
    }

    // Actualizar un correo existente
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Correo correo){
        Correo updatedCorreo = correo_service.update(id, correo);
        if (updatedCorreo !=null){
            ResponseEntity.ok(updatedCorreo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Correo no encontrado"));
    }

    // Eliminar un correo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Correo deletedCorreo = correo_service.delete(id);
        if (deletedCorreo != null) {
            return ResponseEntity.ok(deletedCorreo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Correo no encontrado"));
    }
}
