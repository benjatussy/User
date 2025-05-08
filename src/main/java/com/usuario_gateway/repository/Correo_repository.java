package com.usuario_gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario_gateway.model.Correo;

public interface Correo_repository extends JpaRepository<Correo, Integer> {
    
}
