package com.usuario_gateway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.usuario_gateway.model.Usermodel;
import com.usuario_gateway.repository.User_repository;

@Service
public class User_service {

    @Autowired
    private User_repository userRepository;

    public List<Usermodel> getAll(){
        return userRepository.findAll();
    }

    public Usermodel getById(Integer id){
        Optional<Usermodel> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public Usermodel add(Usermodel user){
        return userRepository.save(user);
    }

    public Usermodel update(Integer id, Usermodel user){
        if (userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public Usermodel delete(Integer id){
        Optional<Usermodel> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.deleteById(id);
        }
        return null;
    }

    
}

