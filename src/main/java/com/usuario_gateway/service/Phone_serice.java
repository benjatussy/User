package com.usuario_gateway.service;

import java.util.List;
import java.util.Optional;
//import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario_gateway.dto.PhoneDTO;
import com.usuario_gateway.model.Phone;
import com.usuario_gateway.repository.Phone_repository;

@Service
public class Phone_serice {

    @Autowired
    private Phone_repository phoneRepository;

    public List<Phone> getAll(){
        return phoneRepository.findAll();
    }

    public List<PhoneDTO> getAllDTO(){
        return phoneRepository.findAll().stream().map(v -> new PhoneDTO(
            v.getId(),
            v.getNumero(),
            v.getIdUser(),
            v.getNombre()
        )).toList();
    }

    public Phone getById(Integer id){
        Optional<Phone> phone = phoneRepository.findById(id);
        return phone.orElse(null);
    }

    public Phone add(Phone phone){
        return phoneRepository.save(phone);
    }

    public Phone update(Integer id, Phone phone){
        if (phoneRepository.existsById(id)){
            phone.setId(id);
            return phoneRepository.save(phone);
        }
        return null;
    }

    public Phone delete(Integer id){
        Optional<Phone> phone = phoneRepository.findById(id);
        if (phone.isPresent()){
            phoneRepository.deleteById(id);
        }
        return null;
    }

}

    
    


