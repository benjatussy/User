package com.usuario_gateway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario_gateway.dto.PhoneDTO;
import com.usuario_gateway.model.Telefono;
import com.usuario_gateway.repository.PhoneRepository;

@Service
public class Phone_service {

    @Autowired
    private PhoneRepository phoneRepository;

    // Obtener todos los teléfonos
    public List<Telefono> getAll() {
        return phoneRepository.findAll();
    }

    // Obtener todos los teléfonos como DTO
    public List<PhoneDTO> getAllDTO() {
        return phoneRepository.findAll().stream().map(v -> new PhoneDTO(
            v.getId(),
            v.getNumero(),
            v.getUsuario().getId(),
            v.getUsuario().getNombre()
        )).toList();
    }

    // Obtener un teléfono por su ID
    public Telefono getById(Integer id) {
        Optional<Telefono> phone = phoneRepository.findById(id);
        return phone.orElse(null);
    }

    // Agregar un nuevo teléfono
    public Telefono add(Telefono phone) {
        return phoneRepository.save(phone);
    }

    // Actualizar un teléfono existente
    public Telefono update(Integer id, Telefono phone) {
        if (phoneRepository.existsById(id)) {
            phone.setId(id);
            return phoneRepository.save(phone);
        }
        return null;
    }

    // Eliminar un teléfono
    public boolean delete(Integer id) {
        Optional<Telefono> phone = phoneRepository.findById(id);
        if (phone.isPresent()) {
            phoneRepository.deleteById(id);
            return true; // Indica que el teléfono fue eliminado
        }
        return false; // No se encontró el teléfono para eliminar
    }
}

    
    


