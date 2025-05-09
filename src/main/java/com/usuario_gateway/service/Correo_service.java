package com.usuario_gateway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario_gateway.dto.CorreoDTO;
import com.usuario_gateway.model.Correo;
import com.usuario_gateway.repository.Correo_repository;

@Service
public class Correo_service {

    @Autowired
    private Correo_repository correoRepository;

    public List<Correo> getAll() {
        return correoRepository.findAll();
    }

    public List<CorreoDTO> getAllDTO(){
        return correoRepository.findAll().stream().map(c -> new CorreoDTO(
            c.getId(),
            c.getCorreo(),
            c.getIdUser(),
            c.getNombre()
        )).toList();

    }

    public Correo getById(Integer id) {
        Optional <Correo> correo = correoRepository.findById(id);
        return correo.orElse(null);
    }

    public Correo add(Correo correo) {
        return correoRepository.save(correo);
    }

    public Correo update(Integer id){
        Optional<Correo> correo = correoRepository.findById(id);
        if (correo.isPresent()){
            correoRepository.deleteById(id);
        }
        return null;
    }
}