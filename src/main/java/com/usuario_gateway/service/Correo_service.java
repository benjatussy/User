package com.usuario_gateway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario_gateway.dto.CorreoDTO;
import com.usuario_gateway.model.Correo;
import com.usuario_gateway.repository.CorreoRepository;

@Service
public class Correo_service {

    @Autowired
    private CorreoRepository correoRepository;

    // Obtener todos los correos
    public List<Correo> getAll() {
        return correoRepository.findAll();
    }

    // Obtener todos los correos pero como DTO
    public List<CorreoDTO> getAllDTO(){
        return correoRepository.findAll().stream().map(c -> new CorreoDTO(
            c.getId(),
            c.getCorreo(),
            c.getUsuario().getId(),
            c.getUsuario().getNombre()
        )).toList();
    }

    // Obtener un correo por su ID
    public Correo getById(Integer id) {
        Optional<Correo> correo = correoRepository.findById(id);
        return correo.orElse(null);
    }

    // Agregar un nuevo correo
    public Correo add(Correo correo) {
        return correoRepository.save(correo);
    }

    // Actualizar un correo existente
    public Correo update(Integer id, Correo correo2){
        Optional<Correo> correo = correoRepository.findById(id);
        if (correo.isPresent()) {
            Correo existingCorreo = correo.get();
            existingCorreo.setCorreo(correo2.getCorreo());
            existingCorreo.setUsuario(correo2.getUsuario());
            return correoRepository.save(existingCorreo);
        }
        return null;
    }

    // Eliminar un correo
    public boolean delete(Integer id) {
        Optional<Correo> correo = correoRepository.findById(id);
        if (correo.isPresent()) {
            correoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}