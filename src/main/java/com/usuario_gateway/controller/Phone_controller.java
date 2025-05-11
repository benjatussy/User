package com.usuario_gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.usuario_gateway.dto.PhoneDTO;
import com.usuario_gateway.model.Telefono;
import com.usuario_gateway.service.Phone_service;

@RestController
@RequestMapping("api/v1/phone")
public class Phone_controller {

    @Autowired
    private Phone_service phone_service;

    @GetMapping
    public ResponseEntity<List<Telefono>>getAll(){
        return ResponseEntity.ok(phone_service.getAll());
    }

    @GetMapping("/phonesdto")
    public ResponseEntity<List<PhoneDTO>> getAllDTO(){
        return ResponseEntity.ok(phone_service.getAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Telefono phone = phone_service.getById(id);
        if(phone == null){
            return ResponseEntity.ok(phone);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Telefono no encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> add(Telefono phone){
        Telefono newPhone = phone_service.add(phone);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPhone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Telefono phone){
        Telefono updatedPhone = phone_service.update(id, phone);
        if(updatedPhone != null){
            return ResponseEntity.ok(updatedPhone);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Telefono no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean deleted = phone_service.delete(id);
        if (deleted) {
            return ResponseEntity.ok(new Mensaje("Teléfono eliminado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje("Teléfono no encontrado"));
    }
    
        

}
